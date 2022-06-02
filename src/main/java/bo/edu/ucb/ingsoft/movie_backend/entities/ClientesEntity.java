package bo.edu.ucb.ingsoft.movie_backend.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "clientes", schema = "public", catalog = "postgres")
public class ClientesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idcli", nullable = false)
    private int idcli;
    @Basic
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Basic
    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;
    @Basic
    @Column(name = "usuario", nullable = false, length = 50)
    private String usuario;
    @Basic
    @Column(name = "password", nullable = false, length = 50)
    private String password;

    public int getIdcli() {
        return idcli;
    }

    public void setIdcli(int idcli) {
        this.idcli = idcli;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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
        ClientesEntity that = (ClientesEntity) o;
        return idcli == that.idcli && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido) && Objects.equals(usuario, that.usuario) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcli, nombre, apellido, usuario, password);
    }
}
