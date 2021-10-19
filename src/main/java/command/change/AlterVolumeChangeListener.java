package command.change;

import view.View;
import worker.AudioTransformWorker;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AlterVolumeChangeListener implements ChangeListener {

	private static View view;

	public AlterVolumeChangeListener(View view) {
		AlterVolumeChangeListener.view = view;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		AudioTransformWorker.getTransformer().setVolume(view.getVoiceVolumeSlider().getScaledValue());
	}
}
