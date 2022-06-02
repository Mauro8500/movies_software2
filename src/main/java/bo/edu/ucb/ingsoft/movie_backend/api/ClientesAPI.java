package bo.edu.ucb.ingsoft.movie_backend.api;

import bo.edu.ucb.ingsoft.movie_backend.bl.AdministradorBl;
import bo.edu.ucb.ingsoft.movie_backend.bl.ClientesBl;
import bo.edu.ucb.ingsoft.movie_backend.entities.Cliente;
import bo.edu.ucb.ingsoft.movie_backend.entities.ClientesEntity;
import bo.edu.ucb.ingsoft.movie_backend.entities.PeliculasEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientesAPI {
    private ClientesBl clientesBl;
    Logger LOGGER = LoggerFactory.getLogger(AdministradorAPI.class);

    public ClientesAPI(ClientesBl clientesBl) {
        this.clientesBl = clientesBl;
    }

    @PostMapping("clientes")
    public ResponseEntity<String> agregarCliente(@RequestBody ClientesEntity clientesEntity){
        LOGGER.info("Metodo agregarCliente desde ClientesAPI");
        this.clientesBl.agregarCliente(clientesEntity);
        return new ResponseEntity<String>("Pelicula agregada satisfactoriamente.", HttpStatus.OK);
    }

    @GetMapping("clientes/{idcli}")
    public ResponseEntity<Cliente> obtenerClientePorID(@PathVariable Integer idcli){
        LOGGER.info("Metodo obtenerClientePorID desde ClientesAPI");
        Cliente cliente = this.clientesBl.obtenerCliente(idcli);
        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }
}
