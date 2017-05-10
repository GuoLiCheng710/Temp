package test;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailTest {

	public static void main(String[] args) throws MessagingException {
		Properties props = new Properties();
		//开启debug调试
		props.setProperty("mail.debug", "true");
		//发送服务器需要身份验证
		props.setProperty("mail.smtp.auth", "true");
		//设置邮箱服务器主机名
		props.setProperty("host", "smtp.163.com");
		//发送邮件协议名称
		props.setProperty("mail.transport.protocol", "smtp");
		
		//设置环境信息
		Session session = Session.getInstance(props);
		
		//创建邮件对象
		Message msg = new MimeMessage(session);
		//设置发送主题
		msg.setSubject("12315验证信息");
		//设置发送内容
		msg.setText("你的验证码为2345");
		//设置发件人
		msg.setFrom(new InternetAddress("dhf0710@163.com"));
		
		
		Transport transport = session.getTransport();
		//连接服务器
		transport.connect("smtp.163.com","dhf0710@163.com", "dinghongfei710");
		//发送邮件
		transport.sendMessage(msg, new Address[]{new InternetAddress("781047956@qq.com"),
								   				 new InternetAddress("dhf0710@126.com")});
		//关闭连接
		transport.close();

	}

}
