package flow;


import core.BizContext;
import core.BizFlow1;
import core.BizResult;
import core.IBizFlow;
import dto.FlowDto;

@BizFlow1(type = "order")
public class FlowStep5Flow implements IBizFlow<FlowDto, FlowDto> {

    @Override
    public String getFlowName() {
        return "FlowStep5Flow";
    }

    @Override
    public BizResult<FlowDto> execute(BizContext bizContext, FlowDto bizParam) {
        return BizResult.withData(bizParam);
    }

}
