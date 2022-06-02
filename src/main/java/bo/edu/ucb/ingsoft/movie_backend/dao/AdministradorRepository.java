package bo.edu.ucb.ingsoft.movie_backend.dao;

import bo.edu.ucb.ingsoft.movie_backend.entities.AdministradorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorRepository extends JpaRepository<AdministradorEntity,Integer> {
}
