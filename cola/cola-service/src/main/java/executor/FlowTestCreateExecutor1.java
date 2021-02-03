package executor;


import core.BizExecutor1;
import core.BizResult;
import dto.FlowDto;
import org.springframework.stereotype.Component;

@Component
public class FlowTestCreateExecutor1 {

    public BizResult<FlowDto> executor(FlowDto flowDto) {
        return (BizResult<FlowDto>) BizExecutor1.execute(flowDto);
    }

}
