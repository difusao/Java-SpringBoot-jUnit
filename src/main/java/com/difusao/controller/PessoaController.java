package com.difusao.controller;

import static java.lang.String.format;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.difusao.entity.Pessoa;
import com.difusao.service.PessoaService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/testes-junit5", produces = { "application/json" })
@Slf4j
public class PessoaController {

	private final PessoaService service;

	public PessoaController(PessoaService service) {
		this.service = service;
	}

	@Operation(summary = "Busca pessoa por cpf", method = "GET")

	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
			@ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
			@ApiResponse(responseCode = "400", description = "Parametros inválidos"),
			@ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"), })
	@GetMapping("/cpf")
	@CrossOrigin(allowedHeaders = "*")
	public ResponseEntity<List<Pessoa>> buscaDadosProfissionais(@RequestParam("cpf") String cpf) {
		log.info(format("Buscando dados de pessoa por cpf = %s!", cpf));
		return ResponseEntity.ok(service.buscaPessoasPorCpf(cpf));
	}
}