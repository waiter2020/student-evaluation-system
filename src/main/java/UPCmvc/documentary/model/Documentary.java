package UPCmvc.documentary.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zfl on 2017/4/30.用于班长记录和导员同意
 */

@Entity
@Table(name = "doc_project")
public class Documentary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;

    private int studentNumber;
    private int projectNumber;
    private int score;
    private boolean isAgree;
    private Date date;
    private String text;//备注

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Documentary() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Documentary(int studentNumber, int projectNumber, int score, boolean isAgree,String text) {
        this.studentNumber = studentNumber;
        this.projectNumber = projectNumber;
        this.isAgree = isAgree;
        this.score = score;
        this.text = text;
        this.date = new Date();
    }
    public Documentary(int studentNumber, int projectNumber, int score,String text) {
        this.studentNumber = studentNumber;
        this.projectNumber = projectNumber;
        this.score = score;
        this.text = text;
        this.date = new Date();
    }
    public Documentary(int id,int studentNumber, int projectNumber, int score, boolean isAgree) {
        this.studentNumber = studentNumber;
        this.projectNumber = projectNumber;
        this.isAgree = isAgree;
        this.score = score;
        this.date = new Date();
    }
    public int getStudentNumber() {
        return studentNumber;
    }

    public int getProjectNumber() {
        return projectNumber;
    }

    public boolean isAgree() {
        return isAgree;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void setProjectNumber(int projectNumber) {
        this.projectNumber = projectNumber;
    }

    public void setAgree(boolean agree) {
        isAgree = agree;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
