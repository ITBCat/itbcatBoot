package cn.itbcat.boot.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by 860117030 on 2017/9/6.
 */
@Table(name = "sys_menu")
@Entity
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    private String id;

    /**
     *父菜单ID，一级菜单为0
     */
    @Column(name = "parentId")
    private String parentId;

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
     * 是否显示 0:显示 1：隐藏
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
