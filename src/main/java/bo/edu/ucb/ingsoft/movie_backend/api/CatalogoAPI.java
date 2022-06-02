package bo.edu.ucb.ingsoft.movie_backend.api;

import bo.edu.ucb.ingsoft.movie_backend.bl.CatalogoBl;
import bo.edu.ucb.ingsoft.movie_backend.entities.PeliculasEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/catalogo")
public class CatalogoAPI {

    private CatalogoBl catalogoBl;

    public CatalogoAPI(CatalogoBl catalogoBl) {
        this.catalogoBl = catalogoBl;
    }

    Logger LOGGER = LoggerFactory.getLogger(AdministradorAPI.class);

    @GetMapping("peliculas")
    public ResponseEntity<List<PeliculasEntity>> obtenerPeliculasPorActorONombreOCategoria(@RequestParam(name="pelicula",required = false) String pelicula, @RequestParam(name="actor",required = false) String actor, @RequestParam(name="categoria",required = false) String categoria ){
        LOGGER.info("Metodo obtenerPeliculasPorActorONombreOCategoria desde CatalogoAPI");
        List<PeliculasEntity> listaPeliculas=null;

        if(pelicula!=null && actor!=null && categoria!=null){
            listaPeliculas = this.catalogoBl.obtenerPeliculaPorActorYNombreYCategoria(actor,pelicula,categoria);
        }else if (pelicula!=null && actor!=null && categoria==null) {
            listaPeliculas = this.catalogoBl.obtenerPeliculaPorActorYNombre(actor,pelicula);
        }else if(pelicula!=null && actor==null && categoria == null){
            listaPeliculas = this.catalogoBl.obtenerPeliculaPorNombre(pelicula);
        }else if(pelicula==null && actor!=null && categoria == null){
            listaPeliculas = this.catalogoBl.obtenerPeliculaPorActor(actor);
        }else if(pelicula==null && actor==null && categoria != null){
            listaPeliculas = this.catalogoBl.obtenerPeliculaPorCategoria(categoria);
        }else{
            listaPeliculas = this.catalogoBl.obtenerPeliculas();
        }

        return new ResponseEntity<>(listaPeliculas, HttpStatus.OK);
    }



}
