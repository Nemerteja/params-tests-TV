package Utils;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


import org.apache.hc.core5.util.TextUtils;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;


public class Files {
    public static String readTextFromFile(File file) throws IOException {
        return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
    }

    public static String readTextFromPath(String path) throws IOException {

        return readTextFromFile(getFile(path));
    }

    public static File getFile(String path) {

        return new File(path);
    }

    public static PDF getPDF(String path) throws IOException {

        return new PDF(getFile(path));
    }

    public static XLS getXLS(String path) throws IOException {

        return new XLS(getFile(path));
    }

    public static String readXlsxFromPath(String path) {
        String result = "";
        XSSFWorkbook myExcelBook = null;
        try {
            myExcelBook = new XSSFWorkbook(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        XSSFSheet myExcelSheet = myExcelBook.getSheetAt(0);
        Iterator<Row> rows = myExcelSheet.iterator();
        while (rows.hasNext()) {
            org.apache.poi.ss.usermodel.Row row = rows.next();
            Iterator<Cell> cells = row.iterator();
            while (cells.hasNext()) {
                org.apache.poi.ss.usermodel.Cell cell = cells.next();
                CellType cellType = cell.getCellType();
                switch (cellType) {
                    default:
                        result += cell.toString();
                        break;
                }
            }
        }
        try {
            myExcelBook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    // Reading data from ".doc" file.
    public static String readDocFile(String filePath) throws IOException
    {
        File file=new File(filePath);

        FileInputStream fis =new FileInputStream(file);
        HWPFDocument doc=new HWPFDocument(fis);

        WordExtractor extractor=new WordExtractor(doc);
        // Getting all the paragraphs from the document and adding the same in String array.
        String[] getDocParagraphs= extractor.getParagraphText();
        String str = String.join(",", getDocParagraphs);


        extractor.close();
        return str;
    }

    // Reading data from ".docx" file.
    public static String readDocxFile(String filePath) throws IOException
    {
        File file=new File(filePath);

        FileInputStream fis =new FileInputStream(file);
        XWPFDocument docx =new XWPFDocument(fis);
        List<XWPFParagraph> getDocxParagraphs= docx.getParagraphs();




        String str = String.join(",", getDocxParagraphs);



        docx.close();
        return str;
    }
}



