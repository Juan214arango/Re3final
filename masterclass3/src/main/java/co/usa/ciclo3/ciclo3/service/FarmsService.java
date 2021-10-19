package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Farms;
import co.usa.ciclo3.ciclo3.repository.FarmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FarmsService {

    @Autowired
    private FarmsRepository farmsRepository;

    public List<Farms> getAll(){
        return farmsRepository.getAll();
    }

    public Optional<Farms> getFarms(int id){
        return farmsRepository.getFarms(id);
    }

    public Farms save(Farms f){
        if(f.getId()==null){
            return farmsRepository.save(f);
        }else{
            Optional<Farms> paux=farmsRepository.getFarms(f.getId());
            if(paux.isEmpty()){
                return farmsRepository.save(f);
            }else{
                return f;
            }
        }
    }

}
