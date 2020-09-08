package com.zq.exception;

public enum FprResponseEnum implements CommonException {
    //成功
    DEFAULT_OK("200","成功","OK"),
    //错误
    DEFAULT_ERROR("900","失败","ERROR"),
    //通用异常
    PARAMS_ERROR("9001","参数错误","Parameter error"),
    APP_TOKEN_FAIL("9002","获取AppToken失败","Failed to get AppToken"),
    PERMISSION_NOT("9003","权限不足","Insufficient authority"),
    //用户相关
    TOKEN_NULL("10001","token不能为空","Token cannot be empty"),
    TOKEN_FAIL("10002","token不正确","Incorrect token"),
    USER_EXIST("10003","用户已存在","User already exists"),
    PHONE_EXIST("10004","手机已注册","Phone registered"),
    PHONE_NOT_EXIST("10005","手机号未注册","Phone not registered"),
    CODE_VERIFY_ERROR("10006","验证码错误","Verification code error"),
    NAME_PWD_ERROR("10007","账号或密码错误","Wrong account or password"),
    USER_NO_OPERATION("10008","用户没有操作权限","The user has no operation permission"),
    PHONE_FORMAT_ERROR("10009","手机号格式不正确","Incorrect format of mobile phone number"),
    EMAIL_FORMAT_ERROR("10010","邮箱格式不正确","Incorrect format of email"),
    REGISTER_MOBILE_CORPORATE_ERROR("10011","账户注册过企业账号，告知输入企业密码登陆","Account registered enterprise account, inform to enter the enterprise password login"),
    REGISTER_MOBILE_PERSONAL_ERROR("10012","账户已经注册过个人账号，告知直接输入密码","The account has registered personal account number. Please input the password directly"),
    PWD_FORMAT_ERROR("10013","密码格式错误，密码长度至少应大于8位，包括字母和数字","The password format is wrong. The password length should be at least 8 digits, including letters and numbers"),
    PWD_OLD_ERROR("10014","旧密码错误","Old password error"),
    //产品相关
    PRODUCT_EXIST("20001","产品已存在","Product already exists"),
    PRODUCT_NOT_EXIST("20002","产品不存在","Product does not exist"),
    BRAND_EXIST("20003","品牌已存在","Brand already exists"),
    BRAND_NOT_EXIST("20004","品牌不存在","Brand does not exist"),
    CATEGORY_EXIST("20005","品类已存在","Category already exists"),
    CATEGORY_NOT_EXIST("20006","品类不存在","Category does not exist"),
    CATEGORY_PARAM_TEMPLATE_EXIST("20007","品类参数模板已存在","Category parameter template already exists"),
    CATEGORY_PARAM_TEMPLATE_NOT_EXIST("20008","品类参数模板不存在","Category parameter template does not exist"),
    //新闻
    NEWS_EXIST("30001","新闻已存在","News already exists"),
    NEWS_NOT_EXIST("30002","新闻不存在","News does not exist"),
    //广告
    ADVERT_EXIST("40001","广告已存在","Advertisement already exists"),
    ADVERT_NOT_EXIST("40002","广告不存在","Advertisement does not exist"),
    //企业
    COMPANY_EXIST("50001","企业已存在","Enterprise already exists"),
    COMPANY_NOT_EXIST("50002","企业不存在","Enterprise does not exist"),
    //评论
    COMMENT_CONTENT_ILLEGALITY("60001","您的评论内容存在敏感词,请重新评论","There are sensitive words in your comment. Please comment again")
    ;
    private final String code;
    private String message;
    private String date;

    FprResponseEnum(String code, String message,String date) {
        this.code = code;
        this.message = message;
        this.date = date;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public String getDate() {
        return this.date;
    }

    @Override
    public CommonException setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public CommonException setDate(String date) {
        this.date = date;
        return this;
    }


}
