package com.zgjy.erp.api;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
//
//编写spring-email.xml
//编写公共类
//在对应的StoreController 调用方法

public class MailHelper {
	private JavaMailSender sender;

	public void sendMail(String from, String to, String subject, String text) throws  javax.mail.MessagingException {
		MimeMessage mimeMessage = sender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(mimeMessage);
		helper.setFrom(from);//发件人
		helper.setTo(to);//收件人
		helper.setSubject(subject);//邮件主题
		helper.setText(text);//内容
		sender.send(mimeMessage);
	}
	public JavaMailSender getSender() {
		return sender;
	}
	public void setSender(JavaMailSender sender) {
		this.sender = sender;
	}
}
