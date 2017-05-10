package test;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class SendHtmlEmail {
	public static void main(String[] args) {
		Properties props = new Properties();
		props.setProperty("mail.debug", "true");
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("host", "smtp.163.com");
		props.setProperty("mail.transport.protocol", "smtp");
		
		Session session = Session.getDefaultInstance(props);
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("dhf0710@163.com"));
			message.addRecipient(Message.RecipientType.TO,new InternetAddress("781047956@qq.com"));
			message.addRecipient(Message.RecipientType.CC,new InternetAddress("1320736870@qq.com"));
			message.setSubject("12315验证码"); 
			message.setContent("<h1 font color=red>你的验证码</h1><br/><a href='http://www.baidu.com'>测试</a>","text/html;charset=utf-8");
			
			Transport transport = session.getTransport();
			transport.connect("smtp.163.com","dhf0710@163.com", "dinghongfei710");
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (Exception e) {
			
		}
		
	}
}
