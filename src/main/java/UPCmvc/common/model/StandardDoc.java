package UPCmvc.common.model;

import javax.persistence.*;

/**
 * Created by wanghaojun on 2017/4/17.
 * 标准类，存放纪实项目和科技学分的审核标准
 * content 审核标准
 */
@Entity
@Table(name = "com_standard_documentary")
public class StandardDoc {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String content;

    public StandardDoc() {
    }

    public StandardDoc(String content) {
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
