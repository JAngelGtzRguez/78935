package mx.uv.t4js.Saludos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


import https.t4is_uv_mx.saludos.SaludarRequest;
import https.t4is_uv_mx.saludos.SaludarResponse;
import https.t4is_uv_mx.saludos.BuscarSaludosResponse;
import https.t4is_uv_mx.saludos.ModificarSaludoResponse;
import https.t4is_uv_mx.saludos.ModificarSaludoRequest;
import https.t4is_uv_mx.saludos.BorrarSaludoResponse;
import https.t4is_uv_mx.saludos.BorrarSaludoRequest;


@Endpoint
public class SaludosEndPoint{
    int contadorId = 1;
    List<Saludo> saludos = new ArrayList<>();
    
    //SALUDAR
    @PayloadRoot(localPart = "SaludarRequest",namespace = "https://t4is.uv.mx/saludos")
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
    }



    //BUSCAR SALUDO 
    @PayloadRoot(localPart = "BuscarSaludosRequest",namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public BuscarSaludosResponse buscarSaludos(){
        BuscarSaludosResponse respuesta = new BuscarSaludosResponse();

       
        for (Saludo saludo : saludos) {
            BuscarSaludosResponse.Saludos saludosBusc = new BuscarSaludosResponse.Saludos();
            saludosBusc.setId(saludo.getId());
            saludosBusc.setNombre(saludo.getNombre());
            respuesta.getSaludos().add(saludosBusc);
        }

        return respuesta;

    }

    //MODIFICAR SALUDO
    @PayloadRoot(localPart = "ModificarSaludoRequest",namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public ModificarSaludoResponse modificarSaludo(@RequestPayload ModificarSaludoRequest peticion){
        ModificarSaludoResponse respuesta = new ModificarSaludoResponse();
        Saludo e = new Saludo();
        e.setId(peticion.getId());
        e.setNombre(peticion.getNombre());
        saludos.set(peticion.getId()-1, e);
        respuesta.setRespuesta(true);
        return respuesta;
    }


    //ELIMINAR SALUDO 
    @PayloadRoot(localPart = "BorrarSaludoRequest",namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public BorrarSaludoResponse borrarSaludo (@RequestPayload BorrarSaludoRequest peticion){
        BorrarSaludoResponse respuesta = new BorrarSaludoResponse();
        
        for (Saludo o : saludos){
            if(o.getId() == peticion.getId()){
                saludos.remove(o);
                break;
            }
        }
        respuesta.setRespuesta(true);
        return respuesta;

    }


}
