package bo.edu.ucb.ingsoft.movie_backend.api;

import bo.edu.ucb.ingsoft.movie_backend.bl.AdministradorBl;
import bo.edu.ucb.ingsoft.movie_backend.entities.CategoriaEntity;
import bo.edu.ucb.ingsoft.movie_backend.entities.PeliculasEntity;
import bo.edu.ucb.ingsoft.movie_backend.entities.ReservasEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administrador")
public class AdministradorAPI {
    private AdministradorBl administradorBl;
    Logger LOGGER = LoggerFactory.getLogger(AdministradorAPI.class);

    public AdministradorAPI(AdministradorBl administradorBl) {
        this.administradorBl = administradorBl;
    }

    @GetMapping("peliculas")
    public ResponseEntity<List<PeliculasEntity>> obtenerPeliculas(){
        LOGGER.info("Metodo obtenerPeliculas desde AdministradoAPI");
        List<PeliculasEntity> listaPeliculas = this.administradorBl.obtenerPeliculas();
        return new ResponseEntity<List<PeliculasEntity>>(listaPeliculas, HttpStatus.OK);
    }

    @GetMapping("peliculas/{idPelicula}")
    public ResponseEntity<PeliculasEntity> obtenerPeliculaPorID(@PathVariable Integer idPelicula){
        LOGGER.info("Metodo obtenerPeliculaPorID desde AdministradoAPI");
        PeliculasEntity pelicula = this.administradorBl.obtenerPeliculaPorID(idPelicula);
        return new ResponseEntity<PeliculasEntity>(pelicula, HttpStatus.OK);
    }

    @PostMapping("peliculas")
    public ResponseEntity<PeliculasEntity> agregarPeliculas(@RequestBody PeliculasEntity peliculasEntity){
        LOGGER.info("Metodo agregarPeliculas desde AdministradoAPI");
        PeliculasEntity peliculaAgregada=this.administradorBl.agregarPelicula(peliculasEntity);
        return new ResponseEntity<>(peliculaAgregada, HttpStatus.OK);
    }

    @PutMapping("peliculas/{idPelicula}")
    public ResponseEntity<String> modificarPeliculas(@PathVariable Integer idPelicula, @RequestBody PeliculasEntity peliculasEntity){
        LOGGER.info("Metodo modificarPeliculas desde AdministradoAPI");
        String respuesta = this.administradorBl.editarPeliculas(peliculasEntity,idPelicula);
        return new ResponseEntity<String>(respuesta, HttpStatus.OK);
    }

    @GetMapping("peliculas/pickups/{idPickup}")
    public ResponseEntity<List<ReservasEntity>> obtenerPickups(@PathVariable Integer idPickup){
        LOGGER.info("Metodo obtenerPickups desde AdministradoAPI");
        List<ReservasEntity> listaReservas = this.administradorBl.obtenerPickups(idPickup);
        return new ResponseEntity<List<ReservasEntity>>(listaReservas, HttpStatus.OK);
    }


    @DeleteMapping("peliculas/{idpeli}")
    public ResponseEntity<String> eliminarPelicula(@PathVariable Integer idpeli){
        LOGGER.info("Metodo obtenerPickups desde AdministradoAPI");
        this.administradorBl.borrarPelicula(idpeli);
        return new ResponseEntity<String>("Pelicula borrada satisfactoriamente.", HttpStatus.OK);
    }
    @PostMapping("categoria")
    public ResponseEntity<CategoriaEntity> agregarCategoria(@RequestBody CategoriaEntity categoriaEntity){
        LOGGER.info("Metodo agregarPeliculas desde AdministradoAPI");
        CategoriaEntity agregarCategoria=this.administradorBl.agregarCategoria(categoriaEntity);
        return new ResponseEntity<CategoriaEntity>(agregarCategoria, HttpStatus.OK);
    }
}
