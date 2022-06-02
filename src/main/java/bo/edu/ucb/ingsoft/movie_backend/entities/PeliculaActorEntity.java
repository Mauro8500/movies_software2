package bo.edu.ucb.ingsoft.movie_backend.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pelicula_actor", schema = "public", catalog = "postgres")
public class PeliculaActorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_peac", nullable = false)
    private int idPeac;
    @Basic
    @Column(name = "peliculas_idpeli", nullable = false)
    private int peliculasIdpeli;
    @Basic
    @Column(name = "actor_id_act", nullable = false)
    private int actorIdAct;

    public int getIdPeac() {
        return idPeac;
    }

    public void setIdPeac(int idPeac) {
        this.idPeac = idPeac;
    }

    public int getPeliculasIdpeli() {
        return peliculasIdpeli;
    }

    public void setPeliculasIdpeli(int peliculasIdpeli) {
        this.peliculasIdpeli = peliculasIdpeli;
    }

    public int getActorIdAct() {
        return actorIdAct;
    }

    public void setActorIdAct(int actorIdAct) {
        this.actorIdAct = actorIdAct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeliculaActorEntity that = (PeliculaActorEntity) o;
        return idPeac == that.idPeac && peliculasIdpeli == that.peliculasIdpeli && actorIdAct == that.actorIdAct;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPeac, peliculasIdpeli, actorIdAct);
    }
}
