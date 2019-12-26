package common;

public enum ResultStatusEnum {
    SUCCESS(200,"SUCCESS","成功"),//成功
    ERROR(500,"ERROR","失败"),//失败
    NEED_LOGIN(10,"NEED_LOGIN","未登录"),//未登录
    ILLEGAL_ARGUMENT(400,"ILLEGAL_ARGUMENT","错误参数"),//错误参数
    LOGICAL_EXCEPTION(1000,"LOGICAL_EXCEPTION","try catch异常");//用于try catch 测试

    private final int code;

    private final String desc;

    private final String productDescription;

    ResultStatusEnum(int code, String desc, String productDescription){
        this.code = code;
        this.desc = desc;
        this.productDescription = productDescription;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public String getProductDescription() {
        return productDescription;
    }
}
