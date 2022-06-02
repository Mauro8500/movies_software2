package bo.edu.ucb.ingsoft.movie_backend.dao;

import bo.edu.ucb.ingsoft.movie_backend.entities.Cliente;
import bo.edu.ucb.ingsoft.movie_backend.entities.ClientesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientesRespository extends JpaRepository<ClientesEntity,Integer> {

    @Query(
            value = "SELECT c \n" +
                    "FROM ClientesEntity c\n" +
                    "WHERE c.idcli = ?1"
    )
    public ClientesEntity obtenerClientePorID(int idcli);
}

