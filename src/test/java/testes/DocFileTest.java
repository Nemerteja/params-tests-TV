package testes;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static Utils.Files.readDocFile;
import static Utils.Files.readDocxFile;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class DocFileTest {
    @Test
    public void docTest() throws IOException {
        String docFilePath = "src/test/java/testes/resourses/1.doc";
        String exepectedData = "for tests";

        String actualData = readDocFile(docFilePath);

       assertThat(actualData, containsString(exepectedData));

    }

    @Test
    public void docxTest() throws IOException {
        String docxFilePath = "src/test/java/testes/resourses/2.docx";
        String exepectedData = "for tests";

        String actualData = readDocxFile(docxFilePath);

        assertThat(actualData, containsString(exepectedData));

    }
}
