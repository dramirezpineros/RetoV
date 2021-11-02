package co.usa.mintic.retotres.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.mintic.retotres.model.Category;
import co.usa.mintic.retotres.repository.CategoryRepositorio;

@Service
public class CategoryServicio {
    @Autowired
    private CategoryRepositorio categoryRepositorio;

    public List<Category>getAll(){
        return categoryRepositorio.getAll();
    }
    

    public Optional<Category>getCategory(int id){
        return categoryRepositorio.getCategory(id);
    }
    

    public Category save(Category categoria){
        if(categoria.getId()==null){
            return categoryRepositorio.save(categoria);
        }else{
            Optional<Category> consulta= categoryRepositorio.getCategory(categoria.getId());
            if(consulta.isEmpty()){
                return categoryRepositorio.save(categoria);
            }else{
                return categoria;
            }
        }
    }

    public boolean deleteCategory(int id){
        Optional<Category> consulta=categoryRepositorio.getCategory(id);
        if(!consulta.isEmpty()){
            categoryRepositorio.delete(consulta.get());
            return true;
        }
        return false;
    }

    
    public Category update(Category catetoria){
        if(catetoria.getId()!=null){
            Optional<Category> consulta=categoryRepositorio.getCategory(catetoria.getId());
            if(!consulta.isEmpty()){
                if(catetoria.getName()!=null){
                    consulta.get().setName(catetoria.getName());
                }
            if(catetoria.getDescription()!=null){
                consulta.get().setDescription(catetoria.getDescription());
                }

            return categoryRepositorio.save(consulta.get());
            }
        }
        return catetoria;
    }
    

}
