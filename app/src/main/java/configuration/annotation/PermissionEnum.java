package configuration.annotation;

public enum PermissionEnum {
    A("0000", "权限设置"),
    B("1000", "删除新闻"),
    C("2000", "添加模板")
    ;
    private final String code;
    private final String permission;

    PermissionEnum(String code, String permission) {
        this.code = code;
        this.permission = permission;
    }

    public String getCode() {
        return code;
    }
}
