package parser;

public interface DocumentReader {

    String parse(String filepath);

    boolean saveFile(String filepath, String content);
}