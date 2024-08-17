package com.livros.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livros.demo.entity.Teste;

public interface TesteRepository extends JpaRepository<Teste, Long>  {

    Teste findByNome(String nome);

}
