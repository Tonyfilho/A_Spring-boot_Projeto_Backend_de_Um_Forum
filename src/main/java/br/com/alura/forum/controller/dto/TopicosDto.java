package br.com.alura.forum.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.forum.model.Topico;

public class TopicosDto {
	
	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime datacriacao;
	
	
	public TopicosDto(Topico topico) {
		
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.datacriacao = topico.getDataCriacao();
	}// fim do construtor
	
	
	public Long getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public LocalDateTime getDatacriacao() {
		return datacriacao;
	}


	public static List<TopicosDto> converter(List<Topico>topicos) {
		
		return topicos.stream().map(TopicosDto::new).collect(Collectors.toList());
	}
	
	
	
	
	

}// fim da class
