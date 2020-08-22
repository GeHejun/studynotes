package executor;


import core.BizContext;
import core.BizExecutor;
import core.BizResult;
import dto.FlowDto;
import flow.FlowStep1Flow;
import flow.FlowStep2Flow;
import flow.FlowStep3Flow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FlowTestCreateExecutor {
    @Autowired
    private FlowStep1Flow flowStep1Flow;
    @Autowired
    private FlowStep2Flow flowStep2Flow;
    @Autowired
    private FlowStep3Flow flowStep3Flow;

    public BizResult<FlowDto> executor(FlowDto flowDto) {
        BizContext context = new BizContext();
        return (BizResult<FlowDto>) BizExecutor.execute(context, flowDto, flowStep1Flow, flowStep2Flow, flowStep3Flow);
    }

}
