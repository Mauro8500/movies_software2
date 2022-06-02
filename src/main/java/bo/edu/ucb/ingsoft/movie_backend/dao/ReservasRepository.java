package bo.edu.ucb.ingsoft.movie_backend.dao;

import bo.edu.ucb.ingsoft.movie_backend.entities.PeliculasEntity;
import bo.edu.ucb.ingsoft.movie_backend.entities.ReservasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservasRepository extends JpaRepository<ReservasEntity,Integer> {

    @Query(
            value = "SELECT r\n" +
                    "FROM ReservasEntity r\n" +
                    "WHERE r.pickupsIdpickups = ?1"
    )
    List<ReservasEntity> obtenerPickups(int idPickup);

}