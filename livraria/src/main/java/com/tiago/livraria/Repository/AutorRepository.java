package com.tiago.livraria.Repository;

import com.tiago.livraria.Entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
