package command.action;

import view.View;
import worker.MsOfficeWorker;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import static util.FileUtils.getFileType;

public class SaveFileActionListener extends MyActionListener implements ActionListener {


    public SaveFileActionListener(View view) {
        super(view);
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (view.getTextArea().getText().isEmpty() && view.getFilepathPlaceholder().getText().equals("-")) {
            view.showMessageDialog("Please open a file first before performing a SAVE operation.");
            view.goToMainView();
            return;
        }

        view.showMessageDialog("The file is going to be saved as displayed in the text area " +
                "in \"" + getFileType(view.getFilepathPlaceholder().getText()) + "\" format.");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(view.getFilepathPlaceholder().getText()));
        fileChooser.setSelectedFile(new File(view.getFilepathPlaceholder().getText()));

        fileChooser.setDialogTitle("Save as:");
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            try {
                view.getTextArea().write(new OutputStreamWriter(new FileOutputStream(file),
                        "utf-8"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            if (!MsOfficeWorker.isParsingSupported(view.getFilepathPlaceholder().getText())) {
                view.showMessageDialog("Try to open a file from the supported files list first.");
            }

            if (!MsOfficeWorker.saveFile(
                    view.getFilepathPlaceholder().getText(),
                    view.getTextArea().getText())) {
                view.showMessageDialog("Something went wrong while saving the file. Selected file may have been corrupted.");
                return;
            }

        }

        doReplayActions(this);
    }
}