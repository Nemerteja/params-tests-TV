package testes;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static Utils.Files.getXLS;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class XlsFileTest {
    @Test
    public void xlsSimpleTest() throws IOException {
        String xlsFilePath = "src/test/java/testes/resourses/1.xls";
        String exepectedData = "some text";

        XLS sprxls = getXLS(xlsFilePath);
        assertThat(sprxls, XLS.containsText(exepectedData));}

    @Test
    public void xlsCellTest() throws IOException {
        String xlsFilePath = "src/test/java/testes/resourses/1.xls";
        String exepectedData = "some text";

        XLS sprxls = getXLS(xlsFilePath);
        String actData = sprxls.excel.getSheetAt(0).getRow(0).getCell(0).toString();
        assertThat(actData, containsString(exepectedData));

    }

    }


