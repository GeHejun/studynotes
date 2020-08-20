package executor;

import core.BizResult;
import dto.FlowDto;
import dto.FlowQueryDto;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class FlowTestFindExecutor {
    public BizResult<List<FlowDto>> execute(FlowQueryDto flowQuery) {
        return BizResult.withData(Collections.singletonList(new FlowDto()));
    }
}
