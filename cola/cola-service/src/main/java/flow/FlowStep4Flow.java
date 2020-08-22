package flow;


import core.*;
import dto.FlowDto;

@BizFlow1
public class FlowStep4Flow implements IBizFlow<FlowDto, FlowDto> {

    @Override
    public String getFlowName() {
        return "FlowStep4Flow";
    }

    @Override
    public BizResult<FlowDto> execute(BizContext bizContext, FlowDto bizParam) {
        return BizResult.withData(bizParam);
    }

}
