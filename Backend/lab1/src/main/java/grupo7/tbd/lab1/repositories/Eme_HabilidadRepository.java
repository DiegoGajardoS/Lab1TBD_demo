/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7.tbd.lab1.repositories;

import grupo7.tbd.lab1.models.Eme_Habilidad;
import java.util.List;

public interface Eme_HabilidadRepository{

    public Eme_Habilidad createEme_Habilidad(Eme_Habilidad eme_habilidad);
    public List<Eme_Habilidad> getEme_Habilidades();  
    public Eme_Habilidad getEme_Habilidad(Long id);
    public Eme_Habilidad updateEme_Habilidad(Eme_Habilidad eme_habilidad, Long id);
    public boolean deleteEme_Habilidad(Long id);
    public Long countEme_Habilidad();
}
