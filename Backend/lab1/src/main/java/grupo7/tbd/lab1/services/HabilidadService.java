/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7.tbd.lab1.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import grupo7.tbd.lab1.models.Habilidad;
import grupo7.tbd.lab1.repositories.HabilidadRepository;
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

public class HabilidadService {

    private final HabilidadRepository habilidadRepository;
    private final Gson gson;

    HabilidadService(HabilidadRepository habilidadRepository){
        this.gson = new GsonBuilder().create();
        this.habilidadRepository = habilidadRepository;
    }

    @GetMapping("/habilidades/")
    ResponseEntity<String> getHabilidades(){
        List<Habilidad> habilidades = habilidadRepository.getHabilidades();
        return new ResponseEntity<>(gson.toJson(habilidades),HttpStatus.OK);
    }

    @GetMapping("/habilidades/{id}")
    ResponseEntity<String> getHabilidad(@PathVariable Long id){
        Habilidad habilidad = habilidadRepository.getHabilidad(id);
        if(habilidad != null){
            return new ResponseEntity<>(gson.toJson(habilidad),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/habilidades/create")
    ResponseEntity<String> createHabilidad(@RequestBody String request){
        Habilidad habilidadOut = gson.fromJson(request,Habilidad.class);
        if (habilidadOut != null){  
            habilidadOut = habilidadRepository.createHabilidad(habilidadOut);
            return new ResponseEntity<>(gson.toJson(habilidadOut),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    

    @CrossOrigin(origins = {"http://localhost:8080"})
    @ResponseBody
    @RequestMapping(value ="/habilidades/{id}",  method =RequestMethod.PUT,consumes="application/json")
    ResponseEntity<String> updateHabilidad(@RequestBody String request, @PathVariable Long id){
        Habilidad hab= gson.fromJson(request,Habilidad.class);
        Habilidad habilidadOut = habilidadRepository.getHabilidad(id);
        if(habilidadOut != null){
            if(hab.getNombreH() != null){
                habilidadOut.setNombreH(hab.getNombreH());
            }

            if(hab.getDescripcion() != null){ 
                habilidadOut.setDescripcion(hab.getDescripcion());
            }

            habilidadOut = habilidadRepository.updateHabilidad(habilidadOut, id);
            return new ResponseEntity<>(gson.toJson(habilidadOut),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/habilidades/{id}")
    ResponseEntity<String> deleteHabilidad(@PathVariable Long id){
        if(habilidadRepository.deleteHabilidad(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return ResponseEntity.status(404).body("No se encontro la habilidad objetivo :(\n");
    }


}

