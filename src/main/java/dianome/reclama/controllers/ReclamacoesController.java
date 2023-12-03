package dianome.reclama.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dianome.reclama.dtos.ReclamacaoDto;
import dianome.reclama.models.ReclamacaoModel;
import dianome.reclama.repositories.ReclamacoesRepository;

import jakarta.validation.Valid;

@RestController
public class ReclamacoesController {

	@Autowired
	ReclamacoesRepository reclamacoesRepository;
		
	@GetMapping("/reclamacoes")
	public ResponseEntity<List<ReclamacaoModel>> listar(){
		List<ReclamacaoModel> reclamacaoList = reclamacoesRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(reclamacaoList);
	}
	
	@PostMapping("/reclamacoes")
	public ResponseEntity<ReclamacaoModel> salvar(@RequestBody @Valid ReclamacaoDto reclamacaoDto) {
		var reclamacaoModel = new ReclamacaoModel();
		BeanUtils.copyProperties(reclamacaoDto, reclamacaoModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(reclamacoesRepository.save(reclamacaoModel));
	}	
 
	@GetMapping("/reclamacoes/{id}")
	public ResponseEntity<Object> detalhar(@PathVariable(value="id") Integer id) {
		Optional<ReclamacaoModel> reclamacao = reclamacoesRepository.findById(id);
		if(reclamacao.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reclamação não encontrada.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(reclamacao.get());
	}
		
	@PutMapping("/reclamacoes/{id}")
	public ResponseEntity<Object> atualizarReclamacao(@PathVariable(value="id") Integer id,
												@RequestBody @Valid ReclamacaoDto reclamacaoDto) {
		Optional<ReclamacaoModel> reclamacao = reclamacoesRepository.findById(id);
		if(reclamacao.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reclamação não encontrada para edição.");
		}
		var reclamacaoModel = reclamacao.get();
		BeanUtils.copyProperties(reclamacaoDto, reclamacaoModel);
		return ResponseEntity.status(HttpStatus.OK).body(reclamacoesRepository.save(reclamacaoModel));
	}
	
	@DeleteMapping("/reclamacoes/{id}")
	public ResponseEntity<Object> deleletarReclamacao(@PathVariable(value="id") Integer id) {
		Optional<ReclamacaoModel> reclamacao = reclamacoesRepository.findById(id);
		if(reclamacao.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reclamação não encontrada para exclusão.");
		}
		reclamacoesRepository.delete(reclamacao.get());
		return ResponseEntity.status(HttpStatus.OK).body("A reclamação foi excluída.");
	}
		
		
}

