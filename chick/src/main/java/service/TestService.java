package service;

import annotation.Rollback;
import executor.TestExecutor1;
import executor.TestExecutor2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author gehejun
 */
@Service
public class TestService {

    @Resource
    TestExecutor1 executor1;

    @Resource
    TestExecutor2 executor2;

    @Rollback
    public void test() {
        executor1.testExecutor1();
        executor2.testExecutor2();
    }
}
