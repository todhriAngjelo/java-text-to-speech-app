package parser;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.XmlException;

import java.io.*;

public class MsDocumentReader implements DocumentReader {


    /**
     * This method parses a word document based on a given filepath.
     *
     * @param filepath the word document absolute filepath to be parsed
     * @return Upon succeeds it returns the document string content. Upon failure this method returns "PARSING_FAILURE" error string
     */
    public String parse(String filepath) {
        FileInputStream fs = getFileInputStream(new File(filepath));

        OPCPackage odcPackage;
        try {
            odcPackage = OPCPackage.open(fs);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
            return "PARSING_FAILURE";
        } catch (IOException e) {
            e.printStackTrace();
            return "PARSING_FAILURE";
        } catch (Exception e) {
            e.printStackTrace();
            return "PARSING_FAILURE";
        }

        XWPFWordExtractor xw = null;
        try {
            xw = new XWPFWordExtractor(odcPackage);
        } catch (XmlException e) {
            e.printStackTrace();
            return "PARSING_FAILURE";
        } catch (OpenXML4JException e) {
            e.printStackTrace();
            return "PARSING_FAILURE";
        } catch (IOException e) {
            e.printStackTrace();
            return "PARSING_FAILURE";
        }

        return xw.getText();

    }

    public boolean saveFile(String filepath, String content) {
        //Blank Document
        XWPFDocument document = new XWPFDocument();

        //Write the Document in file system
        FileOutputStream out;
        try {
            out = new FileOutputStream(filepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }

        //create Paragraph
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText(content);

        try {
            document.write(out);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        System.out.println("docx written successfully");
        return true;
    }

    private FileInputStream getFileInputStream(File file) {
        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}