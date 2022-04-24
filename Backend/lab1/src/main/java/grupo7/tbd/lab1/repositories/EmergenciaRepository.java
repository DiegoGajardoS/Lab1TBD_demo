/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7.tbd.lab1.repositories;

import grupo7.tbd.lab1.models.Emergencia;
import grupo7.tbd.lab1.models.Habilidad;
import java.util.List;
public interface EmergenciaRepository{

    public Emergencia createEmergencia(Emergencia emergencia);
    public List<Emergencia> getEmergencias();  
    public Emergencia getEmergencia(Long id);
    public Emergencia updateEmergencia(Emergencia emergencia, Long id);
    public boolean deleteEmergencia(Long id);
    public Long countEmergencia();
    public List <Habilidad> getHabilidadesEmergencia(Long id_em);
}