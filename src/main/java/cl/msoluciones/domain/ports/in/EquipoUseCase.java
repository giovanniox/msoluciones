package cl.msoluciones.domain.ports.in;

import java.util.List;

import cl.msoluciones.domain.model.EquipoModel;
import cl.msoluciones.domain.model.MantenimientoCorrectivoModel;
import cl.msoluciones.domain.model.MantenimientoPreventivoModel;

public interface EquipoUseCase {
    
    void crearEquipo(EquipoModel equipo);
    void actualizarEquipo(Long id, EquipoModel equipo);
    void registrarMantenimientoPreventivo(Long equipoId, MantenimientoPreventivoModel mantenimiento);
    void registrarMantenimientoCorrectivo(Long equipoId, MantenimientoCorrectivoModel mantenimiento);
    void eliminarEquipo(Long id);
    List<EquipoModel> buscarEquipos(String criterio);
    List<EquipoModel> listarEquipos();
    EquipoModel buscarEquipoPorId(Long equipoId);

}
