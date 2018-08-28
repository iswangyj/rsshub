package com.test.enums;

/**
 * @author Wyj
 * @date 2018/8/20
 */
public enum StateEnum {
    /**
     * 数据库操作状态
     */
    SUCCESS(0, "操作成功"),

    ID_ERROR(-1,"非法ID"),

    INSERT_ERROR(-2,"插入失败"),

    UPDATE_ERROR(-3,"更新失败"),

    DELETE_ERROR(-4,"更新失败"),

    OBJECT_IS_DELETED(-5,"对象已被删除"),

    INNER_ERROR(-1001," 操作失败 ");

    private int state;
    private String msg;

    StateEnum(int state, String msg) {
        this.state = state;
        this.msg = msg;
    }

    public int getState() {
        return state;
    }

    public String getMsg() {
        return msg;
    }

    public static StateEnum stateOf(int index) {
        for (StateEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}
