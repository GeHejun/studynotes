package executor;

import annotation.ThriftClass;
import annotation.ThriftMethod;
import org.springframework.stereotype.Service;

@Service
@ThriftClass
public class TestExecutor1 {

    @ThriftMethod
    public void testExecutor1() {
        System.out.println("testExecutor1");
    }
}
