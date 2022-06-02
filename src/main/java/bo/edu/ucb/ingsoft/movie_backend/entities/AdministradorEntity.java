package bo.edu.ucb.ingsoft.movie_backend.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "administrador", schema = "public", catalog = "postgres")
public class AdministradorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idadm", nullable = false)
    private int idadm;
    @Basic
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Basic
    @Column(name = "usuario", nullable = false, length = 50)
    private String usuario;
    @Basic
    @Column(name = "password", nullable = false, length = 50)
    private String password;

    public int getIdadm() {
        return idadm;
    }

    public void setIdadm(int idadm) {
        this.idadm = idadm;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdministradorEntity that = (AdministradorEntity) o;
        return idadm == that.idadm && Objects.equals(nombre, that.nombre) && Objects.equals(usuario, that.usuario) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idadm, nombre, usuario, password);
    }
}
