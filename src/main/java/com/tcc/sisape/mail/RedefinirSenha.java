package com.tcc.sisape.mail;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RedefinirSenha {

	private ApplicationContext context;

	private void enviarEmail(String aEmail, String aNovaSenha) {
		context = new ClassPathXmlApplicationContext("redefinir-senha-email-bean.xml");

		// Email: sisape.tcc@gmail.com
		// Senha: sisapeTCC

		String toAddress = aEmail;
		String fromAddress = "sisape.tcc@gmail.com";
		String subject = "Nova senha - SISAPE";
		String msgBody = "Sua nova senha no SISAPE é: " + aNovaSenha;

		Mail mensagem = (Mail) context.getBean("mailSenha");
		mensagem.sendMail(fromAddress, toAddress, subject, msgBody);
	}

	public void novaSenha(String toAddress) {
		String senha = this.gerarSenhaAleatoria();

		this.enviarEmail(toAddress, senha);
	}

	private String gerarSenhaAleatoria() {
		int qtdeMaximaCaracteres = 8;
		String[] caracteres = { "a", "1", "b", "2", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g",
				"h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B",
				"C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W",
				"X", "Y", "Z" };

		StringBuilder senha = new StringBuilder();

		for (int i = 0; i < qtdeMaximaCaracteres; i++) {
			int posicao = (int) (Math.random() * caracteres.length);

			senha.append(caracteres[posicao]);
		}

		return senha.toString();
	}
}
