/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7.tbd.lab1.models;

public class Voluntario {
    private Integer id;
    private String nombre;
    private boolean disponibilidad;
    private String telefono;
    private String direccion;
    private String correo_electronico;
    private String rut;
    private String ubicacion;
    private boolean deleted;

    //GETTERS Y SETTERS
    //ID
    //GETTER
    public Integer getId() {
        return id;
    }
    //SETTER
    public void setId(Integer id) {
        this.id = id;
    }

    //Nombre
    //GETTER
    public String getNombre() {
        return nombre;
    }
    //SETTER
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Disponibilidad
    //GETTER
    public boolean getDisponibilidad() {
        return disponibilidad;
    }
    //SETTER
    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    //Telefono
    //GETTER
    public String getTelefono() {
        return telefono;
    }
    //SETTER
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    //Direccion
    //GETTER
    public String getDireccion() {
        return direccion;
    }
    //SETTER
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    //Correo_eletronico
    //GETTER
    public String getCorreo_electronico() {
        return correo_electronico;
    }
    //SETTER
    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    //Rut
    //GETTER
    public String getRut() {
        return rut;
    }
    //SETTER
    public void setRut(String rut) {
        this.rut = rut;
    }

    //Ubicacion
    //GETTER
    public String getUbicacion() {
        return ubicacion;
    }
    //SETTER
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    //Deleted
    //GETTER
    public boolean getDeleted() {
        return deleted;
    }
    //SETTER
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
