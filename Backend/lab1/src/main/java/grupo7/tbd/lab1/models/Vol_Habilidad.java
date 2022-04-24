/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7.tbd.lab1.models;

public class Vol_Habilidad {
    private Integer id;
    private Integer id_voluntario;
    private Integer id_habilidad;
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

    //ID_Voluntario
    //Getter
    public Integer getId_voluntario() {
        return id_voluntario;
    }
    //Setter
    public void setId_voluntario(Integer id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    //ID_Habilidad
    //Getter
    public Integer getId_habilidad() {
        return id_habilidad;
    }
    //Setter
    public void setId_habilidad(Integer id_habilidad) {
        this.id_habilidad = id_habilidad;
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
