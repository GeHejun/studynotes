package core;

public interface IBizFlow<R, P extends BizParam> {

    String getFlowName();

    BizResult execute(BizContext bizContext, P bizParam);

    default Boolean rollback(BizContext bizContext) {
        return true;
    }

}
