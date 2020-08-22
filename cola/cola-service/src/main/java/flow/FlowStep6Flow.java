package flow;


import core.*;
import dto.FlowDto;

@BizFlow1(type = "order")
public class FlowStep6Flow implements IBizFlow<FlowDto, FlowDto> {

    @Override
    public String getFlowName() {
        return "FlowStep6Flow";
    }

    @Override
    public BizResult<FlowDto> execute(BizContext bizContext, FlowDto bizParam) {
        BizResult bizResult = BizResult.fail(BizErrorE.ERROR_UNKNOWN);
        bizResult.setOperate(BizOperateE.BIZ_ROLLBACK);
        return bizResult;
    }
}
