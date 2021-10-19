package command.action;

import worker.ReplayWorker;

import java.awt.event.ActionListener;

public class ReplayActionListener implements ActionListener {

    ReplayWorker replayWorker = ReplayWorker.getInstance();

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        replayWorker.replay();
    }
}
