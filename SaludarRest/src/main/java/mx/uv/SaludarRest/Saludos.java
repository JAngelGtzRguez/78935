package mx.uv.SaludarRest;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class Saludos {
    private int ID;
    private String nombre;
    
    public Saludos(int ID, String nombre) {
        this.ID = ID;
        this.nombre = nombre;
    }

    public Saludos() {
        
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
