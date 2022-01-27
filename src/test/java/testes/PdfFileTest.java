package testes;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static Utils.Files.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class PdfFileTest {
    @Test
    public void pdfTest() throws IOException {
        String pdfFilePath = "src/test/java/testes/resourses/1.pdf";
        String exepectedData = "Love Letter is played over several game rounds";

        PDF pdf = getPDF(pdfFilePath);
        assertThat(pdf, PDF.containsText(exepectedData));

    }
}
