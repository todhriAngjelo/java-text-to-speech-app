package worker;

import audio.TTSFacade;
import audio.FreeTTSTransformer;

public class AudioTransformWorker {

    private static final FreeTTSTransformer freeTTSTransformer = new FreeTTSTransformer();

    // in the future this could be done parametrical or over app configuration
    public static TTSFacade getTransformer() {
        return freeTTSTransformer;
    }
}
