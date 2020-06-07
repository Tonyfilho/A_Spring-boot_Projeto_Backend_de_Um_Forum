package br.com.alura.forum.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.forum.model.StatusTopico;
import br.com.alura.forum.model.Topico;


public class DetalheDoTopicosDto {
	
	private Long id;
	private String titulo;
	private String mensagem;
	private String autorDTO;
	private String cursoDTO;
	private LocalDateTime dataCriacao;
	private StatusTopico status;
	private List<RespostaDto>respostasDto;
	
	
	

	public DetalheDoTopicosDto(Topico topico) {
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.autorDTO = topico.getAutor().getNome();
		this.cursoDTO = topico.getCurso().getNome();
		this.dataCriacao = topico.getDataCriacao();
		this.status = topico.getStatus();
		this.respostasDto = new ArrayList<>();
		this.respostasDto.addAll(topico.getRespostas().stream()
				.map(RespostaDto::new).collect(Collectors.toList()));
		
		
	}




	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public String getAutorDTO() {
		return autorDTO;
	}

	public String getCursoDTO() {
		return cursoDTO;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public StatusTopico getStatus() {
		return status;
	}

	public List<RespostaDto> getRespostasDto() {
		return respostasDto;
	}
	
	

}
