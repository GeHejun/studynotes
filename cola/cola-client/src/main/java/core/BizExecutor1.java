package core;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.ui.context.support.UiApplicationContextUtils;

import javax.annotation.Resource;
import java.util.*;


public class BizExecutor1 {


    private static List<IBizFlow> getCanUsedBizFlow(BizParam bizParam) {
        List<IBizFlow> bizFlowList = new ArrayList<>();
        BizBootstrap1.getFlowBeans().forEach((k, v) -> {
            BizFlow1 annotation = v.getClass().getAnnotation(BizFlow1.class);
            if (annotation.type().equals(bizParam.getBizType())) {
                bizFlowList.add((IBizFlow) v);
            }
        });
        Collections.sort(bizFlowList, Comparator.comparing(x -> x.getClass().getAnnotation(BizFlow1.class).order()));
        return bizFlowList;
    }

    public static BizResult<?> execute(BizParam bizParam) {
        BizContext bizContext = new BizContext();
        BizResult<?> bizResult = BizResult.success();
        Stack<IBizFlow<?, ?>> flowStack = new Stack<>();
        boolean needRollback = false;
        for (IBizFlow bizFlow : getCanUsedBizFlow(bizParam)) {
            flowStack.push(bizFlow);
            System.out.println(bizFlow.getFlowName() + " =》 执行中");
            bizResult = bizFlow.execute(bizContext, bizParam);
            System.out.println(bizFlow.getFlowName() + " =》 执行结果：" + bizResult.getErrorDesc());
            if (bizResult.needRollback()) {
                needRollback = true;
                break;
            }
            if (bizResult.needBreak()) {
                break;
            }
        }
        if (!needRollback) {
            flowStack.clear();
            return bizResult;
        }
        // 检查是否需要回滚
        while (needRollback && !flowStack.empty()) {
            IBizFlow bizFlow = flowStack.pop();
            System.out.println(bizFlow.getFlowName() + " =》 回滚中");
            if (!bizFlow.rollback(bizContext)) {
                System.out.println(bizFlow.getFlowName() + " =》 回滚失败");
                break;
            }
            System.out.println(bizFlow.getFlowName() + " =》 回滚成功");
        }
        return bizResult;
    }

    private void executeRollback(BizContext bizContext, Stack<IBizFlow<?, ?>> flowStack) {
        while (true) {
            IBizFlow bizFlow = flowStack.pop();
            if (Objects.isNull(bizFlow)) {
                break;
            }
            bizFlow.rollback(bizContext);
        }
    }
}
