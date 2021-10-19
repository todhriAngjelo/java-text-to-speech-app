package command.action;

import view.View;
import worker.ReplayWorker;

import java.awt.event.ActionListener;

public abstract class MyActionListener {

    protected static View view;
    protected ReplayWorker replayWorker = ReplayWorker.getInstance();

    public MyActionListener(View view) {
        MyActionListener.view = view;
    }

    void doReplayActions(ActionListener actionListener) {
        replayWorker.add(actionListener);
    }
}