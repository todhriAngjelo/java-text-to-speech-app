package command;

import command.action.*;
import command.change.AlterPitchChangeListener;
import command.change.AlterRateChangeListener;
import command.change.AlterVolumeChangeListener;
import view.View;

import javax.swing.event.ChangeListener;
import java.awt.event.ActionListener;

public class ListenerFactory {

    private static ListenerFactory INSTANCE;

    private ListenerFactory() {

    }

    public static ListenerFactory getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ListenerFactory();
        }

        return INSTANCE;
    }

    public ActionListener getActionListener(String command, View view) {

        if (command.equals("openFile")) {
            return new OpenFileActionListener(view);
        }

        if (command.equals("saveFile")) {
            return new SaveFileActionListener(view);
        }

        if (command.equals("encodeAtbash")) {
            return new EncodeAtbashActionListener(view);
        }

        if (command.equals("decodeAtbash")) {
            return new DecodeAtbashActionListener(view);
        }

        if (command.equals("encodeRot13")) {
            return new EncodeRot13ActionListener(view);
        }

        if (command.equals("decodeRot13")) {
            return new DecodeRot13ActionListener(view);
        }

        if (command.equals("playText")) {
            return new PlayActionListener(view);
        }

        if (command.equals("replayActions")) {
            return new ReplayActionListener();
        }

        if (command.equals("resetReplayActions")) {
            return new ResetReplayActionListener();
        }

        return null;
	}

    public ChangeListener getChangeListener(String command, View view) {

        if (command.equals("volumeChange")) {
            return new AlterVolumeChangeListener(view);
        }

        if (command.equals("rateChange")) {
            return new AlterRateChangeListener(view);
        }

        if (command.equals("pitchChange")) {
            return new AlterPitchChangeListener(view);
        }

        return null;
    }

}
