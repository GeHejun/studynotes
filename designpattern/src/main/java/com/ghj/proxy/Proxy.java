package com.ghj.proxy;
import com.sun.org.apache.xpath.internal.operations.Mod;
import sun.reflect.misc.ReflectUtil;

import java.io.IOException;
import java.lang.reflect.*;

import java.lang.reflect.InvocationHandler;
import java.util.*;

/**
 * @author gehj
 * @version 1.0
 * @description TODO
 * @date 2019/9/26 9:16
 */
public class Proxy {

    /**
     * 缓存
     */
    private Map<ClassLoader, Map<String, Object>> proxyCache = new WeakHashMap<>();

    private static final String proxyMarker = "$";

    private static final String proxySuffix = "proxy";



    InvocationHandler h;

    /**
     * 生成代理类
     * @return
     */
    public static Proxy generateProxy(ClassLoader cl, Class[] classes, InvocationHandler h) throws IOException, ClassNotFoundException {
        for (Class c : classes) {
            if (!c .isInterface()) {
                throw new RuntimeException("classes must be interface[]");
            }
            ClassDescriber classDescriber = new ClassDescriber();
            //包名
            classDescriber.setPkg(c.getPackage().getName());
            //代理类的名称
            classDescriber.setName(c.getName() + proxyMarker + proxySuffix);
            //实现接口名称
            classDescriber.setInterfaceName(c.getName());
            //继承类的名称
            classDescriber.setExtendName(Proxy.class.getName());
            List<ClassDescriber.MethodDescriber> methodDescriberList = new ArrayList<>(4);
            //类描述
            for (Method method : c.getMethods()) {
                ClassDescriber.MethodDescriber methodDescriber =  classDescriber.new MethodDescriber(method.getModifiers(), method.getReturnType(), method.getParameterTypes(), method.getName());
                methodDescriberList.add(methodDescriber);
            }
            classDescriber.setMethodDescribers(methodDescriberList);
            //依赖包
            String dependOnPkg = h.getClass().getPackage().getName();
            String[] dependOnPkgs = new String[]{dependOnPkg};
            classDescriber.setDependOnPkgs(dependOnPkgs);
            classDescriber.setClassLoader(cl);
            classDescriber.generateClass();
        }
        return null;
    }
}
