/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7.tbd.lab1.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import grupo7.tbd.lab1.models.Emergencia;
import grupo7.tbd.lab1.models.Habilidad;
import grupo7.tbd.lab1.repositories.EmergenciaRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class EmergenciaService {
    
    private final EmergenciaRepository emergenciaRepository;
    private final Gson gson;

    EmergenciaService(EmergenciaRepository emergenciaRepository){
        this.gson = new GsonBuilder().create();
        this.emergenciaRepository = emergenciaRepository;
    }

    @GetMapping("/emergencias/")
    ResponseEntity<String> getEmergencias(){
        List<Emergencia> emergencias = emergenciaRepository.getEmergencias();
        return new ResponseEntity<>(gson.toJson(emergencias),HttpStatus.OK);
    }

    @GetMapping("/emergencias/{id}")
    ResponseEntity<String> getEmergencia(@PathVariable Long id){
        Emergencia emergencias = emergenciaRepository.getEmergencia(id);
        if(emergencias != null){
            return new ResponseEntity<>(gson.toJson(emergencias),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/emergencias/create")
    ResponseEntity<String> createEmergencia(@RequestBody String request){
        Emergencia emergenciasOut = gson.fromJson(request,Emergencia.class);
        if (emergenciasOut != null){
            emergenciasOut = emergenciaRepository.createEmergencia(emergenciasOut);
            return new ResponseEntity<>(gson.toJson(emergenciasOut),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }



    @CrossOrigin(origins = {"http://localhost:8080"})
    @ResponseBody
    @RequestMapping(value ="/emergencias/{id}",  method =RequestMethod.PUT,consumes="application/json")
    ResponseEntity<String> updateEmergencia(@RequestBody String request, @PathVariable Long id){
        Emergencia emer=gson.fromJson(request,Emergencia.class);
        Emergencia emergenciasOut = emergenciaRepository.getEmergencia(id);

        if(emergenciasOut != null){
            if(emer.getTitulo() != null){
                emergenciasOut.setTitulo(emer.getTitulo());
            }
            if(emer.getDireccion() != null){
                emergenciasOut.setDireccion(emer.getDireccion());
            }
            if(emer.getDescripcion() != null){
                emergenciasOut.setDescripcion(emer.getDescripcion());
            }
            if(emer.getInstitucionId() != null){
                emergenciasOut.setInstitucionId(emer.getInstitucionId());
            }
            if(emer.getActivo() != null){
                emergenciasOut.setActivo(emer.getActivo());
            }

            emergenciasOut = emergenciaRepository.updateEmergencia(emergenciasOut, id);
            return new ResponseEntity<>(gson.toJson(emergenciasOut),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/emergencias/{id}")
    ResponseEntity<String> deleteEmergencia(@PathVariable Long id){
        if(emergenciaRepository.deleteEmergencia(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @GetMapping("/habilidadesEmergencia/{id_em}")
    ResponseEntity<String> getHabilidadesEmergencia(@PathVariable Long id_em){
        List<Habilidad> habilidades = emergenciaRepository.getHabilidadesEmergencia(id_em);
        return new ResponseEntity<>(gson.toJson(habilidades),HttpStatus.OK);
    }
    

}

