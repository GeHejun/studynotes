package flow;


import core.BizContext;
import core.BizFlow1;
import core.BizResult;
import core.IBizFlow;
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
