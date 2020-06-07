package br.com.alura.forum.controller;


import java.net.URI;
import java.util.List;

import javax.persistence.Transient;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.forum.controller.dto.DetalheDoTopicosDto;
import br.com.alura.forum.controller.dto.TopicosDto;
import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.controller.form.TopicoUpdateForm;
import br.com.alura.forum.model.Topico;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.repository.TopicoRepository;

@RestController
@RequestMapping("/topicos")
//@RestController("/topicos")
public class TopicosController {
	
	@Autowired
	private TopicoRepository topicoRepository;
	@Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping()
	public List<TopicosDto> listaAll(String nomeCurso){ 
		if(nomeCurso == null) {
		List<Topico> topico = topicoRepository.findAll();		
		return TopicosDto.converter(topico);
		}else {
			List<Topico> topico = topicoRepository.findByCurso_Nome(nomeCurso);		
			return TopicosDto.converter(topico);
		}
	}
	
	@PostMapping()
	public ResponseEntity<TopicosDto> cadastrar(@RequestBody TopicoForm form, UriComponentsBuilder uribuild) {
	Topico topico =	form.converter(cursoRepository);
		topicoRepository.save(topico);	
		URI uri = uribuild.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new TopicosDto(topico));
	}
	
	
	@GetMapping("/{id}")
	public DetalheDoTopicosDto listar(@PathVariable Long id) {
		Topico topico = topicoRepository.getOne(id);
		
		return new DetalheDoTopicosDto(topico);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody TopicoUpdateForm form){
		Topico topico = form.atualizar(id, topicoRepository);
		
		return ResponseEntity.ok(new TopicosDto(topico));
	}
	
	@Transactional
	@DeleteMapping("/{id}")
	public ResponseEntity<?> apagar(@PathVariable Long id){
		 topicoRepository.deleteById(id);
		return ResponseEntity.ok().build();
		
	}

}// fim da class
