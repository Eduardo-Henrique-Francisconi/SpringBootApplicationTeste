package com.livros.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import com.livros.demo.entity.Teste;
import com.livros.demo.service.TesteService;

import com.livros.demo.entity.Teste;
import com.livros.demo.service.TesteService;

@RestController
@RequestMapping("/api/livros")
@CrossOrigin("*")
public class TesteController {

    @Autowired
    private TesteService testeService;

    // Função para salvar um objeto Teste
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Teste teste) {

        try {
            // Chama o serviço para salvar o objeto Teste
            String mensagem = this.testeService.save(teste);
            return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);

        } catch (Exception e) {
            // Retorna uma resposta de erro caso ocorra uma exceção
            return new ResponseEntity<String>("Deu esse erro aqui: " + e.getMessage(), HttpStatus.BAD_REQUEST);

        }

    }

    // Função para deletar um objeto Teste pelo ID
    @DeleteMapping("Delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        try {
            // Chama o serviço para deletar o objeto Teste pelo ID
            this.testeService.delete(id);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            // Retorna uma resposta de erro caso ocorra uma exceção
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);

        }

    }

    // Função para buscar todos os objetos Teste
    @GetMapping("/findAll")
    public ResponseEntity<Iterable<Teste>> findAll() {

        try {
            // Chama o serviço para buscar todos os objetos Teste
            Iterable<Teste> testes = this.testeService.findAll();
            return new ResponseEntity<Iterable<Teste>>(testes, HttpStatus.OK);

        } catch (Exception e) {
            // Retorna uma resposta de erro caso ocorra uma exceção
            return new ResponseEntity<Iterable<Teste>>(HttpStatus.BAD_REQUEST);

        }

    }

    // Função para buscar um objeto Teste pelo nome
    @GetMapping("/findByName/{nome}")
    public ResponseEntity<Teste> findByName(@PathVariable String nome) {

        try {
            // Chama o serviço para buscar um objeto Teste pelo nome
            Teste teste = this.testeService.findByName(nome);
            return new ResponseEntity<Teste>(teste, HttpStatus.OK);

        } catch (Exception e) {
            // Retorna uma resposta de erro caso ocorra uma exceção
            return new ResponseEntity<Teste>(HttpStatus.BAD_REQUEST);

        }

    }

    // Função para atualizar um objeto Teste pelo ID
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Teste teste) {

        try {
            // Chama o serviço para atualizar o objeto Teste pelo ID
            String mensagem = this.testeService.update(id, teste);
            return new ResponseEntity<String>(mensagem, HttpStatus.OK);

        } catch (Exception e) {
            // Retorna uma resposta de erro caso ocorra uma exceção
            return new ResponseEntity<String>("Deu esse erro aqui: " + e.getMessage(), HttpStatus.BAD_REQUEST);

        }

    }

}
