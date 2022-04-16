package com.lhh.seamanrecruit.enums;

/**
 * @author zhh
 * @date 2022/4/11 11:22
 * @description 职位枚举
 */
public enum PositionEnum {

    CAPTAIN("船长"),
    CHIEF_MATE("大副"),
    SECOND_MATE("二副"),
    THIRD_MATE("三副"),
    BOATSWAIN("水手长"),
    ONE_WATER("一水"),
    TOW_WATER("二水"),
    DECK_CADET("甲板实习生"),
    CHEF("大厨"),
    BUTTONS("服务生"),
    CHIEF_ENGINEER("轮机长"),
    LARGE_PIPE_WHEEL("大管轮"),
    SECOND_PIPE_WHEEL("二管轮"),
    THREE_TUBE_WHEEL("三管轮"),
    ELECTRICAL_ENGINEER("电机员"),
    MACHINE_FOREMAN("机工长"),
    MECHANIC("机工"),
    SECOND_MACHINE("二机"),
    ENGINE_CADET("机舱实习生");


    /**
     *
     * @param name
     */
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
