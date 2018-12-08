package org.share.topic.impl.domain;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.mail.internet.MimeMessage;
import org.share.topic.api.domain.IMailService;
import org.share.topic.api.model.Email;
import org.share.topic.impl.util.Constants;
import org.share.topic.impl.util.MailUtil;
import org.share.topic.impl.util.VelocityEngineBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.util.ResourceUtils;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;
import freemarker.template.Configuration;
import freemarker.template.Template;

@Service
public class MailService implements IMailService {
	@Autowired
    private JavaMailSender mailSender;//执行者
	
    @Autowired
    public Configuration configuration;//freemarker
    
    @Autowired
    public VelocityEngineBean velocityEngineBean;
    
    @Autowired
    private SpringTemplateEngine  templateEngine;//thymeleaf
    
    @Value("${spring.mail.username}")
    public String USER_NAME;//发送者
    
    static {
		 System.setProperty("mail.mime.splitlongparameters","false");
	}

	@Override
	public void send(Email mail) throws Exception {
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
	public void sendVelocity(Email mail) throws Exception {
		MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(USER_NAME);
        helper.setTo(mail.getEmail());
        helper.setSubject(mail.getSubject());
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("content", mail.getContent());
        String text = this.getContent(model);
        helper.setText(text, true);
        mailSender.send(message);
	}
	
	@SuppressWarnings("deprecation")
	private String getContent(Map<String, Object> model) { 
		return VelocityEngineUtils.mergeTemplateIntoString(velocityEngineBean, "/template/welcome.vm", "UTF-8", model);
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
	public void sendThymeleaf(Email mail) throws Exception {
		MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(USER_NAME);
        helper.setTo(mail.getEmail());
        helper.setSubject(mail.getSubject());
        Context context = new Context();
        context.setVariable("email", mail);
        String text = templateEngine.process(mail.getTemplate(), context);
        helper.setText(text, true);
        mailSender.send(message);
	}

}
