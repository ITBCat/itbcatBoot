package cn.itbcat.boot.entity;

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
}
