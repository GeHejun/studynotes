package service.impl;


import core.BizResult;
import dto.FlowDto;
import dto.FlowQueryDto;
import executor.FlowTestCreateExecutor;
import executor.FlowTestCreateExecutor1;
import executor.FlowTestFindExecutor;
import executor.FlowTestUpdateExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.IFlowTest;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FlowTestImpl implements IFlowTest {

    @Resource
    private FlowTestCreateExecutor1 flowTestCreateExecutor1;
    @Autowired
    private FlowTestUpdateExecutor flowTestUpdateExecutor;
    @Autowired
    private FlowTestFindExecutor flowTestFindExecutor;
    @Autowired
    private FlowTestCreateExecutor flowTestCreateExecutor;

    @Override
    public BizResult<FlowDto> createByType(FlowDto flowDto) {
        return flowTestCreateExecutor1.executor(flowDto);
    }

    @Override
    public BizResult<FlowDto> create(FlowDto flowDto) {
        return flowTestCreateExecutor.executor(flowDto);
    }

    @Override
    public BizResult<FlowDto> update(FlowDto flowDto) {
        return flowTestUpdateExecutor.executor(flowDto);
    }

    @Override
    public BizResult<List<FlowDto>> find(FlowQueryDto flowQuery) {
        return flowTestFindExecutor.execute(flowQuery);
    }

}
