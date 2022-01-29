package testes;

import net.lingala.zip4j.exception.ZipException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static Utils.Files.readTextFromPath;
import static Utils.Zip.unZip;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class ZipFileTest {

    @Test
    public void zipTest() throws IOException, ZipException {
        String zipFilePath = "src/test/java/testes/resourses/1.zip";
        String unzipFolderPath = "src/test/java/testes/resourses/unzip";
        String unzipTxtFilePath = "src/test/java/testes/resourses/unzip/1.txt";
        String zipPassword = "";

        String exepectedData = "Marvin Gaye";

        unZip(zipFilePath, unzipFolderPath, zipPassword);

        String actualData = readTextFromPath(unzipTxtFilePath);

        assertThat(actualData, containsString(exepectedData));

    }
}
