package command.action;

import worker.MsOfficeWorker;
import util.FileUtils;
import view.TextEditorView;
import view.View;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;

public class OpenFileActionListener extends MyActionListener implements ActionListener {

    public OpenFileActionListener(View view) {
        super(view);
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        JFileChooser dialog = new JFileChooser();
        dialog.setDialogTitle("Select file to open:");

        if (dialog.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            if (!MsOfficeWorker.isParsingSupported(dialog.getSelectedFile().getAbsolutePath())) {
                view.showMessageDialog("File type not supported. Please contact support or load one of the supported file types(docx, xls)");
            } else {
                String content = MsOfficeWorker.parse(dialog.getSelectedFile().getAbsolutePath());

                if (content.equals("PARSING_FAILURE")) {
                    view.showMessageDialog("Parsing failure. Please load another file.");
                    return;
                }

                ((TextEditorView) view).updateView(
                        content,
                        dialog.getSelectedFile().getAbsolutePath(),
                        getFileLastModifiedTime(dialog.getSelectedFile().getAbsolutePath())
                );
            }
        }

        doReplayActions(this);
    }

    private String getFileLastModifiedTime(String filepath) {
        BasicFileAttributes basicFileAttributes;
        try {
            basicFileAttributes = Files.readAttributes(Paths.get(filepath), BasicFileAttributes.class);
            return new Date(basicFileAttributes.lastModifiedTime().toMillis()).toString();
        } catch (IOException e) {
            System.out.println("Error while parsing file");
            e.printStackTrace();
        }

        return null;
    }
}
