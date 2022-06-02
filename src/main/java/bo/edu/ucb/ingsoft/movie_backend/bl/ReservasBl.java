package bo.edu.ucb.ingsoft.movie_backend.bl;

import bo.edu.ucb.ingsoft.movie_backend.dao.ReservasRepository;
import bo.edu.ucb.ingsoft.movie_backend.entities.PeliculasEntity;
import bo.edu.ucb.ingsoft.movie_backend.entities.ReservasEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservasBl {
    private ReservasRepository reservasRepository;
    Logger LOGGER = LoggerFactory.getLogger(ClientesBl.class);

    public ReservasBl(ReservasRepository reservasRepository) {
        this.reservasRepository = reservasRepository;
    }

    public void agregarReserva(ReservasEntity reservasEntity) {
        LOGGER.info("Metodo agregarReserva desde ReservasBl");
        this.reservasRepository.save(reservasEntity);
    }

    public List<ReservasEntity> obtenerPickups(Integer idPickups) {
        LOGGER.info("Metodo obtenerPickups desde ReservasBl");
        return this.reservasRepository.obtenerPickups(idPickups);
    }

    public List<ReservasEntity> obtenerReservas() {
        LOGGER.info("Metodo obtenerReservas desde ReservasBl");
        return this.reservasRepository.findAll();
    }

}
