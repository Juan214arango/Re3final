package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.model.Farms;
import co.usa.ciclo3.ciclo3.repository.crud.FarmsCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FarmsRepository {

    @Autowired
    private FarmsCrudRepository farmsCrudRepository;

    public List<Farms> getAll(){
        return (List<Farms>) farmsCrudRepository.findAll();
    }
    public Optional<Farms> getFarms(int id){
        return  farmsCrudRepository.findById(id);
    }

    public Farms save(Farms f){
        return farmsCrudRepository.save(f);
    }

}
