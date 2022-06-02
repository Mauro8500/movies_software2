package bo.edu.ucb.ingsoft.movie_backend.api;

import bo.edu.ucb.ingsoft.movie_backend.bl.ReservasBl;
import bo.edu.ucb.ingsoft.movie_backend.entities.ClientesEntity;
import bo.edu.ucb.ingsoft.movie_backend.entities.ReservasEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservasAPI {
    private ReservasBl reservasBl;
    Logger LOGGER = LoggerFactory.getLogger(ReservasAPI.class);

    public ReservasAPI(ReservasBl reservasBl) {
        this.reservasBl = reservasBl;
    }

    @GetMapping("administrador")
    public ResponseEntity<List<ReservasEntity>> obtenerReservas(){
        LOGGER.info("Metodo obtenerReservas desde ReservasAPI");
        List<ReservasEntity> reservas = this.reservasBl.obtenerReservas();
        return new ResponseEntity<List<ReservasEntity>>(reservas, HttpStatus.OK);
    }

    @PostMapping("clientes")
    public ResponseEntity<String> agregarCliente(@RequestBody ReservasEntity reservasEntity){
        LOGGER.info("Metodo agregarCliente desde ReservasAPI");
        this.reservasBl.agregarReserva(reservasEntity);
        return new ResponseEntity<String>("Reserva agregada satisfactoriamente.", HttpStatus.OK);
    }


}
