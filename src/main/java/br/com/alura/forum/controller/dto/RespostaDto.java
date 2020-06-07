package br.com.alura.forum.controller.dto;

import java.time.LocalDateTime;

import br.com.alura.forum.model.Resposta;
import br.com.alura.forum.model.Usuario;

public class RespostaDto {
	
	private Long id;
	private String mensagem;
	private String autor;
	private LocalDateTime dataCriacao;
	
	
	/*nosso construtor usado em detalhesDoTopicoDto*/
	public RespostaDto(Resposta resposta) {
		this.id = resposta.getId();
		this.mensagem = resposta.getMensagem();
		this.autor = resposta.getAutor().getNome();
		this.dataCriacao = resposta.getDataCriacao();
	}



	public Long getId() {
		return id;
	}



	public String getMensagem() {
		return mensagem;
	}



	public String getAutor() {
		return autor;
	}



	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	
	
	
	
	

}
