package command.action;

import view.View;
import worker.EncodingWorker;

import java.awt.event.ActionListener;

public class DecodeRot13ActionListener extends MyActionListener implements ActionListener {


    public DecodeRot13ActionListener(View view) {
        super(view);
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        view.getTextArea().setText(
                EncodingWorker.decode(
                        view.getTextArea().getText(),
                        EncodingWorker.EncodingDecodingAlgorithm.ROT13
                )
        );

        doReplayActions(this);
    }
}
