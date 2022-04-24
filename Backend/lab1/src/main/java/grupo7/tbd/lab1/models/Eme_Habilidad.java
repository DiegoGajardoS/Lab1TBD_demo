/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7.tbd.lab1.models;

public class Eme_Habilidad{
 private Long id;
 private Long id_emergencia;
 private Long id_habilidad;
 private boolean deleted;


 //***** GETTERS *****//

    public Long getId(){
        return id;
    }

    public Long getIdEmergencia(){
        return id_emergencia;
    }

    public Long getIdHabilidad(){
        return id_habilidad;
    }

    public boolean getDeleted(){
        return deleted;
    }

     //***** SETTERS *****//

    public void setId(Long id){
        this.id = id;
    }

    public void setIdEmergencia(Long id_emergencia){
        this.id_emergencia = id_emergencia;
    }

    public void setIdHabilidad(Long id_habilidad){
        this.id_habilidad= id_habilidad;
    } 

    public void setDeleteEstado(boolean deleted){
        this.deleted = deleted;
    }

}
