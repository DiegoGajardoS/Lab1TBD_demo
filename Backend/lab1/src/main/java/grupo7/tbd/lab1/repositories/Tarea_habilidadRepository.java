package grupo7.tbd.lab1.repositories;

import grupo7.tbd.lab1.models.Tarea_Habilidad;
import java.util.List;

public interface Tarea_habilidadRepository {
    public List<Tarea_Habilidad> getAllTarea_habilidades();
    public List<Tarea_Habilidad> getTarea_habilidad(int id);
    public Tarea_Habilidad createTarea_habilidad(Tarea_Habilidad tarea_habilidad);
    public void updateTarea_habilidad(Tarea_Habilidad tarea_habilidad, int id);
    public void deleteTarea_habilidad(int id);
}
