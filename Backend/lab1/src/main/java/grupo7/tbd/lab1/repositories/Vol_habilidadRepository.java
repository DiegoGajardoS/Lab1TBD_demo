package grupo7.tbd.lab1.repositories;


import grupo7.tbd.lab1.models.Vol_Habilidad;
import java.util.List;

public interface Vol_habilidadRepository {
    public List<Vol_Habilidad> getAllVol_habilidades();
    public List<Vol_Habilidad> getVol_habilidad(int id);
    public Vol_Habilidad createVol_habilidad(Vol_Habilidad vol_habilidad);
    public void updateVol_habilidad(Vol_Habilidad vol_habilidad, int id);
    public void deleteVol_habilidad(int id); 
}
