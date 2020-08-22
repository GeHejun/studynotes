package controller;


import core.BizResult;
import dto.FlowDto;
import dto.FlowQueryDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.IFlowTest;

import javax.annotation.Resource;
import java.util.List;


/**
 * 测试控制器接口
 */
@RestController
@RequestMapping("")
public class TestController {

    @Resource
    IFlowTest flowTest;

    @RequestMapping(value = "api/v2/flow/createByType", method = RequestMethod.GET)
    public BizResult<FlowDto> createFlowByType() {
        FlowDto flowDto = new FlowDto();
        flowDto.setBizType("order");
        return flowTest.createByType(flowDto);
    }

    @RequestMapping(value = "api/v2/flow/create", method = RequestMethod.GET)
    public BizResult<FlowDto> createFlow() {
        return flowTest.create(new FlowDto());
    }

    @RequestMapping(value = "api/v2/flow/update", method = RequestMethod.GET)
    public BizResult<FlowDto> updateFlow() {
        return flowTest.update(new FlowDto());
    }

    @RequestMapping(value = "api/v2/flow/find", method = RequestMethod.GET)
    public BizResult<List<FlowDto>> findFlow() {
        return flowTest.find(new FlowQueryDto());
    }
}
