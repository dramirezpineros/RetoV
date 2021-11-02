package co.usa.mintic.retotres.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.mintic.retotres.model.audience;
import co.usa.mintic.retotres.repository.audienceRepositorio;


@Service
public class audienceServicio {

    @Autowired
    private audienceRepositorio audienceRepositorio;
    public List<audience>getAll(){
        return audienceRepositorio.getAll();
    }

    public Optional<audience>getAudience(int id){
        return audienceRepositorio.getAudience(id);
    }

    public audience save(audience audi){
        if(audi.getId()==null){
            return audienceRepositorio.save(audi);
        }else{Optional<audience> consulta=audienceRepositorio.getAudience(audi.getId());
            if(consulta.isEmpty()){
                return audienceRepositorio.save(audi);
            }else{
                return audi;
            }
        
        }
    }
    
    public boolean deleteAudience(int id){
        Optional<audience> consulta=audienceRepositorio.getAudience(id);
        if(!consulta.isEmpty()){
            audienceRepositorio.delete(consulta.get());
            return true;
        }
        return false;
    }

    public audience update(audience audi){
        if(audi.getId()!=null){
            Optional<audience> consulta=audienceRepositorio.getAudience(audi.getId());
            if(!consulta.isEmpty()){
                if(audi.getName()!=null){
                    consulta.get().setName(audi.getName());
                }
            if(audi.getCapacity()!=null){
                consulta.get().setCapacity(audi.getCapacity());
                }
            if(audi.getOwner ()!=null){
                consulta.get().setOwner(audi.getOwner());
                }
            if(audi.getDescription()!=null){
                consulta.get().setDescription(audi.getDescription());
            }

            return audienceRepositorio.save(consulta.get());
            }
        }
        return audi;
    }




    
}
