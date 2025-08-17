package com.rhuan.gerenciamento_clientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rhuan.gerenciamento_clientes.facade.ClienteFacade;
import com.rhuan.gerenciamento_clientes.model.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteFacade clienteFacade;

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteFacade.listarClientes();
    }

    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Long id) {
        return clienteFacade.obterCliente(id);
    }

    @PostMapping
    public Cliente criar(@RequestBody Cliente cliente) {
        return clienteFacade.criarCliente(cliente);
    }

    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteFacade.editarCliente(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        clienteFacade.removerCliente(id);
    }
}