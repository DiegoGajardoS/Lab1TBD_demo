/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7.tbd.lab1.models;

public class Tarea {
    private Integer id;
    private String titulo;
    private String descripcion;
    private Integer cant_voluntarios;
    private Integer id_estado;
    private Integer id_emergencia;
    private boolean deleted;

    //GETTERS Y SETERS
    //ID
    //Getter
    public Integer getId() {
        return id;
    }
    //Setter
    public void setId(Integer id) {
        this.id = id;
    }

    //Título
    //Getter
    public String getTitulo() {
        return titulo;
    }
    //Setter
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    //Descripción
    //Getter
    public String getDescripcion() {
        return descripcion;
    }
    //Setter
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //Cant_voluntarios
    //Getter
    public Integer getCant_voluntarios() {
        return cant_voluntarios;
    }
    //Setter
    public void setCant_voluntarios(Integer cant_voluntarios) {
        this.cant_voluntarios = cant_voluntarios;
    }

    //ID_estado
    //Getter
    public Integer getId_estado() {
        return id_estado;
    }
    //Setter
    public void setId_estado(Integer id_estado) {
        this.id_estado = id_estado;
    }

    //ID_emergencia
    //Getter
    public Integer getId_emergencia() {
        return id_emergencia;
    }
    //Setter
    public void setId_emergencia(Integer id_emergencia) {
        this.id_emergencia = id_emergencia;
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
