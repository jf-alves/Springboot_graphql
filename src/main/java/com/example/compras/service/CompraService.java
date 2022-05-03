package com.example.compras.service;

import com.example.compras.domain.Cliente;
import com.example.compras.domain.Compra;
import com.example.compras.domain.dto.CompraResumo;
import com.example.compras.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CompraService {

    @Autowired
    private CompraRepository repository;

    public Compra findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<Compra> findAll(Pageable pageable){
        return repository.findAll(pageable).getContent();
    }

    @Transactional
    public Compra save(Compra compra){
        return repository.save(compra);
    }

    @Transactional
    public Boolean deleteById(Long id){
        if (repository.findById(id).isPresent()){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Compra> findAllByCliente(Cliente cliente) {
        return repository.findAllByCliente(cliente);
    }

    public List<Compra> findAllByClienteAndQuantidade(Cliente cliente, int quantidade){
        return repository.findAllByClienteAndQuantidade(cliente, quantidade);
    }

    public List<CompraResumo> findAllComprasRelatorio() {
        return repository.findAllCompraRelatorio();
    }
}
