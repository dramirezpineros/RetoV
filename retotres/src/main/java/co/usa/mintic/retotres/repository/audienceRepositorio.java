package co.usa.mintic.retotres.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.mintic.retotres.model.audience;
import co.usa.mintic.retotres.repository.crud.audienceCrudRepositorio;

@Repository
public class audienceRepositorio {
    @Autowired
    private audienceCrudRepositorio audienceCrudRepositorio;

    public List<audience>getAll(){
        return (List<audience>)audienceCrudRepositorio.findAll();
    }

    public Optional<audience>getAudience(int id){
        return audienceCrudRepositorio.findById(id);
    }

    public audience save(audience audi){
        return audienceCrudRepositorio.save(audi);
    }

    public void delete(audience audi){
        audienceCrudRepositorio.delete(audi);
    }

}
