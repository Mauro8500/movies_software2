package bo.edu.ucb.ingsoft.movie_backend.bl;

import bo.edu.ucb.ingsoft.movie_backend.api.AdministradorAPI;
import bo.edu.ucb.ingsoft.movie_backend.dao.CategoriaRepository;
import bo.edu.ucb.ingsoft.movie_backend.dao.PeliculasRepository;
import bo.edu.ucb.ingsoft.movie_backend.dao.ReservasRepository;
import bo.edu.ucb.ingsoft.movie_backend.entities.CategoriaEntity;
import bo.edu.ucb.ingsoft.movie_backend.entities.PeliculasEntity;
import bo.edu.ucb.ingsoft.movie_backend.entities.ReservasEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorBl {
    private PeliculasRepository peliculasRepository;
    private ReservasRepository reservasRepository;
    private CategoriaRepository categoriaRepository;
    Logger LOGGER = LoggerFactory.getLogger(AdministradorBl.class);


    public AdministradorBl(PeliculasRepository peliculasRepository,ReservasRepository reservasRepository, CategoriaRepository categoriaRepository) {
        this.peliculasRepository = peliculasRepository;
        this.reservasRepository = reservasRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public PeliculasEntity agregarPelicula(PeliculasEntity peliculasEntity) {
        LOGGER.info("Metodo agregarPelicula desde AdministradorBl");
        return this.peliculasRepository.save(peliculasEntity);
    }

    public List<PeliculasEntity> obtenerPeliculas() {
        LOGGER.info("Metodo obtenerPeliculas desde AdministradorBl");
        return this.peliculasRepository.findAll();
    }

    public String editarPeliculas(PeliculasEntity peliculasEntity,Integer id) {
        LOGGER.info("Metodo editarPeliculas desde AdministradorBl");
        return this.peliculasRepository.findById(id).map(pelicula -> {
          pelicula.setNombre(peliculasEntity.getNombre());
          pelicula.setDescripcion(peliculasEntity.getDescripcion());
          pelicula.setPrecio(peliculasEntity.getPrecio());
          pelicula.setDisponibilidad(peliculasEntity.getDisponibilidad());

          peliculasRepository.save(pelicula);

          return "La pelicula ha sido actualizada.";
        }).orElseGet(() -> {
            return "La pelicula con id "+id+" no existe.";
        });
    }

    public PeliculasEntity obtenerPeliculaPorID(Integer id) {
        LOGGER.info("Metodo obtenerPeliculaPorID desde AdministradorBl");
        return this.peliculasRepository.peliculaPorID(id);
    }

    public List<ReservasEntity> obtenerPickups(Integer id) {
        LOGGER.info("Metodo obtenerPickups desde AdministradorBl");
        return this.reservasRepository.obtenerPickups(id);
    }

    public void borrarPelicula(Integer idpeli) {
        LOGGER.info("Metodo borrarPelicula desde AdministradorBl");
        this.peliculasRepository.eliminarPelicula(idpeli);
    }

    public CategoriaEntity agregarCategoria(CategoriaEntity categoriaEntity) {
        LOGGER.info("Metodo agregarCategoria desde AdministradorBl");
        return this.categoriaRepository.save(categoriaEntity);
    }
}
