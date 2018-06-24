package UPCmvc.common.model;

import javax.persistence.*;

/**
 * Created by wanghaojun on 2017/6/14.
 */
@Entity
@Table(name = "com_standard_development")
public class StandardDev {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String content;

    public StandardDev() {
    }

    public StandardDev(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
