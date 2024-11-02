package cl.msoluciones.domain.ports.in;

import java.io.IOException;
import java.util.List;

import com.itextpdf.text.DocumentException;


import cl.msoluciones.domain.model.EquipoModel;

public interface PdfUseCase {
    byte[] generarPdfEquipo(EquipoModel obj)  throws Exception;
    byte[] generarPdfEquipos(List<EquipoModel> equipos) throws DocumentException, IOException, Exception;
}
