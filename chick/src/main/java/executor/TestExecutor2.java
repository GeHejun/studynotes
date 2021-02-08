package executor;

import annotation.ThriftClass;
import annotation.ThriftMethod;
import org.springframework.stereotype.Service;

/**
 * @author gehejun
 */
@Service
@ThriftClass
public class TestExecutor2 {

    @ThriftMethod
    public void testExecutor2() {
        throw new RuntimeException("aaa");
    }
}
