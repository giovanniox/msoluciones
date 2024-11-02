package cl.msoluciones.aplication.usecases;


import java.io.IOException;
import java.util.List;

import com.itextpdf.text.DocumentException;

import cl.msoluciones.domain.model.EquipoModel;
import cl.msoluciones.domain.ports.in.PdfUseCase;

//@RequiredArgsConstructor 
public class PdfUseCaseImpl implements PdfUseCase {

    //private final PdfRepositoryPort pdfRepositoryPort;

    @Override
    public  byte[] generarPdfEquipo(EquipoModel obj) {
        throw new UnsupportedOperationException("Unimplemented method 'generarPdfEquipo'");
    }

    @Override
    public byte[] generarPdfEquipos(List<EquipoModel> equipos) throws DocumentException, IOException {
        throw new UnsupportedOperationException("Unimplemented method 'generarPdfEquipos'");
    }

   
}
