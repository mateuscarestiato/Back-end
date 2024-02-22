package br.com.projeto.backend.cadastrocliente.model;

import lombok.Data;

@Data
public class Cliente {
    private String nome;
    private String email;
    private String cpf;
    private String dataNascimento;
}