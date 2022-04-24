package grupo7.tbd.lab1.repositories;

import grupo7.tbd.lab1.models.Tarea;
import java.util.List;


public interface TareaRepository {
    public List<Tarea> getAllTareas();
    public List<Tarea> getTarea(int id);
    public Tarea createTarea(Tarea tarea);
    public void updateTarea(Tarea tarea, int id);
    public void deleteTarea(int id); 
}
