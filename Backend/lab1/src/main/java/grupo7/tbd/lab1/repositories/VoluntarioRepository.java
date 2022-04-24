package grupo7.tbd.lab1.repositories;

import grupo7.tbd.lab1.models.Voluntario;
import java.util.List;

public interface VoluntarioRepository {
    public List<Voluntario> getAllVoluntarios();
    public List<Voluntario> getVoluntario(int id);
    public Voluntario createVoluntario(Voluntario voluntario);
    public void updateVoluntario(Voluntario voluntario, int id);
    public void deleteVoluntario(int id);  
}
