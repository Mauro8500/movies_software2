package bo.edu.ucb.ingsoft.movie_backend.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pickups", schema = "public", catalog = "postgres")
public class PickupsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idpickups", nullable = false)
    private int idpickups;
    @Basic
    @Column(name = "detalle", nullable = false, length = 500)
    private String detalle;

    public int getIdpickups() {
        return idpickups;
    }

    public void setIdpickups(int idpickups) {
        this.idpickups = idpickups;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PickupsEntity that = (PickupsEntity) o;
        return idpickups == that.idpickups && Objects.equals(detalle, that.detalle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idpickups, detalle);
    }
}
