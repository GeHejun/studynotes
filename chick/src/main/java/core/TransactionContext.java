package core;

import java.util.Arrays;

/**
 * @author gehejun
 */
public class TransactionContext {

    Thread currentThread;

    Object[] params;

    Boolean isNeedRollback;

    Boolean isNeedRetry;


    public void setParams(Object[] params) {
        this.params = params;
    }

    public Object[] getParams() {
        return params;
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

    public void setCurrentThread(Thread currentThread) {
        this.currentThread = currentThread;
    }

    public Thread getCurrentThread() {
        return currentThread;
    }

    @Override
    public String toString() {
        return "TransactionContext{" +
                "params=" + Arrays.toString(params) +
                ", isNeedRollback=" + isNeedRollback +
                ", isNeedRetry=" + isNeedRetry +
                ", currentThread=" + currentThread +
                '}';
    }
}
