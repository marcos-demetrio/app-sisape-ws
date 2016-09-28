package com.tcc.sisape.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tcc.sisape.domain.DetalhesErro;
import com.tcc.sisape.service.exceptions.CidadaoNaoEncontradoException;
import com.tcc.sisape.service.exceptions.ClassificacaoBrasileiraOcupacaoNaoEncontradoException;
import com.tcc.sisape.service.exceptions.ClassificacaoInternacionalDoencaNaoEncontradoException;
import com.tcc.sisape.service.exceptions.EstadoNaoEncontradoException;
import com.tcc.sisape.service.exceptions.MunicipioNaoEncontradoException;
import com.tcc.sisape.service.exceptions.PaisNaoEncontradoException;
import com.tcc.sisape.service.exceptions.ProfissionalAgendaNaoEncontradoException;
import com.tcc.sisape.service.exceptions.ProfissionalLotacaoNaoEncontradoException;
import com.tcc.sisape.service.exceptions.ProfissionalNaoEncontradoException;
import com.tcc.sisape.service.exceptions.TipoLogradouroNaoEncontradoException;
import com.tcc.sisape.service.exceptions.UnidadeBasicaSaudeNaoEncontradoException;
import com.tcc.sisape.service.exceptions.UnidadeBasicaSaudeTipoEstabelecimentoNaoEncontradoException;
import com.tcc.sisape.service.exceptions.UsuarioNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ProfissionalAgendaNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleProfissionalAgendaNaoEncontradoException(ProfissionalAgendaNaoEncontradoException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo(e.getMessage());
		erro.setMensagemDesenvolvedor("http://erros.sisape.com/404");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(ProfissionalLotacaoNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleProfissionalLotacaoNaoEncontradoException(ProfissionalLotacaoNaoEncontradoException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo(e.getMessage());
		erro.setMensagemDesenvolvedor("http://erros.sisape.com/404");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(ProfissionalNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleProfissionalNaoEncontradoException(ProfissionalNaoEncontradoException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo(e.getMessage());
		erro.setMensagemDesenvolvedor("http://erros.sisape.com/404");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(UsuarioNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleUsuarioNaoEncontradoException(UsuarioNaoEncontradoException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo(e.getMessage());
		erro.setMensagemDesenvolvedor("http://erros.sisape.com/404");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(PaisNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handlePaisNaoEncontradoException(PaisNaoEncontradoException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo(e.getMessage());
		erro.setMensagemDesenvolvedor("http://erros.sisape.com/404");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(EstadoNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleEstadoNaoEncontradoException(EstadoNaoEncontradoException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo(e.getMessage());
		erro.setMensagemDesenvolvedor("http://erros.sisape.com/404");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(MunicipioNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleMunicipioNaoEncontradoException(MunicipioNaoEncontradoException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo(e.getMessage());
		erro.setMensagemDesenvolvedor("http://erros.sisape.com/404");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(CidadaoNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handlePacienteNaoEncontradoException(CidadaoNaoEncontradoException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo(e.getMessage());
		erro.setMensagemDesenvolvedor("http://erros.sisape.com/404");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(UnidadeBasicaSaudeNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleUnidadeBasicaSaudeNaoEncontradoException(
			UnidadeBasicaSaudeNaoEncontradoException e, HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo(e.getMessage());
		erro.setMensagemDesenvolvedor("http://erros.sisape.com/404");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(TipoLogradouroNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleTipoLogradouroNaoEncontradoException(
			TipoLogradouroNaoEncontradoException e, HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo(e.getMessage());
		erro.setMensagemDesenvolvedor("http://erros.sisape.com/404");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(ClassificacaoBrasileiraOcupacaoNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleClassificacaoBrasileiraOcupacaoNaoEncontradoException(
			ClassificacaoBrasileiraOcupacaoNaoEncontradoException e, HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo(e.getMessage());
		erro.setMensagemDesenvolvedor("http://erros.sisape.com/404");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(ClassificacaoInternacionalDoencaNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleClassificacaoInternacionalDoencaNaoEncontradoException(
			ClassificacaoInternacionalDoencaNaoEncontradoException e, HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo(e.getMessage());
		erro.setMensagemDesenvolvedor("http://erros.sisape.com/404");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(UnidadeBasicaSaudeTipoEstabelecimentoNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleUnidadeBasicaSaudeTipoEstabelecimentoNaoEncontradoException(
			UnidadeBasicaSaudeTipoEstabelecimentoNaoEncontradoException e, HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo(e.getMessage());
		erro.setMensagemDesenvolvedor("http://erros.sisape.com/404");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
}