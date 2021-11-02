package co.usa.mintic.retotres.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.usa.mintic.retotres.model.audience;
import co.usa.mintic.retotres.service.audienceServicio;

@RestController
@RequestMapping("/api/Audience")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class audienceControlador {
    @Autowired
    private audienceServicio audienceServicio;
    @GetMapping("/all")
    public List<audience>getAudiences(){
        return audienceServicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<audience>getAudience(@PathVariable("id") int id){
        return audienceServicio.getAudience(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public audience save(@RequestBody audience audi){
        return audienceServicio.save(audi);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteAudience(@PathVariable("id")int id){
        return audienceServicio.deleteAudience(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public audience update(@RequestBody audience audi){
        return audienceServicio.update(audi);
    }


}
