package view;

import command.ListenerFactory;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;

public class TextEditorView extends View {


    /**
     * @wbp.parser.entryPoint
     */
    public TextEditorView() {
        initialize();
        this.frame.setVisible(true);

    }

    protected void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 895, 544);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lastUpdatedLabel = new JLabel("Last updated:");
        lastUpdatedLabel.setBounds(10, 451, 72, 14);
        frame.getContentPane().add(lastUpdatedLabel);

        lastUpdatedPlaceholder = new JTextArea("-");
        lastUpdatedPlaceholder.setBackground(UIManager.getColor("Button.background"));
        lastUpdatedPlaceholder.setFont(new Font("Arial", Font.PLAIN, 12));
        lastUpdatedPlaceholder.setBounds(92, 451, 280, 14);
        frame.getContentPane().add(this.lastUpdatedPlaceholder);

        JLabel filepathLabel = new JLabel("File path:");
        filepathLabel.setBounds(10, 476, 72, 14);
        frame.getContentPane().add(filepathLabel);

        filepathPlaceholder = new JTextArea("-"); // init value that is going to be modified
        filepathPlaceholder.setBackground(UIManager.getColor("Button.background"));
        filepathPlaceholder.setFont(new Font("Arial", Font.PLAIN, 12));
        filepathPlaceholder.setBounds(92, 476, 280, 14);
        frame.getContentPane().add(filepathPlaceholder);

        // Buttons
        JButton loadFileButton = new JButton("Load");
        loadFileButton.addActionListener(ListenerFactory.getInstance().getActionListener("openFile", this));
        loadFileButton.setBounds(697, 420, 130, 23);
        frame.getContentPane().add(loadFileButton);

        JButton saveFileButton = new JButton("Save");
        saveFileButton.addActionListener(ListenerFactory.getInstance().getActionListener("saveFile", this));
        saveFileButton.setBounds(697, 454, 130, 23);
        frame.getContentPane().add(saveFileButton);


        JButton backToMainMenuButton = new JButton("Back to main menu");
        backToMainMenuButton.setBounds(697, 386, 130, 23);
        frame.getContentPane().add(backToMainMenuButton);
        backToMainMenuButton.addActionListener(e -> goToMainView());

        // Text to speech buttons
        JLabel textToAudioLabel = new JLabel("Select some text from the text area and click the " +
                "'Listen'");
        textToAudioLabel.setBounds(567, 21, 300, 14);
        frame.getContentPane().add(textToAudioLabel);

        JLabel textToAudioLabel2 = new JLabel("button in order to hear. Default: All text");
        textToAudioLabel2.setBounds(567, 40, 300, 14);
        frame.getContentPane().add(textToAudioLabel2);

        JButton listenButton = new JButton("Listen");
        listenButton.addActionListener(ListenerFactory.getInstance().getActionListener("playText", this));
        listenButton.setBounds(567, 60, 130, 23);
        frame.getContentPane().add(listenButton);

        // encode/decode buttons
        JLabel textEncodeAtbashLabel = new JLabel("Text encoding (Atbash):");
        textEncodeAtbashLabel.setBounds(549, 249, 141, 14);
        frame.getContentPane().add(textEncodeAtbashLabel);

        JButton textEncodeAtbashButton = new JButton("ENCODE");
        textEncodeAtbashButton.addActionListener(ListenerFactory.getInstance().getActionListener("encodeAtbash", this));
        textEncodeAtbashButton.setBounds(549, 273, 130, 23);
        frame.getContentPane().add(textEncodeAtbashButton);

        JButton textDecodeAtbashButton = new JButton("DECODE");
        textDecodeAtbashButton.addActionListener(ListenerFactory.getInstance().getActionListener("decodeAtbash", this));
        textDecodeAtbashButton.setBounds(549, 306, 130, 23);
        frame.getContentPane().add(textDecodeAtbashButton);

        JLabel textEncodeRot13Label = new JLabel("Text encoding(Rot-13):");
        textEncodeRot13Label.setBounds(713, 249, 141, 14);
        frame.getContentPane().add(textEncodeRot13Label);


        JButton textEncodeRot13Button = new JButton("ENCODE");
        textEncodeRot13Button.addActionListener(ListenerFactory.getInstance().getActionListener("encodeRot13", this));
        textEncodeRot13Button.setBounds(713, 273, 130, 23);
        frame.getContentPane().add(textEncodeRot13Button);

        JButton textDecodeRot13Button = new JButton("DECODE");
        textDecodeRot13Button.addActionListener(ListenerFactory.getInstance().getActionListener("decodeRot13", this));
        textDecodeRot13Button.setBounds(713, 306, 130, 23);
        frame.getContentPane().add(textDecodeRot13Button);

        // volume control
        JLabel lblVoiceVolume = new JLabel("Voice volume");
        lblVoiceVolume.setVerticalAlignment(SwingConstants.TOP);
        lblVoiceVolume.setHorizontalAlignment(SwingConstants.LEFT);
        lblVoiceVolume.setForeground(Color.BLACK);
        lblVoiceVolume.setBounds(567, 122, 62, 14);
        frame.getContentPane().add(lblVoiceVolume);

        voiceVolumeSlider.addChangeListener(ListenerFactory.getInstance().getChangeListener("volumeChange", this));
        voiceVolumeSlider.setBounds(678, 122, 170, 14);
        frame.getContentPane().add(voiceVolumeSlider);


        JLabel lblVoicePitch = new JLabel("Voice pitch");
        lblVoicePitch.setVerticalAlignment(SwingConstants.TOP);
        lblVoicePitch.setHorizontalAlignment(SwingConstants.LEFT);
        lblVoicePitch.setForeground(Color.BLACK);
        lblVoicePitch.setBounds(567, 149, 62, 14);
        frame.getContentPane().add(lblVoicePitch);

        voicePitchSlider.addChangeListener(ListenerFactory.getInstance().getChangeListener("pitchChange", this));
        voicePitchSlider.setBounds(678, 149, 170, 14);
        frame.getContentPane().add(voicePitchSlider);

        JLabel lblVoiceRate = new JLabel("Voice rate");
        lblVoiceRate.setVerticalAlignment(SwingConstants.TOP);
        lblVoiceRate.setHorizontalAlignment(SwingConstants.LEFT);
        lblVoiceRate.setForeground(Color.BLACK);
        lblVoiceRate.setBounds(567, 179, 62, 14);
        frame.getContentPane().add(lblVoiceRate);

        voiceRateSlider.addChangeListener(ListenerFactory.getInstance().getChangeListener("rateChange", this));
        voiceRateSlider.setBounds(678, 179, 170, 14);
        frame.getContentPane().add(voiceRateSlider);

        textArea = new JTextArea();
        textArea.setBounds(10, 37, 517, 404);
        frame.getContentPane().add(textArea);

        textArea.setFont(new Font("Arial", Font.PLAIN, 12));

        JButton replayButton = new JButton("Replay");
        replayButton.addActionListener(ListenerFactory.getInstance().getActionListener("replayActions", this));
        replayButton.setBounds(438, 454, 89, 23);
        frame.getContentPane().add(replayButton);

        JButton resetReplayButton = new JButton("Reset replay");
        resetReplayButton.addActionListener(ListenerFactory.getInstance().getActionListener("resetReplayActions", this));
        resetReplayButton.setBounds(530, 454, 100, 23);
        frame.getContentPane().add(resetReplayButton);

    }

    public void updateView(String content, String filename, String lastUpdatedTime) {
        this.textArea.setText(content);
        this.filepathPlaceholder.setText(filename);
        this.lastUpdatedPlaceholder.setText(lastUpdatedTime);
    }

    public JSlider getVoiceRateSlider() {
        return voiceRateSlider;
    }

    public JSlider getVoicePitchSlider() {
        return voicePitchSlider;
    }

    public FloatJSlider getVoiceVolumeSlider() {
        return voiceVolumeSlider;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public int getLineNumber() {
        int caretPos = textArea.getCaretPosition();
        int lineNumber = 0;
        try {
            lineNumber = textArea.getLineOfOffset(caretPos);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        return lineNumber;
    }


//	public ReplayManager getReplayManager() {
//		return replayManager;
//	}
}
