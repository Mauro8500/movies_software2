package bo.edu.ucb.ingsoft.movie_backend.bl;

import bo.edu.ucb.ingsoft.movie_backend.dao.PeliculasRepository;
import bo.edu.ucb.ingsoft.movie_backend.dao.ReservasRepository;
import bo.edu.ucb.ingsoft.movie_backend.entities.PeliculasEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogoBl {

    private PeliculasRepository peliculasRepository;

    Logger LOGGER = LoggerFactory.getLogger(AdministradorBl.class);


    public CatalogoBl(PeliculasRepository peliculasRepository, ReservasRepository reservasRepository) {
        this.peliculasRepository = peliculasRepository;
    }


    public List<PeliculasEntity> obtenerPeliculas() {
        LOGGER.info("Metodo obtenerPeliculas desde CatalogoBl");
        return this.peliculasRepository.peliculasDisponibles();
    }

    public List<PeliculasEntity> obtenerPeliculaPorActor(String actor) {
        LOGGER.info("Metodo obtenerPeliculaPorActor desde CatalogoBl");
        String[] nombre_apellido = actor.trim().split(" ");
        String nombre, apellido;

        if(nombre_apellido.length==1){
            nombre="%"+nombre_apellido[0].trim()+"%";
            apellido="%"+nombre_apellido[0].trim()+"%";
        }else{
            nombre="%"+nombre_apellido[0].trim()+"%";
            apellido="%"+nombre_apellido[1].trim()+"%";
        }
        return this.peliculasRepository.peliculaPorActor(nombre,apellido);
    }

    public List<PeliculasEntity> obtenerPeliculaPorNombre(String nombre) {
        LOGGER.info("Metodo obtenerPeliculaPorNombre desde CatalogoBl");
        String n="%"+nombre+"%";
        return this.peliculasRepository.peliculasPorTitulo(n);
    }

    public List<PeliculasEntity> obtenerPeliculaPorActorYNombre(String actor, String titulo) {
        LOGGER.info("Metodo obtenerPeliculaPorActorYNombre desde CatalogoBl");
        String nombrePelicula="%"+titulo+"%";

        String[] nombre_apellido = actor.trim().split(" ");
        String nombre, apellido;

        if(nombre_apellido.length==1){
            nombre="%"+nombre_apellido[0].trim()+"%";
            apellido="%"+nombre_apellido[0].trim()+"%";
        }else{
            nombre="%"+nombre_apellido[0].trim()+"%";
            apellido="%"+nombre_apellido[1].trim()+"%";
        }
        return this.peliculasRepository.peliculaPorActorYNombre(nombre,apellido,nombrePelicula);
    }

    public List<PeliculasEntity> obtenerPeliculaPorActorYNombreYCategoria(String actor, String titulo, String cat) {
        LOGGER.info("Metodo obtenerPeliculaPorActorYNombreYCategoria desde CatalogoBl");
        String nombrePelicula="%"+titulo+"%";
        String categoria = "%"+cat+"%";

        String[] nombre_apellido = actor.trim().split(" ");
        String nombre, apellido;

        if(nombre_apellido.length==1){
            nombre="%"+nombre_apellido[0].trim()+"%";
            apellido="%"+nombre_apellido[0].trim()+"%";
        }else{
            nombre="%"+nombre_apellido[0].trim()+"%";
            apellido="%"+nombre_apellido[1].trim()+"%";
        }
        return this.peliculasRepository.peliculaPorActorYNombreYCategoria(nombre,apellido,nombrePelicula,categoria);
    }

    public List<PeliculasEntity> obtenerPeliculaPorCategoria(String cat) {
        LOGGER.info("Metodo obtenerPeliculaPorCategoria desde CatalogoBl");
        String categoria = "%"+cat+"%";
        return this.peliculasRepository.peliculaPorCategoria(categoria);
    }
}
