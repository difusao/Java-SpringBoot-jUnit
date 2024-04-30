package com.difusao.service;

import static java.lang.String.format;
import static org.springframework.util.Assert.notNull;

import java.util.List;

import org.springframework.stereotype.Service;

import com.difusao.entity.Pessoa;
import com.difusao.exception.BusinessException;
import com.difusao.repository.PessoaRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PessoaService {

	private final PessoaRepository repository;

	public PessoaService(PessoaRepository repository) {
		this.repository = repository;
	}

	public List<Pessoa> buscaPessoasPorCpf(String cpf) {
		try {
			notNull(cpf, "Cpf é obrigatório!");

			return repository.findPessoa(cpf);
		} catch (final Exception e) {
			throw new BusinessException(format("Erro ao buscar pessoas por cpf = %s", cpf), e);
		}

	}

}