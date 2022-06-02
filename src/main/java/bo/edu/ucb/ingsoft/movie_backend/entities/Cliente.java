package bo.edu.ucb.ingsoft.movie_backend.entities;


public class Cliente {
    private int idcli;
    private String nombre;
    private String apellido;

    public Cliente(int idcli, String nombre, String apellido) {
        this.idcli = idcli;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Cliente() {

    }

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
}
