package command.change;

import view.View;
import worker.AudioTransformWorker;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AlterRateChangeListener implements ChangeListener {

    private static View view;

    public AlterRateChangeListener(View view) {
        AlterRateChangeListener.view = view;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        AudioTransformWorker.getTransformer().setRate(view.getVoiceRateSlider().getValue());
    }
}
