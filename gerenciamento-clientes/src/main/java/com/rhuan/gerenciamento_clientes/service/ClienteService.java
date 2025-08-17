package com.rhuan.gerenciamento_clientes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rhuan.gerenciamento_clientes.model.Cliente;
import com.rhuan.gerenciamento_clientes.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public Cliente salvar(Cliente cliente) {
        return repository.save(cliente);
    }

    public List<Cliente> listarTodos() {
        return repository.findAll();
    }

    public Cliente buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public Cliente atualizar(Long id, Cliente atualizarCliente) {
        Cliente clienteExistente = buscarPorId(id);
        clienteExistente.setNome(atualizarCliente.getNome());
        clienteExistente.setEmail(atualizarCliente.getEmail());
        clienteExistente.setTelefone(atualizarCliente.getTelefone());
        return repository.save(atualizarCliente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}