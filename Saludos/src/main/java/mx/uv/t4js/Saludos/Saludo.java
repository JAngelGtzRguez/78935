package mx.uv.t4js.Saludos;

public class Saludo {
    private int id;
    private String nombre;

    public Saludo(){

    }

    public Saludo(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
