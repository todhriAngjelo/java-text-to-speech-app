package command.action;

import worker.ReplayWorker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetReplayActionListener implements ActionListener {

    ReplayWorker replayWorker = ReplayWorker.getInstance();

    @Override
    public void actionPerformed(ActionEvent e) {
        replayWorker.reset();
    }
}
