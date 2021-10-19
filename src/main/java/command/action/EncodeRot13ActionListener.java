package command.action;

import view.View;
import worker.EncodingWorker;

import java.awt.event.ActionListener;

public class EncodeRot13ActionListener extends MyActionListener implements ActionListener {


    public EncodeRot13ActionListener(View view) {
        super(view);
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        view.getTextArea().setText(
                EncodingWorker.encode(
                        view.getTextArea().getText(),
                        EncodingWorker.EncodingDecodingAlgorithm.ROT13
                )
        );

        doReplayActions(this);
    }
}
