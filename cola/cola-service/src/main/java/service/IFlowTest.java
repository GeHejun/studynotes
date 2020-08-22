package service;


import core.BizResult;
import dto.FlowDto;
import dto.FlowQueryDto;

import java.util.List;

public interface IFlowTest {
    BizResult<FlowDto> createByType(FlowDto flowDto);

    BizResult<FlowDto> create(FlowDto flowDto);

    BizResult<FlowDto> update(FlowDto flowDto);

    BizResult<List<FlowDto>> find(FlowQueryDto flowQuery);
}
