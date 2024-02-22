package br.com.projeto.backend.cadastrocliente.controller;

import br.com.projeto.backend.cadastrocliente.model.Cliente;

public class ClienteController {

    public void usaCliente(){
        Cliente cliente = new Cliente();
        cliente.setNome("Mateus Padilha");

        String nome = cliente.getNome();

    }
}
