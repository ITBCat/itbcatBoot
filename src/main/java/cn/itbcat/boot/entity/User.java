package cn.itbcat.boot.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 860117030 on 2017/9/11.
 */
@Entity
@Table(name = "sys_user")

public class User implements Serializable {

    @Id
    @Column(name = "id", unique = true, nullable = false,length = 20)
    private String id;

    @Column(name = "username",nullable = false,length = 255)
    private String username;

    @Column(name = "password",nullable = false,length = 255)
    private String password;

    @Column(name = "email",nullable = false,length = 50)
    private String email;

    @Column(name = "type",nullable = false,length = 1)
    private String type;

    @Column(name = "deptname",nullable = false,length = 255)
    private String deptName;

    @Column(name = "deptid",nullable = false,length = 20)
    private String deptId;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
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
