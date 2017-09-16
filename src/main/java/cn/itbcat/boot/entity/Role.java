package cn.itbcat.boot.entity;


import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 角色
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:27:38
 */
@Entity
@Table(name = "sys_role")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 角色ID
	 */
	@Id
	@Column(name = "role_id",unique = true,nullable = false)
	private String roleId;

	/**
	 * 角色名称
	 */
	@Column(name = "role_name")
	private String roleName;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 部门ID
	 */
	@Column(name = "dept_id")
	private String deptId;

	/**
	 * 部门名称
	 */
	@Column(name = "dept_name")
	private String deptName;

	
	/**
	 * 创建时间
	 */
	@Column(name = "create_time")
	@DateTimeFormat(pattern="yyyy-MM-ddHH")
	private Date createTime;

	@Column(name = "del_flag")
	private String delFlag;

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	/**
	 * 设置：
	 * @param roleId 
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * 获取：
	 * @return Long
	 */
	public String getRoleId() {
		return roleId;
	}
	
	/**
	 * 设置：角色名称
	 * @param roleName 角色名称
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * 获取：角色名称
	 * @return String
	 */
	public String getRoleName() {
		return roleName;
	}
	
	/**
	 * 设置：备注
	 * @param remark 备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 获取：备注
	 * @return String
	 */
	public String getRemark() {
		return remark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
