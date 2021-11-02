package co.usa.mintic.retotres.repository.crud;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.usa.mintic.retotres.model.Reservation;

public interface ReservationCrudRepositorio extends CrudRepository<Reservation,Integer> {
    
    public List<Reservation> findAllByStatus (String status);


    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    
    //select clientid, count(*) as "total" from reservacion group by clientid order by total desc;

    @Query("SELECT c.client, COUNT(c.client) FROM Reservation AS c group by c.client order by COUNT(c.client)DESC")

    public List<Object[]> countTotalReservationByClient();
}
