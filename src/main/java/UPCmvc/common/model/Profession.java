package UPCmvc.common.model;

import javax.persistence.*;

/**
 * Created by wanghaojun on 2017/4/6.
 *专业类
 * professionName 专业名称
 */
@Entity
@Table(name = "com_profession")
public class Profession {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String professionName;


    public Profession() {
    }

    public Profession(String professionName, String college) {
        this.professionName = professionName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }




}
