package com.rhuan.gerenciamento_clientes.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rhuan.gerenciamento_clientes.model.Cliente;
import com.rhuan.gerenciamento_clientes.service.ClienteService;

@Component
public class ClienteFacade {

    @Autowired
    private ClienteService service;

    public Cliente criarCliente(Cliente cliente) {
        return service.salvar(cliente);
    }

    public List<Cliente> listarClientes() {
        return service.listarTodos();
    }

    public Cliente obterCliente(Long id) {
        return service.buscarPorId(id);
    }

    public Cliente editarCliente(Long id, Cliente cliente) {
        return service.atualizar(id, cliente);
    }

    public void removerCliente(Long id) {
        service.deletar(id);
    }
}