package com.tcc.sisape.mail;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RedefinirSenha {

	private ApplicationContext context;

	private void enviarEmail() {
		context = new ClassPathXmlApplicationContext("redefinir-senha-email-bean.xml");

		String toAddress = "demetrius.marcos@gmail.com";
		String fromAddress = "demetrius.marcos@gmail.com";
		String subject = "Nova senha - SISAPE";
		String msgBody = "Sua nova senha no SISPE é: XYZ";

		Mail mensagem = (Mail) context.getBean("mailSenha");
		mensagem.sendMail(fromAddress, toAddress, subject, msgBody);
	}

	public void novaSenha(String toAddress) {
		enviarEmail();
	}
}
