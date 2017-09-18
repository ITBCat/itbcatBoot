package cn.itbcat.boot.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 角色与部门对应关系
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017年6月21日 23:28:13
 */
@Entity
@Table(name = "sys_role_dept")
public class RoleDept implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id",unique = true,nullable = false,length = 20)
	private String id;

	/**
	 * 角色ID
	 */
	@Column(name = "role_id",length = 20)
	private String roleId;

	/**
	 * 部门ID
	 */
	@Column(name = "dept_id",length = 20)
	private String deptId;

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
	 * @param id 
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取：
	 * @return Long
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * 设置：角色ID
	 * @param roleId 角色ID
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * 获取：角色ID
	 * @return Long
	 */
	public String getRoleId() {
		return roleId;
	}
	
	/**
	 * 设置：部门ID
	 * @param deptId 部门ID
	 */
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	/**
	 * 获取：部门ID
	 * @return Long
	 */
	public String getDeptId() {
		return deptId;
	}
	
}
