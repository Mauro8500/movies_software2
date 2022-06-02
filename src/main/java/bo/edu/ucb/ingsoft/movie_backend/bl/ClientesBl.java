package bo.edu.ucb.ingsoft.movie_backend.bl;

import bo.edu.ucb.ingsoft.movie_backend.dao.ClientesRespository;
import bo.edu.ucb.ingsoft.movie_backend.entities.Cliente;
import bo.edu.ucb.ingsoft.movie_backend.entities.ClientesEntity;
import bo.edu.ucb.ingsoft.movie_backend.entities.PeliculasEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ClientesBl {

    private ClientesRespository clientesRespository;
    Logger LOGGER = LoggerFactory.getLogger(ClientesBl.class);

    public ClientesBl(ClientesRespository clientesRespository) {
        this.clientesRespository = clientesRespository;
    }

    public void agregarCliente(ClientesEntity clientesEntity) {
        LOGGER.info("Metodo agregarCliente desde ClientesBl");
        this.clientesRespository.save(clientesEntity);
    }

    public Cliente obtenerCliente(Integer idcli) {
        LOGGER.info("Metodo obtenerCliente desde ClientesBl");
        ClientesEntity clientesEntity = this.clientesRespository.obtenerClientePorID(idcli);
        Cliente cliente = new Cliente(clientesEntity.getIdcli(),clientesEntity.getNombre(),clientesEntity.getApellido());
        return cliente;
    }



}
