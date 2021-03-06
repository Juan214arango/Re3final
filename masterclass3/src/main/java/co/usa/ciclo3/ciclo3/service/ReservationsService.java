package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Reservations;
import co.usa.ciclo3.ciclo3.repository.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationsService {

    @Autowired
    private ReservationsRepository reservationsRepository;

    public List<Reservations> getAll(){
        return reservationsRepository.getAll();
    }

    public Optional<Reservations> getReservations(int idReservations){
        return reservationsRepository.getReservations(idReservations);
    }

    public Reservations save(Reservations r){
        if(r.getIdReservation()==null){
            return reservationsRepository.save(r);
        }else{
            Optional<Reservations> paux=reservationsRepository.getReservations(r.getIdReservation());
            if(paux.isEmpty()){
                return reservationsRepository.save(r);
            }else{
                return r;
            }
        }
    }

}