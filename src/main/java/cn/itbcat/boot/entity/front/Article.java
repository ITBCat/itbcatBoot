package cn.itbcat.boot.entity.front;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by 860117030 on 2017/10/14.
 */
@Entity
@Table(name="itbc_article")
public class Article {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id",unique = true,nullable = false,length = 20)
    private String id;

    @Column(name="user_id",nullable = false,length = 20)
    private String userid;

    @Column(name="title",nullable = false,length = 255)
    private String title;

    @Column(name="data")
    private Date date;

    @Column(name = "article_md",columnDefinition="text")
    private String md;

    @Column(name="article_html",columnDefinition="text")
    private String html;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMd() {
        return md;
    }

    public void setMd(String md) {
        this.md = md;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
}
