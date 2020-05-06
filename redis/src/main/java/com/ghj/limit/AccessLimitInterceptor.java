package com.ghj.limit;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * @author gehj
 * @version 1.0
 * @description 限流拦截器
 * @date 2019/12/15 13:54
 */
@Component
public class AccessLimitInterceptor implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            if (handler instanceof HandlerMethod) {
                HandlerMethod handlerMethod = (HandlerMethod) handler;
                Method method = handlerMethod.getMethod();
                if (!method.isAnnotationPresent(AccessLimit.class)) {
                    return true;
                }
                AccessLimit accessLimit = method.getAnnotation(AccessLimit.class);
                if (accessLimit == null) {
                    return true;
                }
                int limit = accessLimit.limit();
                int sec = accessLimit.sec();
                String key = IPUtil.getIpAddr(request) + request.getRequestURI();
                String maxLimit = stringRedisTemplate.opsForValue().get(key);
                if (maxLimit == null) {
                    //set时一定要加过期时间
                    stringRedisTemplate.opsForValue().set(key, "1", sec, TimeUnit.MILLISECONDS);
                } else if (Integer.parseInt(maxLimit) < limit) {
                    stringRedisTemplate.opsForValue().set(key, String.valueOf(Integer.parseInt(maxLimit) + 1), sec , TimeUnit.MILLISECONDS);
                } else {
                    output(response,  "访问过于频繁");
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            return true;
        }

    }

    public void output(HttpServletResponse response, String msg) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            outputStream.write(msg.getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            outputStream.flush();
            outputStream.close();
        }
    }



    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)  {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)  {

    }

}
