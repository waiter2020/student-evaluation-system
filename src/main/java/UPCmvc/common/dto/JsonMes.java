package UPCmvc.common.dto;

/**
 * Created by wanghaojun on 2017/4/7.
 */
public class JsonMes {

    private int code;
    private String message;

    public JsonMes() {
    }

    public JsonMes(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
