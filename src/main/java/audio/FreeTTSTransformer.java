package audio;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import static java.lang.System.setProperty;

public class FreeTTSTransformer implements TTSFacade {

    static Voice voice;
    VoiceManager vm = VoiceManager.getInstance();

    public FreeTTSTransformer() {
        setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        this.voice = vm.getVoice("kevin");
        voice.allocate();
    }

    public void play(String text) {
        this.voice.speak(text);
    }

    public void setVolume(float volume) {
        this.voice.setVolume(volume);
    }

    public void setPitch(int pitch) {
        this.voice.setPitch(pitch);
    }

    public void setRate(int rate) {
        this.voice.setRate(rate);
    }
}