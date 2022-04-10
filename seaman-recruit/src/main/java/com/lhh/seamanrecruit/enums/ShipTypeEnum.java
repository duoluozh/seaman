package com.lhh.seamanrecruit.enums;

/**
 * @author zhh
 * @date 2022/4/11 1:10
 * @description 船舶类型
 */
public enum ShipTypeEnum {

    BULK_CARGO_SHIP(1,"散货船"),
    PASSENGER_CARGO_SHIP(2,"客货船"),
    CONTAINER_SHIP(3,"集装箱船"),
    RO_RO_SHIP(4,"滚装船"),
    CARGO_BARGE_SHIP(5,"载驳货船"),
    ORDINARY_CARGO_SHIP(6,"普通货船"),
    TANKER_SHIP(7,"油船"),
    LIQUEFIED_GAS_SHIP(8,"液化气体船"),
    DUAL_PURPOSE_SHIP(9,"兼用船"),
    OTHER_TYPES(10,"其他类型");


    private ShipTypeEnum(Integer code, String typeName) {
        this.code = code;
        this.typeName = typeName;
    }

    private Integer code;

    private String typeName;

    public Integer getCode() {
        return code;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
