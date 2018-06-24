package UPCmvc.evaluations.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by waiter on 18-4-17.
 */
@Entity
@Table(name = "g_record")
public class GroupRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    private String evaluatorId;
    private int classId;
    private String beEvaluatedId;
    private String beEvaluatedName;
    private Date evaluationDate;
    private double grade;
    private boolean iscommit;
    private char rank;
    public GroupRecord(){}



    /***

     *
     * @param evaluatorId 评价者学号
     * @param beEvaluatedId 被评价者学号
     * @param beEvaluatedName 被评价人姓名
     * @param evaluationDate 评价时间
     * @param grade 得分
     * @param iscommit 是否已提交
     */
    public GroupRecord(String evaluatorId, int classId,String beEvaluatedId,String beEvaluatedName, Date evaluationDate, double grade,boolean iscommit) {
        this.evaluatorId = evaluatorId;
        this.beEvaluatedId = beEvaluatedId;
        this.evaluationDate = evaluationDate;
        this.grade = grade;
        this.beEvaluatedName=beEvaluatedName;
        this.iscommit=iscommit;
        this.classId=classId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEvaluatorId(String evaluatorId) {
        this.evaluatorId = evaluatorId;
    }

    public void setBeEvaluatedId(String beEvaluatedId) {
        this.beEvaluatedId = beEvaluatedId;
    }

    public void setEvaluationDate(Date evaluationDate) {
        this.evaluationDate = evaluationDate;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getId() {
        return id;

    }

    public String getEvaluatorId() {
        return evaluatorId;
    }

    public String getBeEvaluatedId() {
        return beEvaluatedId;
    }

    public Date getEvaluationDate() {
        return evaluationDate;
    }

    public double getGrade() {
        return grade;
    }
    public String getBeEvaluatedName() {
        return beEvaluatedName;
    }

    public boolean isIscommit() {
        return iscommit;
    }

    public void setBeEvaluatedName(String beEvaluatedName) {
        this.beEvaluatedName = beEvaluatedName;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public void setIscommit(boolean iscommit) {
        this.iscommit = iscommit;
    }

    public void setRank(char rank) {
        this.rank = rank;
    }

    public char getRank() {
        return rank;
    }
}
