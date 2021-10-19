package worker;

import encoding.AbstractEncoder;
import encoding.AtbashEncoder;
import encoding.Rot13Encoder;

public class EncodingWorker {

    public static final String ENCODING_DECODING_FAILURE_MESSAGE = "ENCODING_DECODING_FAILURE";

    private static final AbstractEncoder atbashEncoder = new AtbashEncoder();
    private static final AbstractEncoder rot13Encoder = new Rot13Encoder();

    public static String encode(String input, EncodingDecodingAlgorithm encodingStrategy) {
        if (encodingStrategy.equals(EncodingDecodingAlgorithm.ATBASH)) {
            return atbashEncoder.encode(input);
        }

        if (encodingStrategy.equals(EncodingDecodingAlgorithm.ROT13)) {
            return rot13Encoder.encode(input);
        }

        return ENCODING_DECODING_FAILURE_MESSAGE;
    }

    public static String decode(String input, EncodingDecodingAlgorithm decodingStrategy) {
        if (decodingStrategy.equals(EncodingDecodingAlgorithm.ATBASH)) {
            return atbashEncoder.decode(input);
        }

        if (decodingStrategy.equals(EncodingDecodingAlgorithm.ROT13)) {
            return rot13Encoder.decode(input);
        }

        return ENCODING_DECODING_FAILURE_MESSAGE;
    }

    public enum EncodingDecodingAlgorithm {
        ATBASH,
        ROT13
    }
}
