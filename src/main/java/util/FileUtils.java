package util;

import org.apache.commons.io.FilenameUtils;

public class FileUtils {

    // we created a utility class in hope of putting methods here related with file handling that are going to be used more than once
    public static String getFileType(String absolutePath) {
        return FilenameUtils.getExtension(absolutePath);
    }

}