package mx.uv.SaludarRest;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludarControlador {
    ArrayList<Saludos> listaSaludos = new ArrayList<Saludos>();
    private int cont = 1;

    @RequestMapping("/SaludarRequest/{nombre}")
    public String SaludarRequest(@PathVariable(("nombre"))String nombreX)
    {
        Saludos saludo = new Saludos();
        saludo.setID(cont);
        saludo.setNombre(nombreX);
        listaSaludos.add(saludo);
        cont ++;
        return "Hola "+ nombreX;
    }

    @GetMapping("/BuscarSaludosRequest")
    public ArrayList<Saludos> BuscarSaludosRequest()
    {
        return listaSaludos;
    }

    @GetMapping("/ModificarSaludoRequest/{id}/{nombre}")
    public Boolean ModificarSaludoRequest(@PathVariable("id") int id, @PathVariable("nombre") String nombreX)
    {
        for(Saludos o : listaSaludos)
        {
            if(o.getID() == id)
            {
                o.setID(id);
                o.setNombre(nombreX);
            }
        }
        
        return true;
    }

    @GetMapping("/BorrarSaludoResponse/{id}")
    public Boolean BorrarSaludoResponse(@PathVariable("id") int id)
    {
        for(Saludos o : listaSaludos)
        {
            if(o.getID() == id)
            {
                listaSaludos.remove(o);
            }
        }
        
        return true;
    }
}