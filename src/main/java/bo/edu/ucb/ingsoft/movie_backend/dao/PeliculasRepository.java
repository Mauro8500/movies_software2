package bo.edu.ucb.ingsoft.movie_backend.dao;

import bo.edu.ucb.ingsoft.movie_backend.entities.PeliculasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface PeliculasRepository extends JpaRepository<PeliculasEntity,Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE PeliculasEntity p SET p.status = 0 WHERE p.idpeli = :id")
    void eliminarPelicula(@Param(value = "id") int id);

    @Query(
            value = "SELECT p \n" +
                    "FROM PeliculasEntity p\n" +
                    "WHERE p.status = 1"
    )
    List<PeliculasEntity> peliculasDisponibles();

    @Query(
            value = "SELECT p \n" +
                    "FROM PeliculasEntity p\n" +
                    "WHERE p.idpeli = ?1"
    )
    PeliculasEntity peliculaPorID(int idPelicula);

    @Query(
            value = "SELECT p\n" +
                    "FROM PeliculasEntity p\n" +
                    "LEFT JOIN PeliculaActorEntity pa ON ( pa.peliculasIdpeli = p.idpeli)\n" +
                    "LEFT JOIN ActorEntity a ON ( a.idAct = pa.actorIdAct)\n" +
                    "WHERE a.nombre LIKE (?1)\n" +
                    "OR a.apellido LIKE (?2)\n" +
                    "AND p.status = 1"
    )
    List<PeliculasEntity> peliculaPorActor(String nombre, String apellido);

    @Query(
            value = "SELECT p\n" +
                    "FROM PeliculasEntity p\n" +
                    "WHERE p.nombre LIKE (?1)\n" +
                    "AND p.status = 1"
    )
    List<PeliculasEntity> peliculasPorTitulo(String titulo);

    @Query(
            value = "SELECT p\n" +
                    "FROM PeliculasEntity p\n" +
                    "LEFT JOIN PeliculaActorEntity pa ON ( pa.peliculasIdpeli = p.idpeli)\n" +
                    "LEFT JOIN ActorEntity a ON ( a.idAct = pa.actorIdAct)\n" +
                    "WHERE a.nombre LIKE (?1)\n" +
                    "OR a.apellido LIKE (?2)\n"+
                    "AND p.nombre LIKE (?3)\n and p.status = 1"
    )
    List<PeliculasEntity> peliculaPorActorYNombre(String nombre, String apellido,String nombrePelicula);

    @Query(
            value = "SELECT p\n" +
                    "FROM PeliculasEntity p\n" +
                    "LEFT JOIN PeliculaActorEntity pa ON ( pa.peliculasIdpeli = p.idpeli)\n" +
                    "LEFT JOIN ActorEntity a ON ( a.idAct = pa.actorIdAct)\n" +
                    "LEFT JOIN PeliculaCategoriaEntity pc ON ( pc.peliculasIdpeli = p.idpeli)\n" +
                    "LEFT JOIN CategoriaEntity c ON ( c.idCategoria = pc.categoriaIdCategoria)\n" +
                    "WHERE a.nombre LIKE (?1)\n" +
                    "OR a.apellido LIKE (?2)\n"+
                    "AND p.nombre LIKE (?3)\n"+
                    "AND c.nombrecate LIKE (?4)\n " +
                    "AND p.status = 1"
    )
    List<PeliculasEntity> peliculaPorActorYNombreYCategoria(String nombre, String apellido,String nombrePelicula, String categoria);
    @Query(
            value = "SELECT p\n" +
                    "FROM PeliculasEntity p\n" +
                    "LEFT JOIN PeliculaCategoriaEntity pc ON ( pc.peliculasIdpeli = p.idpeli)\n" +
                    "LEFT JOIN CategoriaEntity c ON ( c.idCategoria = pc.categoriaIdCategoria)\n" +
                    "WHERE c.nombrecate LIKE (?1)\n" +
                    "AND p.status = 1"
    )
    List<PeliculasEntity> peliculaPorCategoria(String categoria);

}