package com.grupo4.projetofinalapi.handlers;

import com.grupo4.projetofinalapi.entities.ErroRespostaBody;
import com.grupo4.projetofinalapi.exceptions.EmailNaoEnviadoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

/** Classe para capturar exceções do tipo EmailNaoEnviadoException e fornecer tratamento customizado
 */
@ControllerAdvice
public class EmailNaoEnviadoExceptionHandler {

	/** Método para capturar exceções do tipo EmailNaoEnviadoException e fornecer tratamento customizado
	 *
	 * @param ex exceção que foi capturada pelo handler
	 * @return ResponseEntity com o detalhamento da exceção no corpo da resposta
	 */
	@ExceptionHandler(EmailNaoEnviadoException.class)
	public ResponseEntity<ErroRespostaBody> handleEnderecoInvalidoException(RuntimeException ex) {
		ErroRespostaBody erroBody = new ErroRespostaBody();
		erroBody.setStatus(HttpStatus.BAD_REQUEST.value());
		erroBody.setTitulo("Ocorreu um erro no sistema de Email");
		List<String> mensagemErros = new ArrayList<>();
		mensagemErros.add(ex.getMessage());
		erroBody.setListaErros(mensagemErros);
		
		return ResponseEntity.badRequest().body(erroBody);
	}
}
