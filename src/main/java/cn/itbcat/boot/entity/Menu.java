package cn.itbcat.boot.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by 860117030 on 2017/9/6.
 */
@Table(name = "sys_menu")
@Entity
@Data
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     *父菜单ID，一级菜单为0
     */
    @Column(name = "parentId")
    private Long parentId;

    /**
     * 父菜单名称
     */
    @Column(name = "parentName")
    private String parentName;

    /**
     * 菜单名称
     */
    @Column(name="name")
    private String name;

    /**
     * 菜单Url
     */
    @Column(name = "url")
    private String url;

    /**
     * 权限
     */
    @Column(name ="perms")
    private String perms;

    /**
     * 类型
     */
    @Column(name = "type")
    private String type;

    /**
     * 图标
     */
    @Column(name = "icon",nullable = false)
    private String icon;

    /**
     * 排序
     */
    @Column(name = "sort",nullable = false)
    private Integer sort;

    /**
     * 是否显示
     */
    @Column(name = "isShow",nullable = false)
    private String isShow;

    /**
     * 目标
     */
    @Column(name = "target")
    private String target;

    @Column(name = "remarks")
    protected String remarks;	// 备注

    @Column(name = "createBy")
    protected String createBy;	// 创建者

    @Column(name = "createDate")
    protected Date createDate;	// 创建日期

    @Column(name = "updateBy")
    protected String updateBy;	// 更新者

    @Column(name = "updateDate")
    protected Date updateDate;	// 更新日期

    @Column(name = "delFlag")
    protected String delFlag; 	// 删除标记（0：正常；1：删除；2：审核）
}
