package cn.itbcat.boot.repository;


import cn.itbcat.boot.entity.Email;
import cn.itbcat.boot.service.IMailService;
import cn.itbcat.boot.utils.Constants;
import cn.itbcat.boot.utils.MailUtil;
import cn.itbcat.boot.utils.queue.MailQueue;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.ResourceUtils;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Service
public class MailRepository implements IMailService {
	private static final Logger logger = LoggerFactory.getLogger(MailRepository.class);
	
	@Autowired
	private JavaMailSender mailSender;//执行者
	@Autowired
	public Configuration configuration;//freemarker
	@Value("${spring.mail.username}")
	public String USER_NAME;//发送者

	
	static {
		 System.setProperty("mail.mime.splitlongparameters","false");
	}

	@Override
	public void send(Email mail) throws Exception {
		logger.info("发送邮件：{}",mail.getContent());
		MailUtil mailUtil = new MailUtil();
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(USER_NAME);
		message.setTo(mail.getEmail());
		message.setSubject(mail.getSubject());
		message.setText(mail.getContent());
		mailUtil.start(mailSender, message);
	}

	@Override
	public void sendHtml(Email mail) throws Exception {
		MailUtil mailUtil = new MailUtil();
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom(USER_NAME);
		helper.setTo(mail.getEmail());
		helper.setSubject(mail.getSubject());
		helper.setText(
				"<html><body><img src=\"cid:springcloud\" ></body></html>",
				true);
		// 发送图片
		File file = ResourceUtils.getFile("classpath:static"
				+ Constants.SF_FILE_SEPARATOR + "image"
				+ Constants.SF_FILE_SEPARATOR + "springcloud.png");
		helper.addInline("springcloud", file);
		// 发送附件
		file = ResourceUtils.getFile("classpath:static"
				+ Constants.SF_FILE_SEPARATOR + "file"
				+ Constants.SF_FILE_SEPARATOR + "关注科帮网获取更多源码.zip");
		helper.addAttachment("科帮网", file);
		mailUtil.startHtml(mailSender, message);
	}

	@Override
	public void sendFreemarker(Email mail) throws Exception {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom(USER_NAME);
		helper.setTo(mail.getEmail());
		helper.setSubject(mail.getSubject());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("content", mail.getContent());
		Template template = configuration.getTemplate(mail.getTemplate()+".flt");
		String text = FreeMarkerTemplateUtils.processTemplateIntoString(
				template, model);
		helper.setText(text, true);
		mailSender.send(message);
	}

	@Override
	public void sendQueue(Email mail) throws Exception {
		MailQueue.getMailQueue().produce(mail);
	}
}
