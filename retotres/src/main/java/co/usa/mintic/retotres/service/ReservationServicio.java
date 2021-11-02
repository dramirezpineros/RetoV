package co.usa.mintic.retotres.service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.usa.mintic.retotres.model.Reservation;
import co.usa.mintic.retotres.model.reportes.ContadorClientes;
import co.usa.mintic.retotres.model.reportes.StatusReservas;
import co.usa.mintic.retotres.repository.ReservationRepositorio;


/**
 * clase principal
 * @author Diego
 */
@Service
public class ReservationServicio {
    @Autowired
    /**
     * instaciamiento
     */
    private ReservationRepositorio reservationRepositorio;
    /**
     * metodo get de reservaciones
     * @return
     */
    public List<Reservation> getAll(){
        return reservationRepositorio.getAll();
    }
    /**
     * metodo get reserva
     * @param id
     * @return
     */
    public Optional<Reservation> getReserva(int id){
        return reservationRepositorio.getReserva(id);
    }
    /**
     * metodo save reserva
     * @param reserva
     * @return
     */
    public Reservation save(Reservation reserva){
        if(reserva.getIdReservation()==null){
            return reservationRepositorio.save(reserva);
        }else{
            Optional<Reservation> consulta=reservationRepositorio.getReserva(reserva.getIdReservation());
            if(consulta.isEmpty()){
                return reservationRepositorio.save(reserva);
            }else{
                return reserva;
            }
        }
    }
    /**
     * metodo delete
     * @param id
     * @return
     */
    public boolean deleteReserva(int id){
        Optional<Reservation> consulta=reservationRepositorio.getReserva(id);
        if(!consulta.isEmpty()){
            reservationRepositorio.delete(consulta.get());
            return true;
        }
        return false;
    }
    /**
     * metodo update reserva
     * @param reserva
     * @return
     */
    public Reservation update(Reservation reserva){
        if(reserva.getIdReservation()!=null){
            Optional<Reservation> consulta=reservationRepositorio.getReserva(reserva.getIdReservation());
            if(!consulta.isEmpty()){
                if(reserva.getStartDate()!=null){
                    consulta.get().setStartDate(reserva.getStartDate());
                }
            if(reserva.getDevolutionDate()!=null){
                consulta.get().setDevolutionDate(reserva.getDevolutionDate());
                }
            if(reserva.getStatus ()!=null){
                consulta.get().setStatus(reserva.getStatus());
                }
            if(reserva.getScore()!=null){
                consulta.get().setScore(reserva.getScore());
            }

            return reservationRepositorio.save(consulta.get());
            }
        }
        return reserva;
    }





    public StatusReservas getReservationsStatusReport(){

        List<Reservation>completed=reservationRepositorio.getReservationByStatus("completed");

        List<Reservation>cancelled=reservationRepositorio.getReservationByStatus("cancelled");

    return new StatusReservas(completed.size(), cancelled.size());

    }

   

    public List<Reservation> getReservationPeriod(String dateA, String dateB){

        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");

        Date aDate= new Date();

        Date bDate= new Date();

       

       try {

           aDate = parser.parse(dateA);

           bDate = parser.parse(dateB);

       }catch(ParseException evt){

           evt.printStackTrace();

       }

       if(aDate.before(bDate)){

           return reservationRepositorio.getReservationPeriod(aDate, bDate);

       }else{

           return new ArrayList<>();

       }

       

   

    }

    public List<ContadorClientes> getTopClients(){

        return reservationRepositorio.getTopClients();

    }




    
}
