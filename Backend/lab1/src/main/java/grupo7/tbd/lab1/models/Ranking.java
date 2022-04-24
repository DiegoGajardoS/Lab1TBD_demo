/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7.tbd.lab1.models;

public class Ranking {
    private Integer id;
    private Integer valor;
    private Integer id_tarea;
    private Integer id_voluntario;
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

    //Valor
    //Getter
    public Integer getValor() {
        return valor;
    }
    //Setter
    public void setValor(Integer valor) {
        this.valor = valor;
    }

    //ID_tarea
    //Getter
    public Integer getId_tarea() {
        return id_tarea;
    }
    //Setter
    public void setId_tarea(Integer id_tarea) {
        this.id_tarea = id_tarea;
    }

    //ID_voluntario
    //Getter
    public Integer getId_voluntario() {
        return id_voluntario;
    }
    //Setter
    public void setId_voluntario(Integer id_voluntario) {
        this.id_voluntario = id_voluntario;
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
