package cn.itbcat.boot.entity.front;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by 860117030 on 2017/10/18.
 */
@Entity
@Table(name = "itbc_comment")
public class Comment {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id",unique = true,nullable = false,length = 20)
    private String id;

    @Column(name="article_id",length = 20)
    private String articleId;

    @Column(name = "user_id",length = 20)
    private String userId;

    @Column(name = "parent_id",length = 20)
    private String parentId;

    @Column(name = "content",columnDefinition="mediumtext",length = 0)
    private String content;

    @Column(name="create_time")
    private Date createTime;

    @Column(name="update_time")
    private Date updateTime;

    @Transient
    private List<Comment> comments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
