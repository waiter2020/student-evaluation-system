package UPCmvc.development.model;

import javax.persistence.*;

/**
 * Created by chenzifeng on 2017/6/14.
 */
@Entity
@Table(name = "dev_score")
public class DevScore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private double num;
    private int studentid;

    public DevScore(double num, int studentid) {
        this.num = num;
        this.studentid = studentid;
    }

    public DevScore() {
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }
}
