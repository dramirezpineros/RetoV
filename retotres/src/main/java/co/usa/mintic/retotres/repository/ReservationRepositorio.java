package co.usa.mintic.retotres.repository;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.mintic.retotres.model.Reservation;
import co.usa.mintic.retotres.model.client;
import co.usa.mintic.retotres.model.reportes.ContadorClientes;
import co.usa.mintic.retotres.repository.crud.ReservationCrudRepositorio;

@Repository
public class ReservationRepositorio {
    @Autowired
    private ReservationCrudRepositorio reservationCrudRepositorio;

    public List<Reservation>getAll(){
        return (List<Reservation>)reservationCrudRepositorio.findAll();
    }

    public Optional<Reservation>getReserva(int id){
        return reservationCrudRepositorio.findById(id);
    }

    public Reservation save(Reservation reserva){
        return reservationCrudRepositorio.save(reserva);
    }

    public void delete(Reservation reserva){
        reservationCrudRepositorio.delete(reserva);
    }
    

    public List<Reservation> getReservationByStatus(String status){

        return reservationCrudRepositorio.findAllByStatus(status);

    }

   

   public List<Reservation> getReservationPeriod(Date a, Date b){

       return reservationCrudRepositorio.findAllByStartDateAfterAndStartDateBefore(a, b);

   }

   

   public List<ContadorClientes> getTopClients(){

       List<ContadorClientes> res= new ArrayList<>();

       List<Object[]> report = reservationCrudRepositorio.countTotalReservationByClient();

       for(int i=0;i<report.size();i++){

           res.add(new ContadorClientes((Long)report.get(i)[1],(client) report.get(i)[0] ));

       }

       return res;

   }




}
