package core;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BizResult<T> {
    private String errorCode;
    private String errorDesc;
    private List<BizErrorI> errorList = new ArrayList<BizErrorI>();
    private Integer total;
    private T data;
    private BizOperateE operate;

    public BizResult() {
    }

    protected BizResult(BizErrorI bizError) {
        this.errorCode = bizError.getCode();
        this.errorDesc = bizError.getDesc();
    }

    public static <T> BizResult<T> success() {
        return new BizResult<>(BizErrorE.ERROR_SUCCESS);
    }

    public static <T> BizResult<T> fail(BizErrorI bizError) {
        return new BizResult<>(bizError);
    }

    public static <T> BizResult<T> withData(T data) {
        BizResult<T> bizResult = success();
        bizResult.data = data;
        return bizResult;
    }

    public static <T> BizResult<T> withData(T data, Integer total) {
        BizResult<T> bizResult = success();
        bizResult.data = data;
        bizResult.total = total;
        return bizResult;
    }

    public Boolean isSuccess() {
        return Objects.equals(errorCode, BizErrorE.ERROR_SUCCESS.getCode());
    }

    public Boolean isFailed() {
        return !isSuccess();
    }

//    public Boolean needContinue() {
//        if (isSuccess()) {
//            return true;
//        }
//        return Objects.equals(operate, BizOperateE.BIZ_CONTINUE);
//    }

    public Boolean needBreak() {
        if (isSuccess()) {
            return false;
        }
        return Objects.equals(operate, BizOperateE.BIZ_BREAK);
    }

    public void setOperate(BizOperateE operate) {
        this.operate = operate;
    }

    public Boolean needRollback() {
        if (isSuccess()) {
            return false;
        }
        return Objects.equals(operate, BizOperateE.BIZ_ROLLBACK);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public List<BizErrorI> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<BizErrorI> errorList) {
        this.errorList = errorList;
    }

    public void addError(BizErrorI bizError) {
        this.errorList.add(bizError);
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
