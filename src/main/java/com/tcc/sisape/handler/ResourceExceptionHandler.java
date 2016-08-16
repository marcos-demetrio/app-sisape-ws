package com.tcc.sisape.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tcc.sisape.domain.DetalhesErro;
import com.tcc.sisape.service.exceptions.CidadaoNaoEncontradoException;
import com.tcc.sisape.service.exceptions.UnidadeBasicaSaudeNaoEncontradoException;
import com.tcc.sisape.service.exceptions.UsuarioNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(UsuarioNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleUsuarioNaoEncontradoException
		(UsuarioNaoEncontradoException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("Usuário não encontrado.");
		erro.setMensagemDesenvolvedor("http://erros.sisape.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(CidadaoNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handlePacienteNaoEncontradoException
		(CidadaoNaoEncontradoException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("Paciente não encontrado.");
		erro.setMensagemDesenvolvedor("http://erros.sisape.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(UnidadeBasicaSaudeNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleUnidadeBasicaSaudeNaoEncontradoException
		(UnidadeBasicaSaudeNaoEncontradoException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("Unidade Básica de Saúde não encontrada.");
		erro.setMensagemDesenvolvedor("http://erros.sisape.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
}
