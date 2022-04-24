/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7.tbd.lab1.repositories;

import grupo7.tbd.lab1.models.Habilidad;
import java.util.List;

public interface HabilidadRepository{

    public Habilidad createHabilidad(Habilidad habilidad);
    public List<Habilidad> getHabilidades();  
    public Habilidad getHabilidad(Long id);
    public Habilidad updateHabilidad(Habilidad habilidad, Long id);
    public boolean deleteHabilidad(Long id);
    public Long countHabilidad();
}
