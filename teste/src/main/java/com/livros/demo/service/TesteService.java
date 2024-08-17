package com.livros.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.livros.demo.repository.TesteRepository;
import com.livros.demo.entity.Teste;

@Service
public class TesteService {

    @Autowired
    private TesteRepository testeRepository;    

    // Saves a Teste object to the database
    public String save(Teste teste) {
        this.testeRepository.save(teste);
        return teste.getNome() + " salvo com sucesso";
    }

    // Deletes a Teste object from the database based on its ID
    public String delete(Long id) {
        this.testeRepository.deleteById(id);
        return "Teste deletado com sucesso!";
    }

    // Retrieves all Teste objects from the database
    public List<Teste> findAll() {
        return this.testeRepository.findAll();
    }

    // Retrieves a Teste object from the database based on its name
    public Teste findByName(String nome) {
        return this.testeRepository.findByNome(nome);
    }

    // Updates a Teste object in the database based on its ID
    public String update(Long id, Teste teste) {
        Teste testeAtual = this.testeRepository.findById(id).get();
        testeAtual.setNome(teste.getNome());
        this.testeRepository.save(testeAtual);
        return "Teste atualizado com sucesso!";
    }
}
