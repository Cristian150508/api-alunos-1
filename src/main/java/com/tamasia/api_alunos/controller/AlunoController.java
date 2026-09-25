package com.tamasia.api_alunos.controller;

import java.util.List;
import com.tamasia.api_alunos.DTO.AlunoRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tamasia.api_alunos.DTO.AlunoResponse;
import com.tamasia.api_alunos.service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	 
	private final AlunoService service;

	public AlunoController(AlunoService service) {
		super();
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<AlunoResponse>> listarAlunos () {
		return ResponseEntity.status(HttpStatus.OK).body(service.listarAlunos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<AlunoResponse> obterAlunoPorId(@PathVariable int id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.obterAlunoPorId(id));
	}
	
	@PostMapping
	public ResponseEntity<AlunoResponse> cadastrarAluno(@Valid @RequestBody AlunoRequest request){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrarAluno(request));
	}

	@PutMapping("/{id}")
	public ResponseEntity<AlunoResponse> atualizarAluno(@Valid @RequestBody AlunoRequest request, @PathVariable int id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.atualizarAluno(request, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirAluno(@PathVariable int id) {
		service.excluirAluno(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
