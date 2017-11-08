package cn.itbcat.boot.entity.admin;


import cn.itbcat.boot.entity.front.Article;
import cn.itbcat.boot.entity.front.Fans;
import cn.itbcat.boot.entity.front.Follow;
import cn.itbcat.boot.entity.socket.UserStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 系统用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:28:55
 */
@Entity
@Table(name = "sys_user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 用户ID
	 */
	@Id
	@Column(name = "user_id",unique =true,nullable = false,length = 20)
	private String userId;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 手机号
	 */
	private String mobile;

	/**
	 * 头像
	 */
	private String avatar;

	/**
	 * 状态  0：禁用   1：正常  2:未激活
	 */
	private Integer status;

	/**
	 * 是否是超级管理员
	 */
	private String isAdmin;

	/**
	 * 性别 0：男 1：女
	 */
	private String gender;

	/**
	 * 个人简介
	 */
	private String profiles;

	/**
	 * 个人网站
	 */
	private String website;

	/**
	 * 自我标签
	 */
	private String tags;

	/**
	 * 用户状态
	 */
	@Column(name = "chat_status")
	private UserStatus chatStatus;

	private Date leaveTime;
	/**
	 * 创建者ID
	 */
	private String createUserId;

	/**
	 * 创建时间
	 */
	@Column(name = "create_time")
	private Date createTime;

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

	@Column(name = "del_flag")
	private String delFlag;

	@Column(name= "token")
	private String token;
	/**
	 * 我关注的人总数
	 */
	@Transient
	private Integer followCnt;

	/**
	 * 关注人列表
	 */
	@Transient
	private List<User> follows;

	/**
	 * 粉丝总数
	 */
	@Transient
	private Integer fansCnt;

	/**
	 * 粉丝列表
	 */
	@Transient
	private List<User> fans;

	@Transient
	private Integer articleCnt;

	@Transient
	private List<Article> articles;

	public Date getLeaveTime() {
		return leaveTime;
	}

	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}

	public UserStatus getChatStatus() {
		return chatStatus;
	}

	public void setChatStatus(UserStatus userStatus) {
		this.chatStatus = userStatus;
		if(UserStatus.NotOnline.equals(userStatus)){
			this.leaveTime = new Date();
		}
	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	/**

	 * 设置：
	 * @param userId 
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 获取：
	 * @return Long
	 */
	public String getUserId() {
		return userId;
	}
	
	/**
	 * 设置：用户名
	 * @param username 用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 获取：用户名
	 * @return String
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * 设置：密码
	 * @param password 密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获取：密码
	 * @return String
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * 设置：邮箱
	 * @param email 邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 获取：邮箱
	 * @return String
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * 设置：手机号
	 * @param mobile 手机号
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 获取：手机号
	 * @return String
	 */
	public String getMobile() {
		return mobile;
	}
	
	/**
	 * 设置：状态  0：禁用   1：正常
	 * @param status 状态  0：禁用   1：正常  2:未激活
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 获取：状态  0：禁用   1：正常  2:未激活
	 * @return Integer
	 */
	public Integer getStatus() {
		return status;
	}
	
	/**
	 * 设置：创建时间
	 * @param createTime 创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取：创建时间
	 * @return Date
	 */
	public Date getCreateTime() {
		return createTime;
	}


	public String getCreateUserId(String s) {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
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

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getProfiles() {
		return profiles;
	}

	public void setProfiles(String profiles) {
		this.profiles = profiles;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Integer getFollowCnt() {
		return followCnt;
	}

	public void setFollowCnt(Integer followCnt) {
		this.followCnt = followCnt;
	}

	public List<User> getFollows() {
		return follows;
	}

	public void setFollows(List<User> follows) {
		this.follows = follows;
	}

	public Integer getFansCnt() {
		return fansCnt;
	}

	public void setFansCnt(Integer fansCnt) {
		this.fansCnt = fansCnt;
	}

	public List<User> getFans() {
		return fans;
	}

	public void setFans(List<User> fans) {
		this.fans = fans;
	}

	public Integer getArticleCnt() {
		return articleCnt;
	}

	public void setArticleCnt(Integer articleCnt) {
		this.articleCnt = articleCnt;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
}
