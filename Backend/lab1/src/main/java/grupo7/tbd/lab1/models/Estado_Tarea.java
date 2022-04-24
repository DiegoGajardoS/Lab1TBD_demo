/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7.tbd.lab1.models;

public class Estado_Tarea{

    private Long id;
    private String estado;
    private boolean deleted;


    //***** GETTERS *****/

    public Long getId(){
        return id;
    }

    public String getEstado(){
        return estado;
    }

    public boolean getDelete(){
        return deleted;
    }

    //***** SETTERS *****//

    public void setId(Long id){
        this.id = id;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }

    public void setDelete(boolean deleted){
        this.deleted = deleted;
    }
}