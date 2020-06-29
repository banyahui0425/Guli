package cc.jaya;

import lombok.Data;

@Data
public class RespData {
    private boolean success;
    private int code;
    private String message;
    private Object result;

    private RespData() {
    }

    //right
    public static RespData right() {
        RespData respData = new RespData();
        respData.success = true;
        respData.code = 1;
        respData.message = "调用接口成功";
        return respData;
    }

    public static RespData right(String message) {
        RespData respData = right();
        respData.message = message;
        return respData;
    }

    public static RespData right(Object result) {
        RespData respData = right();
        respData.result = result;
        return respData;
    }

    public static RespData right(String message, Object data) {
        RespData respData = right(data);
        respData.message = message;
        return respData;
    }

    //wrong
    public static RespData wrong(int code) {
        RespData respData = new RespData();
        respData.success = false;
        respData.code = code;
        return respData;
    }

    public static RespData wrong(int code, String message) {
        RespData respData = wrong(code);
        respData.message = message;
        return respData;
    }
}
