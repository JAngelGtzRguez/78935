package uv.mx.t4is.SaludosBD;

//import java.util.ArrayList;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.saludos.BorrarSaludoRequest;
import https.t4is_uv_mx.saludos.BorrarSaludoResponse;
import https.t4is_uv_mx.saludos.BuscarSaludosResponse;
import https.t4is_uv_mx.saludos.ModificarSaludoRequest;
import https.t4is_uv_mx.saludos.ModificarSaludoResponse;
import https.t4is_uv_mx.saludos.SaludarRequest;
import https.t4is_uv_mx.saludos.SaludarResponse;





@Endpoint
public class SaludosEndPoint{
    //int contadorId = 1;
    //List<Saludo> saludos = new ArrayList<>();
    
    //SALUDAR
    /*@PayloadRoot(localPart = "SaludarRequest",namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload 
    public SaludarResponse Saludar(@RequestPayload SaludarRequest peticion){
        SaludarResponse respuesta = new SaludarResponse();
        respuesta.setRespuesta("HOLA " + peticion.getNombre());

        //------------------------
        Saludo saludo = new Saludo();
        saludo.setNombre(peticion.getNombre());
        saludo.setId(contadorId);
        saludos.add(saludo);
        contadorId = contadorId + 1;

        return respuesta;
    }*/

    @Autowired
    Isaludadores isaludadores;

    @PayloadRoot(localPart = "SaludarRequest",namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload 
    public SaludarResponse Saludar(@RequestPayload SaludarRequest peticion){
        SaludarResponse respuesta = new SaludarResponse();
        respuesta.setRespuesta("HOLA " + peticion.getNombre());

        //------------------------
        Saludadores saludo = new Saludadores();
        saludo.setNombre(peticion.getNombre());
        //saludo.setId(contadorId);
        //saludos.add(saludo);
        //contadorId = contadorId + 1;
        isaludadores.save(saludo);

        return respuesta;
    }



    //BUSCAR SALUDO 
    @PayloadRoot(localPart = "BuscarSaludosRequest",namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public BuscarSaludosResponse buscarSaludos(){
        BuscarSaludosResponse respuesta = new BuscarSaludosResponse();

       Iterable<Saludadores> lista = isaludadores.findAll();
        for (Saludadores o : lista) {
        //     BuscarSaludosResponse.Saludos saludosBusc = new BuscarSaludosResponse.Saludos();
        //     saludosBusc.setId(saludo.getId());
        //     saludosBusc.setNombre(saludo.getNombre());
                BuscarSaludosResponse.Saludos e = new BuscarSaludosResponse.Saludos();
                e.setNombre(o.getNombre());
                e.setId(o.getId());
                respuesta.getSaludos().add(e);
        //     respuesta.getSaludos().add(saludosBusc);
         }

        return respuesta;

    }

    //MODIFICAR SALUDO
    @PayloadRoot(localPart = "ModificarSaludoRequest",namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public ModificarSaludoResponse modificarSaludo(@RequestPayload ModificarSaludoRequest peticion){
        ModificarSaludoResponse respuesta = new ModificarSaludoResponse();


        Saludadores e = new Saludadores();
        e.setId(peticion.getId());
        e.setNombre(peticion.getNombre());
        isaludadores.save(e);
        respuesta.setRespuesta(true);

        return respuesta;
    }


    //ELIMINAR SALUDO 
    @PayloadRoot(localPart = "BorrarSaludoRequest",namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public BorrarSaludoResponse borrarSaludo (@RequestPayload BorrarSaludoRequest peticion){
        BorrarSaludoResponse respuesta = new BorrarSaludoResponse();
        
        // for (Saludo o : saludos){
        //     if(o.getId() == peticion.getId()){
        //         saludos.remove(o);
        //         break;
        //     }
        // }
        isaludadores.deleteById(peticion.getId());
        respuesta.setRespuesta(true);
        return respuesta;

    }


}
