package core;

/**
 * @author gehejun
 */
public class TransactionContext {

    ThreadLocal<TransactionContext> context = new InheritableThreadLocal<>();

    String params;

    Boolean isNeedRollback;

    Boolean isNeedRetry;

    public ThreadLocal<TransactionContext> getContext() {
        return context;
    }

    public void setContext(ThreadLocal<TransactionContext> context) {
        this.context = context;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public Boolean getNeedRollback() {
        return isNeedRollback;
    }

    public void setNeedRollback(Boolean needRollback) {
        isNeedRollback = needRollback;
    }

    public Boolean getNeedRetry() {
        return isNeedRetry;
    }

    public void setNeedRetry(Boolean needRetry) {
        isNeedRetry = needRetry;
    }
}
