package core;

import java.util.Objects;
import java.util.Stack;


public class BizExecutor {

    public static BizResult<?> execute(BizContext bizContext, BizParam bizParam, IBizFlow<?, ?>... bizFlows) {
        BizResult<?> bizResult = BizResult.success();
        Stack<IBizFlow<?, ?>> flowStack = new Stack<>();
        boolean needRollback = false;

        for (IBizFlow bizFlow : bizFlows) {
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
