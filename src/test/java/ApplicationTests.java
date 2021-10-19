import command.action.*;
import command.change.AlterPitchChangeListener;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.Assert;
import org.junit.Test;
import parser.DocumentReader;
import parser.MsDocumentReader;
import view.TextEditorView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ApplicationTests {

    public static final String TEST_MS_WORD_FILEPATH = "TestWordDocu.docx";
    // DURING THE TESTS JUST PRESS ENTER TO THE WINDOWS OPENED
    DocumentReader msWordParser = new MsDocumentReader();

    @Test
    // there are indicative tests. Ui is manipulated and we test if the contents of the text area are indeed set and if the file saving works as expected
    public void applicationTest() {

        TextEditorView textEditorView = new TextEditorView();
        // we are going to create and save a docx document and try to laod it afterwards
        createEmtpyWord();
        msWordParser.saveFile(TEST_MS_WORD_FILEPATH, "123 test");
        Assert.assertEquals("123 test\n", msWordParser.parse(TEST_MS_WORD_FILEPATH)); // word adds a new extra line by default

        // user needs to select file from resources
        OpenFileActionListener openFileActionListener = new OpenFileActionListener(textEditorView);
        openFileActionListener.actionPerformed(null);

        Assert.assertEquals(textEditorView.getTextArea().getText(), "123 test\n");

        EncodeAtbashActionListener encodeAtbashActionListener = new EncodeAtbashActionListener(textEditorView);
        encodeAtbashActionListener.actionPerformed(null);

        Assert.assertEquals(textEditorView.getTextArea().getText(), "123 gvhg\n");

        // confirm that you listened sound
        PlayActionListener playActionListener = new PlayActionListener(textEditorView);
        playActionListener.actionPerformed(null);

        AlterPitchChangeListener alterPitchChangeListener = new AlterPitchChangeListener(textEditorView);
        alterPitchChangeListener.stateChanged(null);
        textEditorView.getVoicePitchSlider().setValue(50);

        // confirm that pitch was different
        playActionListener.actionPerformed(null);

        // confirm that the same actions until now are performed
        ReplayActionListener replayActionListener = new ReplayActionListener();
        replayActionListener.actionPerformed(null);

        ResetReplayActionListener resetReplayActionListener = new ResetReplayActionListener();
        resetReplayActionListener.actionPerformed(null);
    }

    private void createEmtpyWord() {
        //Blank Document
        XWPFDocument document = new XWPFDocument();

        //Write the Document in file system
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(new File(TEST_MS_WORD_FILEPATH));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            document.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}