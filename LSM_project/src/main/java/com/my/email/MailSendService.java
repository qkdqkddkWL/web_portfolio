package com.my.email;

public interface MailSendService {
	public void makeRandomNumber();
	public String joinEmail(String email);
	public void mailSend(String setFrom, String toMail, String title, String content);
}
