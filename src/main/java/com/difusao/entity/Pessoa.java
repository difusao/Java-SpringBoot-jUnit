package com.difusao.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

	private String nome;
	private String cpf;
	private String profissao;
	private Integer idade;
	private String cidade;
	private String rua;
	private Integer numero;

	public Pessoa(String nome, String cpf) {
	}
}