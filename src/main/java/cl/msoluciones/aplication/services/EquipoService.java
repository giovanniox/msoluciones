package cl.msoluciones.aplication.services;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.itextpdf.text.pdf.PdfPTable;

import cl.msoluciones.aplication.usecases.EquipoUseCaseImpl;
import cl.msoluciones.aplication.usecases.PdfUseCaseImpl;
import cl.msoluciones.domain.model.EquipoModel;
import cl.msoluciones.domain.model.MantenimientoCorrectivoModel;
import cl.msoluciones.domain.model.MantenimientoPreventivoModel;
import cl.msoluciones.domain.ports.in.EquipoUseCase;
import cl.msoluciones.domain.ports.in.PdfUseCase;
import lombok.Data;

@Data
public class EquipoService implements EquipoUseCase {

    private final EquipoUseCaseImpl equipoUseCase;

    @Override
    public void crearEquipo(EquipoModel equipo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearEquipo'");
    }

    @Override
    public void actualizarEquipo(Long id, EquipoModel equipo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarEquipo'");
    }

    @Override
    public void registrarMantenimientoPreventivo(Long equipoId, MantenimientoPreventivoModel mantenimiento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registrarMantenimientoPreventivo'");
    }

    @Override
    public void registrarMantenimientoCorrectivo(Long equipoId, MantenimientoCorrectivoModel mantenimiento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registrarMantenimientoCorrectivo'");
    }

    @Override
    public void eliminarEquipo(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarEquipo'");
    }

    @Override
    public List<EquipoModel> buscarEquipos(String criterio) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarEquipos'");
    }

    @Override
    public List<EquipoModel> listarEquipos() {
        return equipoUseCase.listarEquipos();
    }

    @Override
    public EquipoModel buscarEquipoPorId(Long id) {
        return equipoUseCase.buscarEquipoPorId(id);
    }

}
