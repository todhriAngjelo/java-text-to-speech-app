package view;

import javax.swing.*;

public class View {

    protected JFrame frame;
    protected JTextArea lastUpdatedPlaceholder;
    protected JTextArea filepathPlaceholder;
    protected JTextArea textArea;

    protected JSlider voiceRateSlider = new JSlider(0, 400);
    protected JSlider voicePitchSlider = new JSlider(50, 200);
    protected FloatJSlider voiceVolumeSlider = new FloatJSlider(3, 10, 10, 10);

    void initialize() {
        frame = new JFrame();
        frame.setBounds(400, 400, 446, 330);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
    }

    public void showMessageDialog(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public JTextArea getFilepathPlaceholder() {
        return filepathPlaceholder;
    }

    public String getSelectedText() {
        return textArea.getSelectedText();
    }

    public JTextArea getLastUpdatedPlaceholder() {
        return lastUpdatedPlaceholder;
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

    public void goToMainView() {
        new MainView();
        frame.setVisible(false);
    }

    public class FloatJSlider extends JSlider {
        final int scale;

        public FloatJSlider(int min, int max, int value, int scale) {
            super(min, max, value);
            this.scale = scale;
        }

        public float getScaledValue() {
            return ((float) super.getValue()) / this.scale;
        }
    }

}