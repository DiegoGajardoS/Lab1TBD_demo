/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7.tbd.lab1.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import grupo7.tbd.lab1.models.Estado_Tarea;
import grupo7.tbd.lab1.repositories.Estado_TareaRepository;
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
public class Estado_TareaService {
    
    private final Estado_TareaRepository estado_tareaRepository;
    private final Gson gson;

    Estado_TareaService(Estado_TareaRepository estado_tareaRepository){
        this.gson = new GsonBuilder().create();
        this.estado_tareaRepository = estado_tareaRepository;
    }

    @GetMapping("/estado_tareas/")
    ResponseEntity<String> getEstado_Tareas(){
        List<Estado_Tarea> estado_tareaOut = estado_tareaRepository.getEstado_Tareas();
        return new ResponseEntity<>(gson.toJson(estado_tareaOut),HttpStatus.OK);
    }

    @GetMapping("/estado_tareas/{id}")
    ResponseEntity<String> getEstado_Tarea(@PathVariable Long id){
        Estado_Tarea estado_tarea = estado_tareaRepository.getEstado_Tarea(id);
        if(estado_tarea != null){
            return new ResponseEntity<>(gson.toJson(estado_tarea),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/estado_tareas/create")
    ResponseEntity<String> createEstado_Tarea(@RequestBody String request){
        Estado_Tarea Estado_TareaOut = gson.fromJson(request,Estado_Tarea.class);
        if (Estado_TareaOut != null){
            Estado_TareaOut = estado_tareaRepository.createEstado_Tarea(Estado_TareaOut);
            return new ResponseEntity<>(gson.toJson(Estado_TareaOut),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    
    @CrossOrigin(origins = {"http://localhost:8080"})
    @ResponseBody
    @RequestMapping(value ="/estado_tareas/{id}",  method =RequestMethod.PUT,consumes="application/json")
    ResponseEntity<String> updateEstado_Tarea(@RequestBody String request, @PathVariable Long id){
        Estado_Tarea etar = gson.fromJson(request,Estado_Tarea.class);
        Estado_Tarea Estado_TareaOut = estado_tareaRepository.getEstado_Tarea(id);
        if(Estado_TareaOut != null){  

            Estado_TareaOut.setEstado(etar.getEstado());
            Estado_TareaOut = estado_tareaRepository.updateEstado_Tarea(Estado_TareaOut, id);
            return new ResponseEntity<>(gson.toJson(Estado_TareaOut),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/estado_tareas/{id}")
    ResponseEntity<String> deleteEstado_Tarea(@PathVariable Long id){
        if(estado_tareaRepository.deleteEstado_Tarea(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
