 namespace java Thrift
 service ThriftDemoUserService {
    string getName(1:i32 id)
    bool isExist(1:string name)
 }