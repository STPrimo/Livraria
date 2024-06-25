package com.tiago.livraria.Config;

import com.tiago.livraria.Entity.Autor;
import com.tiago.livraria.Entity.Livro;
import com.tiago.livraria.Repository.AutorRepository;
import com.tiago.livraria.Repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class TestConfig implements CommandLineRunner {
    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public void run(String... args) throws Exception{
        Autor a1 = new Autor(null,"Shaolin");
        Autor a2 = new Autor(null,"JamalBlack");

        autorRepository.saveAll(Arrays.asList(a1,a2));

        Livro l1 = new Livro(null,"Matando Porcos",a1);
        Livro l2 = new Livro(null,"Do Pneu",a1);
        Livro l3 = new Livro(null,"Traficos",a2);

        livroRepository.saveAll(Arrays.asList(l1,l2,l3));

    }
}
