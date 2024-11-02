package cl.msoluciones.domain.ports.out;


import java.io.ByteArrayOutputStream;
import java.util.List;

public interface PdfRepositoryPort {
    void savePdf(String fileName, ByteArrayOutputStream pdfToSave);
    ByteArrayOutputStream getPdf(String fileName);
    void deletePdf(String fileName);
    List<String> listAllPdfs();
    boolean pdfExists(String fileName);
}
