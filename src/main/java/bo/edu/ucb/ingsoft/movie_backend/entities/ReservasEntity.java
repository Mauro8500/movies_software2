package bo.edu.ucb.ingsoft.movie_backend.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "reservas", schema = "public", catalog = "postgres")
public class ReservasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idreserva", nullable = false)
    private int idreserva;
    @Basic
    @Column(name = "num_reservas", nullable = false)
    private int numReservas;
    @Basic
    @Column(name = "metodotarjeta", nullable = false)
    private int metodotarjeta;
    @Basic
    @Column(name = "metodoefectivo", nullable = false, length = 50)
    private String metodoefectivo;
    @Basic
    @Column(name = "peliculas_idpeli", nullable = false)
    private int peliculasIdpeli;
    @Basic
    @Column(name = "clientes_idcli", nullable = false)
    private int clientesIdcli;
    @Basic
    @Column(name = "pickups_idpickups", nullable = false)
    private int pickupsIdpickups;

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public int getNumReservas() {
        return numReservas;
    }

    public void setNumReservas(int numReservas) {
        this.numReservas = numReservas;
    }

    public int getMetodotarjeta() {
        return metodotarjeta;
    }

    public void setMetodotarjeta(int metodotarjeta) {
        this.metodotarjeta = metodotarjeta;
    }

    public String getMetodoefectivo() {
        return metodoefectivo;
    }

    public void setMetodoefectivo(String metodoefectivo) {
        this.metodoefectivo = metodoefectivo;
    }

    public int getPeliculasIdpeli() {
        return peliculasIdpeli;
    }

    public void setPeliculasIdpeli(int peliculasIdpeli) {
        this.peliculasIdpeli = peliculasIdpeli;
    }

    public int getClientesIdcli() {
        return clientesIdcli;
    }

    public void setClientesIdcli(int clientesIdcli) {
        this.clientesIdcli = clientesIdcli;
    }

    public int getPickupsIdpickups() {
        return pickupsIdpickups;
    }

    public void setPickupsIdpickups(int pickupsIdpickups) {
        this.pickupsIdpickups = pickupsIdpickups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservasEntity that = (ReservasEntity) o;
        return idreserva == that.idreserva && numReservas == that.numReservas && metodotarjeta == that.metodotarjeta && peliculasIdpeli == that.peliculasIdpeli && clientesIdcli == that.clientesIdcli && pickupsIdpickups == that.pickupsIdpickups && Objects.equals(metodoefectivo, that.metodoefectivo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idreserva, numReservas, metodotarjeta, metodoefectivo, peliculasIdpeli, clientesIdcli, pickupsIdpickups);
    }
}
