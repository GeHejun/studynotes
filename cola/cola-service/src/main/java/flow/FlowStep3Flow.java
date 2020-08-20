package flow;


import core.*;
import dto.FlowDto;

@BizFlow
public class FlowStep3Flow implements IBizFlow<FlowDto, FlowDto> {

    @Override
    public String getFlowName() {
        return "FlowStep3Flow";
    }

    @Override
    public BizResult<FlowDto> execute(BizContext bizContext, FlowDto bizParam) {
        BizResult bizResult = BizResult.fail(BizErrorE.ERROR_UNKNOWN);
        bizResult.setOperate(BizOperateE.BIZ_ROLLBACK);
        return bizResult;
    }
}
