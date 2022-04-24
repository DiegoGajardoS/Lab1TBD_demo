/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7.tbd.lab1.models;

public class Tarea_Habilidad {
    private Integer id;
    private Integer id_tarea;
    private Integer id_eme_habilidad;
    private boolean deleted;

    //GETTERS Y SETTERS
    //ID
    //Getter
    public Integer getId() {
        return id;
    }
    //Setter
    public void setId(Integer id) {
        this.id = id;
    }

    //ID_Tarea
    //Getter
    public Integer getId_tarea() {
        return id_tarea;
    }
    //Setter
    public void setId_tarea(Integer id_tarea) {
        this.id_tarea = id_tarea;
    }

    //ID_Eme_Habilidad
    //Getter
    public Integer getId_eme_habilidad() {
        return id_eme_habilidad;
    }
    //Setter
    public void setId_eme_habilidad(Integer id_eme_habilidad) {
        this.id_eme_habilidad = id_eme_habilidad;
    }

    //Deleted
    //Getter
    public boolean getDeleted() {
        return deleted;
    }
    //Setter
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
