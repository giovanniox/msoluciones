package cl.msoluciones.aplication.usecases;

import java.util.List;

import cl.msoluciones.domain.model.EquipoModel;
import cl.msoluciones.domain.model.MantenimientoCorrectivoModel;
import cl.msoluciones.domain.model.MantenimientoPreventivoModel;
import cl.msoluciones.domain.ports.in.EquipoUseCase;
import cl.msoluciones.domain.ports.out.EquipoRepositoryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EquipoUseCaseImpl implements EquipoUseCase {

    private final EquipoRepositoryPort equipoRepositoryPort;

    @Override
    public void crearEquipo(EquipoModel equipo) {
        throw new UnsupportedOperationException("Unimplemented method 'crearEquipo'");
    }

    @Override
    public void actualizarEquipo(Long id, EquipoModel equipo) {
        throw new UnsupportedOperationException("Unimplemented method 'actualizarEquipo'");
    }

    @Override
    public void registrarMantenimientoPreventivo(Long equipoId, MantenimientoPreventivoModel mantenimiento) {
        throw new UnsupportedOperationException("Unimplemented method 'registrarMantenimientoPreventivo'");
    }

    @Override
    public void registrarMantenimientoCorrectivo(Long equipoId, MantenimientoCorrectivoModel mantenimiento) {
        throw new UnsupportedOperationException("Unimplemented method 'registrarMantenimientoCorrectivo'");
    }

    @Override
    public void eliminarEquipo(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'eliminarEquipo'");
    }

    @Override
    public List<EquipoModel> buscarEquipos(String criterio) {
        throw new UnsupportedOperationException("Unimplemented method 'buscarEquipos'");
    }

    @Override
    public List<EquipoModel> listarEquipos() {
        return equipoRepositoryPort.listarEquipos();
    }

    @Override
    public EquipoModel buscarEquipoPorId(Long id) {
        return equipoRepositoryPort.obtenerEquipoPorId(id);
    }

}
