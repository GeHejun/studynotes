package flow;


import core.BizContext;
import core.BizFlow;
import core.BizResult;
import core.IBizFlow;
import dto.FlowDto;

@BizFlow
public class FlowStep2Flow implements IBizFlow<FlowDto, FlowDto> {

    @Override
    public String getFlowName() {
        return "FlowStep2Flow";
    }

    @Override
    public BizResult<FlowDto> execute(BizContext bizContext, FlowDto bizParam) {
        return BizResult.withData(bizParam);
    }

}
