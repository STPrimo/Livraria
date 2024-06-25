package com.tiago.livraria.Service;

import com.tiago.livraria.Entity.Autor;
import com.tiago.livraria.Repository.AutorRepository;
import com.tiago.livraria.Service.Exception.EntityNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository repository;

    public Autor create(Autor obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Autor getId(Long id){
        Optional<Autor> obj = repository.findById(id);//Customize Toolbar...
        if(obj.isEmpty()){
            throw new EntityNotFound("Autor de ID:"+id+" Não encontrado");
        }
        return obj.get();
    }

    public List<Autor> getAll(){
        return repository.findAll();
    }

    public Autor update(Autor obj){
        Optional<Autor> newObj = repository.findById(obj.getId());
        if(newObj.isEmpty()){
            throw new EntityNotFound("Autor de ID:"+obj.getId()+" Não encontrado");
        }
        updateAutor(newObj, obj);
        return repository.save(newObj.get());
    }

    private void updateAutor(Optional<Autor> newObj, Autor obj) {
        newObj.get().setNome(obj.getNome());
    }

}
