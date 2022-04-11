package com.lhh.seamanrecruit.enums;

/**
 * @author zhh
 * @date 2022/4/11 11:22
 * @description
 */
public enum PositionEnum {

    BULK_CARGO_SHIP("散货船"),
    PASSENGER_CARGO_SHIP("客货船"),
    CONTAINER_SHIP("集装箱船"),
    RO_RO_SHIP("滚装船"),
    CARGO_BARGE_SHIP("载驳货船"),
    ORDINARY_CARGO_SHIP("普通货船"),
    TANKER_SHIP("油船"),
    LIQUEFIED_GAS_SHIP("液化气体船"),
    DUAL_PURPOSE_SHIP("兼用船"),
    OTHER_TYPES("其他类型");


    private PositionEnum(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
