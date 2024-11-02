package cl.msoluciones.infraestructure.repository;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import cl.msoluciones.aplication.mapper.EquipoMapper;
import cl.msoluciones.domain.model.EquipoModel;
import cl.msoluciones.domain.ports.out.EquipoRepositoryPort;
import cl.msoluciones.infraestructure.entities.EquipoEntity;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
@Component
public class JpaEquipoRepositoryAdapter implements EquipoRepositoryPort {
    private static final Logger logger = LoggerFactory.getLogger(JpaEquipoRepositoryAdapter.class);
    
    private final EquipoMapper equipoMapper; 
    private final JpaEquipoRepository equipoRepository;

    @Autowired
    public JpaEquipoRepositoryAdapter(JpaEquipoRepository equipoRepository, EquipoMapper equipoMapper) {
        this.equipoRepository = equipoRepository;
        this.equipoMapper = equipoMapper;
    }

    @Override
    public void guardarEquipo(EquipoModel equipo) {
        throw new UnsupportedOperationException("Unimplemented method 'guardarEquipo'");
    }

    @Override
    public void actualizarEquipo(EquipoModel equipo) {
        throw new UnsupportedOperationException("Unimplemented method 'actualizarEquipo'");
    }

    @Override
    public void eliminarEquipo(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'eliminarEquipo'");
    }

    @Override
    public EquipoModel obtenerEquipoPorId(Long id) {
        Optional<EquipoEntity> optionalEquipo = equipoRepository.findById(id);
        return optionalEquipo.map(equipoMapper::toModel).orElse(null);
    }

    @Override
    public List<EquipoModel> buscarEquipos(String criterio) {
        throw new UnsupportedOperationException("Unimplemented method 'buscarEquipos'");
    }

    @Override
    public List<EquipoModel> listarEquipos() {
        try {
            List<EquipoEntity> equipoEntities = equipoRepository.findAll();
            return equipoEntities.stream()
                    .map(equipoMapper::toModel) 
                    .collect(Collectors.toList());
        } catch (DataAccessException e) {
            logger.error("Error al listar equipos", e);
            throw new RuntimeException("Error al listar equipos", e);
        }
    }

    @Override
    public ByteArrayOutputStream generarPdfEquipo(EquipoModel equipo) {
        throw new UnsupportedOperationException("Unimplemented method 'generarPdfEquipo'");
    }

}
