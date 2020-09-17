package server;

import org.apache.thrift.TException;
import thrift.ThriftDemoUserService;

public class ServerThriftDemoUserServiceImpl implements ThriftDemoUserService.Iface {

    @Override
    public String getName(int id) throws TException {
        if (id == 1) {
            return "小明1";
        }
        if (id == 2) {
            return "小明2";
        }
        return "id:" + id + "对应的用户不存在";
    }

    @Override
    public boolean isExist(String name) throws TException {
        return "小明1".contains(name) || "小明2".contains(name);
    }
}
