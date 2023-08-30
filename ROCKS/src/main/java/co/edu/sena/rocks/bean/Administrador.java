package co.edu.sena.rocks.bean;

public class Administrador {
    private static Integer id;
    private String nombre;
    private String correo;
    private int documento;
    private String tipo_rol;


    public Administrador() {
    }

    public Administrador(Integer id, String nombre, String correo, int documento, String tipo_rol) {  
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.documento = documento;     
        this.tipo_rol = tipo_rol;
        }

    public static Integer getId() {
        return id;
    }

    public static void setId(Integer id) {
        Administrador.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getTipo_rol() {
        return tipo_rol;
    }

    public void setTipo_rol(String tipo_rol) {
        this.tipo_rol = tipo_rol;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", documento=" + documento +
                ", tipo_rol=" + tipo_rol +

                '}';
    }
}
