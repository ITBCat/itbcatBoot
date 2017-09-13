package cn.itbcat.boot.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 角色与菜单对应关系
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:28:13
 */
@Entity
@Table(name = "sys_role_menu")
public class RoleMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id",unique = true,nullable = false)
	private String id;

	/**
	 * 角色ID
	 */
	@Column(name = "role_id")
	private String roleId;

	/**
	 * 菜单ID
	 */
	@Column(name = "menu_id")
	private String menuId;

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
	 * 设置：菜单ID
	 * @param menuId 菜单ID
	 */
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	/**
	 * 获取：菜单ID
	 * @return Long
	 */
	public String getMenuId() {
		return menuId;
	}
	
}
