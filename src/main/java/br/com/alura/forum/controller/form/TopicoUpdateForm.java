package br.com.alura.forum.controller.form;

import br.com.alura.forum.model.Topico;
import br.com.alura.forum.repository.TopicoRepository;

public class TopicoUpdateForm {
	
	private String titulo;
	
	private String mensagem;
	
	
	
	/***********NOSSOS SETS e GETS************/

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	/*****Metodos**********************/

	public Topico atualizar(Long id, TopicoRepository topicoRepository) {
		Topico topico = topicoRepository.getOne(id);
		topico.setTitulo(titulo);
		topico.setMensagem(mensagem);
		
		return topico;
		
	}
	
	
	
	

}
