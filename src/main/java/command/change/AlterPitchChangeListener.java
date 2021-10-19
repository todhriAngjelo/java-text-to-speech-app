package command.change;

import view.View;
import worker.AudioTransformWorker;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AlterPitchChangeListener implements ChangeListener {

    private static View view;

    public AlterPitchChangeListener(View view) {
        AlterPitchChangeListener.view = view;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        AudioTransformWorker.getTransformer().setPitch(view.getVoicePitchSlider().getValue());
    }

}
