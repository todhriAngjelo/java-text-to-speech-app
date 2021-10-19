package command.action;

import view.View;
import worker.EncodingWorker;

import java.awt.event.ActionListener;

public class DecodeAtbashActionListener extends MyActionListener implements ActionListener {


    public DecodeAtbashActionListener(View view) {
        super(view);
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        view.getTextArea().setText(
                EncodingWorker.decode(
                        view.getTextArea().getText(),
                        EncodingWorker.EncodingDecodingAlgorithm.ATBASH
                )
        );

        doReplayActions(this);
    }
}
