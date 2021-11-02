package co.usa.mintic.retotres.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.mintic.retotres.model.ReservationRating;
import co.usa.mintic.retotres.repository.ReservationRatingRepositorio;

@Service
public class ReservationRatingServicio {
    @Autowired
    private ReservationRatingRepositorio reservationRatingRepositorio;

    public List<ReservationRating> getAll(){
        return reservationRatingRepositorio.getAll();
    }

    public Optional<ReservationRating> getCalificacionReserva(int id){
        return reservationRatingRepositorio.getCalificacionReserva(id);
    }
    
    
    public ReservationRating save(ReservationRating calificacionReserva){
        if(calificacionReserva.getId()==null){
            return reservationRatingRepositorio.save(calificacionReserva);
        }else{
            Optional<ReservationRating> consulta=reservationRatingRepositorio.getCalificacionReserva(calificacionReserva.getId());
            if(consulta.isEmpty()){
                return reservationRatingRepositorio.save(calificacionReserva);
            }else{
                return calificacionReserva;
            }
        }
    }

    public boolean deleteCalificacionReserva(int id){
        Optional<ReservationRating> consulta=reservationRatingRepositorio.getCalificacionReserva(id);
        if(!consulta.isEmpty()){
            reservationRatingRepositorio.delete(consulta.get());
            return true;
        }
        return false;
    }

    public ReservationRating update(ReservationRating calificacionReserva){
        if(calificacionReserva.getId()!=null){
            Optional<ReservationRating> consulta=reservationRatingRepositorio.getCalificacionReserva(calificacionReserva.getId());
            if(!consulta.isEmpty()){
                if(calificacionReserva.getRating()!=null){
                    consulta.get().setRating(calificacionReserva.getRating());
                }
            if(calificacionReserva.getMessage()!=null){
                consulta.get().setMessage(calificacionReserva.getMessage());
                }

            return reservationRatingRepositorio.save(consulta.get());
            }
        }
        return calificacionReserva;
    }
}
