package UPCmvc.development.dto;

/**
 * Created by chenzifeng on 2017/6/12.
 * code:0---status:请求成功
 * code:1---status:出现异常
 * code:2---status:没有权限
 * code:-1---status:无有效信息
 */
public class StatusDto
{
    private int code;
    private String message;

    public StatusDto(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public StatusDto() {
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
