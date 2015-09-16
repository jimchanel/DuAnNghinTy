package com.huynvb.pr0ject.common;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailManager {

	private String proxyHost;
	private String proxyPort;
	
	private String smtp_host;
	private Integer smtp_port;
	private String smtp_user;
	private String smtp_pass;
	private String from;
	
	public EmailManager() {
		// TODO Auto-generated constructor stub
	}
	
	public void setProxy(String proxyHost, String proxyPort){
		this.proxyHost = proxyHost;
		this.proxyPort = proxyPort;
	}
	
	public void setMailInfo(String smtp_host, Integer smtp_port, String smtp_user, String smtp_pass, String from){
		this.smtp_host = smtp_host;
		this.smtp_port = smtp_port;
		this.smtp_user = smtp_user;
		this.smtp_pass = smtp_pass;
		this.from = from;
	}
	
	public boolean sendEmail(String toAddress, String subject, String content) throws Exception {
		boolean result = false;
		Properties props = System.getProperties();

		if (proxyHost != null && proxyPort != null) {

			props.setProperty("proxySet", "true");
			props.setProperty("socksProxyHost", proxyHost);
			props.setProperty("socksProxyPort", proxyPort);
		}

		props.put("mail.smtp.host", smtp_host);

		if (smtp_port != null) {
			props.put("mail.smtp.port", smtp_port);
		}

		props.put("mail.smtp.EnableSSL.enable","true");
		props.put("mail.smtp.starttls.enable", "true");

		Authenticator pa = null;

		if (smtp_user != null & smtp_pass != null) {
			props.put("mail.smtp.auth", "true");
			pa = new Authenticator() {
				@Override
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(smtp_user, smtp_pass);
				}
			};
		}

		Session session = Session.getInstance(props,pa);

		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(from));

		String[] recipientList = toAddress.split(",");
		InternetAddress[] recipientAddress = new InternetAddress[recipientList.length];
		int counter = 0;
		for (String recipient : recipientList) {
			recipientAddress[counter] = new InternetAddress(recipient.trim());
			counter++;
		}

		msg.setRecipients(Message.RecipientType.TO, recipientAddress);

		msg.setSubject(subject, "UTF-8");

		msg.setContent(content, "text/html;charset=UTF-8");

		msg.setHeader("X-Mailer", "LOTONtechEmail");
		msg.setSentDate(new Date());
		msg.saveChanges();

		Transport.send(msg);

		result = true;
		return result;
	}

}
