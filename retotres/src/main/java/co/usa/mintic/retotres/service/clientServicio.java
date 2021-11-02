package co.usa.mintic.retotres.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.mintic.retotres.model.client;
import co.usa.mintic.retotres.repository.clientRepositorio;

@Service
public class clientServicio {

    @Autowired
    private clientRepositorio clientRepositorio;

    public List<client> getAll(){
        return clientRepositorio.getAll();
    }

    public Optional<client>getCliente(int id){
        return clientRepositorio.getClient(id);
    }

    
    
    public client save(client clt){
        if(clt.getIdClient()==null){
            return clientRepositorio.save(clt);
        }else{
            Optional<client> consulta=clientRepositorio.getClient(clt.getIdClient());
            if(consulta.isEmpty()){
                return clientRepositorio.save(clt);
            }else{
                return clt;
            }
        }
    }

    public boolean deleteClient(int id){
        Optional<client> consulta=clientRepositorio.getClient(id);
        if(!consulta.isEmpty()){
            clientRepositorio.delete(consulta.get());
            return true;
        }
        return false;
    }

    public client update(client cliente){
        if(cliente.getIdClient()!=null){
            Optional<client> consulta=clientRepositorio.getClient(cliente.getIdClient());
            if(!consulta.isEmpty()){
                if(cliente.getName()!=null){
                    consulta.get().setName(cliente.getName());
                }
            if(cliente.getEmail()!=null){
                consulta.get().setEmail(cliente.getEmail());
                }
            if(cliente.getPassword ()!=null){
                consulta.get().setPassword(cliente.getPassword());
                }
            if(cliente.getAge()!=null){
                consulta.get().setAge(cliente.getAge());
            }

            return clientRepositorio.save(consulta.get());
            }
        }
        return cliente;
    }

 




    
}
