package cn.itbcat.boot.service.admin;


import cn.itbcat.boot.entity.admin.Email;

public interface IMailService {
	 /**
	  * 纯文本
	  * @Author  ITBC
	  * @param mail
	  * @throws Exception  void
	  * @Date	2017年7月20日
	  * 更新日志
	  * 2017年7月20日  ITBC 首次创建
	  */
	 public void send(Email mail) throws Exception;
	 /**
	  * 富文本
	  * @Author  ITBC
	  * @param mail
	  * @throws Exception  void
	  * @Date	2017年7月20日
	  * 更新日志
	  * 2017年7月20日  ITBC 首次创建
	  *
	  */
	 public void sendHtml(Email mail) throws Exception;
	 /**
	  * 模版发送 freemarker
	  * @Author  ITBC
	  * @param mail
	  * @throws Exception  void
	  * @Date	2017年7月20日
	  * 更新日志
	  * 2017年7月20日  ITBC 首次创建
	  *
	  */
	 public void sendFreemarker(Email mail) throws Exception;

	 /**
	  * 队列
	  * @Author  ITBC
	  * @param mail
	  * @throws Exception  void
	  * @Date	2017年8月4日
	  * 更新日志
	  * 2017年8月4日  ITBC 首次创建
	  *
	  */
	 public void sendQueue(Email mail) throws Exception;
}
