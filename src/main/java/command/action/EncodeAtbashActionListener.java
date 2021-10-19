package command.action;

import view.View;
import worker.EncodingWorker;

import java.awt.event.ActionListener;

public class EncodeAtbashActionListener extends MyActionListener implements ActionListener {

    public EncodeAtbashActionListener(View view) {
        super(view);
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        view.getTextArea().setText(
                EncodingWorker.encode(
                        view.getTextArea().getText(),
                        EncodingWorker.EncodingDecodingAlgorithm.ATBASH
                )
        );

        doReplayActions(this);
    }
}
