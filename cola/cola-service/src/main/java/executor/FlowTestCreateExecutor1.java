package executor;


import core.BizContext;
import core.BizExecutor;
import core.BizExecutor1;
import core.BizResult;
import dto.FlowDto;
import flow.FlowStep1Flow;
import flow.FlowStep2Flow;
import flow.FlowStep3Flow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FlowTestCreateExecutor1 {

    public BizResult<FlowDto> executor(FlowDto flowDto) {
        return (BizResult<FlowDto>) BizExecutor1.execute(flowDto);
    }

}
