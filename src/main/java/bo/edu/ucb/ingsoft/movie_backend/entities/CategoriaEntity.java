package bo.edu.ucb.ingsoft.movie_backend.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "categoria", schema = "public", catalog = "postgres")
public class CategoriaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_categoria", nullable = false)
    private int idCategoria;
    @Basic
    @Column(name = "nombrecate", nullable = false, length = 50)
    private String nombrecate;

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombrecate() {
        return nombrecate;
    }

    public void setNombrecate(String nombrecate) {
        this.nombrecate = nombrecate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriaEntity that = (CategoriaEntity) o;
        return idCategoria == that.idCategoria && Objects.equals(nombrecate, that.nombrecate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategoria, nombrecate);
    }
}
