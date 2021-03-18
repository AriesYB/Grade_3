package edu.neu.util;
/**
 * ClassName:StatusType
 * Package:edu.neu.util
 * Description:
 *
 * @Date:2019/10/25 12:46
 * @Author:HetFrame
 */
public enum StatusType implements PersistEnum2DB<Integer> {
    未诊(1, "未诊"),
    已诊(2, "已诊"),
    已退号(3, "已退号"),
    ;

    private int code;
    private String msg;

    StatusType(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public Integer getData() {
        return code;
    }

    public static class Converter extends AbstractEnumConverter<StatusType, Integer> {

        public Converter() {
            super(StatusType.class);
        }
    }
}
