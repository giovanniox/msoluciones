package cl.msoluciones.domain.ports.out;

import cl.msoluciones.domain.model.EquipoModel;
import java.io.ByteArrayOutputStream;
import java.util.List;

public interface EquipoRepositoryPort {
    
    // Guardar un nuevo equipo
    void guardarEquipo(EquipoModel equipo);

    // Actualizar un equipo existente
    void actualizarEquipo(EquipoModel equipo);

    // Eliminar un equipo
    void eliminarEquipo(Long id);

    // Obtener un equipo por ID
    EquipoModel obtenerEquipoPorId(Long id);

    // Buscar equipos según un criterio
    List<EquipoModel> buscarEquipos(String criterio);

    // Listar todos los equipos
    List<EquipoModel> listarEquipos();

    // Generar PDF de un equipo
    ByteArrayOutputStream generarPdfEquipo(EquipoModel equipo);
}
