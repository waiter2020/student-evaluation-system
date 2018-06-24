package UPCmvc.development.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by chenzifeng on 2017/4/30.
 */
@Entity
@JsonIgnoreProperties(value = "createAt"+"updateAt"+"isdelete")
@Table(name = "DevReport")
public class DevReport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int drId;//确定申报项目的类别,与commen包中发展评分细则的id相同
    private String studentName;//学生姓名
    private int studentNo;//学号
    private String content;//申报内容
    private double num;//评分
    private int Approve;//是否批准 0-未审核，1-成功，-1-失败
    private String file;//上传文件路径
    private boolean isdeal;

    private int classId;


    private long createAt;
    private long updateAt;
    private boolean isdelete;

    private String feedback;

    public DevReport(int drId, String studentName, int studentNo,String content,double num) {
        this.drId = drId;
        this.studentName = studentName;
        this.studentNo = studentNo;
        this.content =content;
        this.num = num;
        this.Approve = 0;
        this.isdeal = false;
        createAt = System.currentTimeMillis();
        updateAt = createAt;
        isdelete = false;
    }

    public DevReport() {
        this.Approve = 0;
        this.isdeal = false;
        createAt = System.currentTimeMillis();
        updateAt = createAt;
        isdelete = false;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDrId() {
        return drId;
    }

    public void setDrId(int drId) {
        this.drId = drId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }

    public int  getApprove() {
        return Approve;
    }

    public void setApprove(int approve) {
        Approve = approve;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public boolean isIsdeal() {
        return isdeal;
    }

    public void setIsdeal(boolean isdeal) {
        this.isdeal = isdeal;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }

    public boolean isIsdelete() {
        return isdelete;
    }

    public void setIsdelete(boolean isdelete) {
        this.isdelete = isdelete;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
