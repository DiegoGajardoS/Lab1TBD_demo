/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7.tbd.lab1.repositories;

import grupo7.tbd.lab1.models.Estado_Tarea;
import java.util.List;

public interface Estado_TareaRepository{

    public Estado_Tarea createEstado_Tarea(Estado_Tarea estado_tarea);
    public List<Estado_Tarea> getEstado_Tareas();  
    public Estado_Tarea getEstado_Tarea(Long id);
    public Estado_Tarea updateEstado_Tarea(Estado_Tarea estado_tarea, Long id);
    public boolean deleteEstado_Tarea(Long id);
    public Long countEstado_Tarea();
}