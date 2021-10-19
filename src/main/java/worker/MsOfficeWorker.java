package worker;

import parser.DocumentReader;
import parser.MsDocumentReader;
import parser.XlsDocumentReader;

import java.util.Arrays;
import java.util.List;

import static util.FileUtils.getFileType;

public class MsOfficeWorker {

    private static final DocumentReader xlsParser = new XlsDocumentReader();
    private static final DocumentReader msWordParser = new MsDocumentReader();
    private static final List<String> supportedTypes = Arrays.asList("docx", "xls", "xlsx");
    public static final String MSWORD_EXTENSION = ".docx";
    public static final List<String> MSEXCEL_EXTENSIONS = Arrays.asList(".xls", "xlsx");

    public static String parse(String absolutePath) {
        if (absolutePath.endsWith(MSWORD_EXTENSION)) {
            return msWordParser.parse(absolutePath);
        }

        for (String msexcelExtension : MSEXCEL_EXTENSIONS) {
            if (absolutePath.endsWith(msexcelExtension)) {
                return xlsParser.parse(absolutePath);
            }
        }

        // throw errors
        return null;// fixme
    }

    public static boolean saveFile(String absolutePath, String content) {
        if (absolutePath.endsWith(MSWORD_EXTENSION)) {
            return msWordParser.saveFile(absolutePath, content);
        }

        for (String msexcelExtension : MSEXCEL_EXTENSIONS) {
            if (absolutePath.endsWith(msexcelExtension)) {
                return xlsParser.saveFile(absolutePath, content);
            }
        }

        // throw errors
        return false;
    }

    public static boolean isParsingSupported(String absolutePath) {
        return supportedTypes.contains(getFileType(absolutePath));
    }

    public List<String> getSupportedTypes() {
        return supportedTypes;
    }
}
