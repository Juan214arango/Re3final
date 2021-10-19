package co.usa.ciclo3.ciclo3.web;


import co.usa.ciclo3.ciclo3.model.Farms;
import co.usa.ciclo3.ciclo3.service.FarmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Farm")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class FarmController {

    @Autowired
    private FarmsService farmService;

    @GetMapping("/all")
    public List<Farms> getFarm(){
        return farmService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Farms> getFarm(@PathVariable("id") int id){
        return farmService.getFarms(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Farms save(@RequestBody Farms f){
        return farmService.save(f);
    }

}
