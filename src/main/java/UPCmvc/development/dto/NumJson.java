package UPCmvc.development.dto;

/**
 * Created by chenzifeng on 2017/6/13.
 */
public class NumJson {

    private int message;
    private double num;

    public NumJson(int message, double num) {
        this.message = message;
        this.num = num;
    }

    public NumJson() {
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }
}
