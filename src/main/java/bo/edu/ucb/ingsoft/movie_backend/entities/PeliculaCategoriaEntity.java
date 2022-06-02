package bo.edu.ucb.ingsoft.movie_backend.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pelicula_categoria", schema = "public", catalog = "postgres")
public class PeliculaCategoriaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_peca", nullable = false)
    private int idPeca;
    @Basic
    @Column(name = "peliculas_idpeli", nullable = false)
    private int peliculasIdpeli;
    @Basic
    @Column(name = "categoria_id_categoria", nullable = false)
    private int categoriaIdCategoria;

    public int getIdPeca() {
        return idPeca;
    }

    public void setIdPeca(int idPeca) {
        this.idPeca = idPeca;
    }

    public int getPeliculasIdpeli() {
        return peliculasIdpeli;
    }

    public void setPeliculasIdpeli(int peliculasIdpeli) {
        this.peliculasIdpeli = peliculasIdpeli;
    }

    public int getCategoriaIdCategoria() {
        return categoriaIdCategoria;
    }

    public void setCategoriaIdCategoria(int categoriaIdCategoria) {
        this.categoriaIdCategoria = categoriaIdCategoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeliculaCategoriaEntity that = (PeliculaCategoriaEntity) o;
        return idPeca == that.idPeca && peliculasIdpeli == that.peliculasIdpeli && categoriaIdCategoria == that.categoriaIdCategoria;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPeca, peliculasIdpeli, categoriaIdCategoria);
    }
}
