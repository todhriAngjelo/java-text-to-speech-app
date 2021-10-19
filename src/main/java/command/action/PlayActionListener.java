package command.action;

import view.View;
import worker.AudioTransformWorker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayActionListener extends MyActionListener implements ActionListener {

    public PlayActionListener(View view) {
        super(view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (view.getSelectedText()!= null && !view.getSelectedText().isEmpty()) {
            AudioTransformWorker.getTransformer().play(view.getSelectedText());
            return;
        }

        AudioTransformWorker.getTransformer().play(view.getTextArea().getText());

        doReplayActions(this);
    }
}
