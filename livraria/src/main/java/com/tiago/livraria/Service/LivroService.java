package com.tiago.livraria.Service;

import com.tiago.livraria.Entity.Livro;
import com.tiago.livraria.Repository.LivroRepository;
import com.tiago.livraria.Service.Exception.EntityNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    public Livro create(Livro obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Livro getId(Long id){
        Optional<Livro> obj = repository.findById(id);//Optional - trata p/ não haver id nulo
        if(obj.isEmpty()){
            throw new EntityNotFound("Livro de ID:"+id+" Não encontrado");
        }
        return obj.get();
    }

    public List<Livro> getAll(){
        return repository.findAll();
    }

    public Livro update(Livro obj){
        Optional<Livro> newObj = repository.findById(obj.getId());
        if(newObj.isEmpty()){
            throw new EntityNotFound("Livro de ID:"+obj.getId()+" Não encontrado");
        }
        updateLivro(newObj, obj);
        return repository.save(newObj.get());
    }

    private void updateLivro(Optional<Livro> newObj, Livro obj) {
        newObj.get().setNome(obj.getNome());
    }

}
