package testes;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static Utils.Files.readTextFromPath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class TxtFileTest {
    @Test
    public void txtTest() throws IOException {
        String txtFilePath = "src/test/java/testes/resourses/1.txt";
        String exepectedData = "Marvin Gaye";

        String actualData = readTextFromPath(txtFilePath);

        assertThat(actualData, containsString(exepectedData));

    }
}
