/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7.tbd.lab1.services;

import grupo7.tbd.lab1.repositories.Eme_HabilidadRepository;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import grupo7.tbd.lab1.models.Eme_Habilidad;
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

@CrossOrigin
@RestController
public class Eme_HabilidadService {
    private final Eme_HabilidadRepository eme_habilidadRepository;
    private final Gson gson;

    Eme_HabilidadService(Eme_HabilidadRepository eme_habilidadRepository){
        this.gson = new GsonBuilder().create();
        this.eme_habilidadRepository = eme_habilidadRepository;
    }

    @GetMapping("/eme_habilidades/")
    ResponseEntity<String> getEme_Habilidades(){
        List<Eme_Habilidad> eme_habilidad = eme_habilidadRepository.getEme_Habilidades();
        return new ResponseEntity<>(gson.toJson(eme_habilidad),HttpStatus.OK);
    }

    @GetMapping("/eme_habilidades/{id}")
    ResponseEntity<String> getEme_Habilidades(@PathVariable Long id){
        Eme_Habilidad eme_habilidad = eme_habilidadRepository.getEme_Habilidad(id);
        if(eme_habilidad != null){
            return new ResponseEntity<>(gson.toJson(eme_habilidad),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/eme_habilidades/create")
    ResponseEntity<String> createEme_Habilidad(@RequestBody String request){
        Eme_Habilidad eme_habilidadOut = gson.fromJson(request,Eme_Habilidad.class);
        if (eme_habilidadOut != null){
            eme_habilidadOut = eme_habilidadRepository.createEme_Habilidad(eme_habilidadOut);
            return new ResponseEntity<>(gson.toJson(eme_habilidadOut),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @CrossOrigin(origins = {"http://localhost:8080"})
    @ResponseBody
    @RequestMapping(value ="/eme_habilidades/{id}",  method =RequestMethod.PUT,consumes="application/json")
    ResponseEntity<String> updateEme_Habilidad(@RequestBody String request, @PathVariable Long id){
     Eme_Habilidad funciona=gson.fromJson(request,Eme_Habilidad.class);
     Eme_Habilidad eme_habilidadOut = eme_habilidadRepository.getEme_Habilidad(id);

        if(eme_habilidadOut != null){
            if(funciona.getIdEmergencia() != null){
                eme_habilidadOut.setIdEmergencia(funciona.getIdEmergencia());
            }
            if(funciona.getIdHabilidad() != null){
                eme_habilidadOut.setIdHabilidad(funciona.getIdHabilidad());
            }

            eme_habilidadOut = eme_habilidadRepository.updateEme_Habilidad(eme_habilidadOut, id);
            return new ResponseEntity<>(gson.toJson(eme_habilidadOut),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/eme_habilidades/{id}")
    ResponseEntity<String> deleteEme_Habilidad(@PathVariable Long id){
        if(eme_habilidadRepository.deleteEme_Habilidad(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
