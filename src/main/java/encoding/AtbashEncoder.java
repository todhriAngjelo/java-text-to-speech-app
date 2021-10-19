package encoding;

public class AtbashEncoder implements AbstractEncoder {

    @Override
    public String encode(String plaintext) {
        String ciphertext = "";
//        plaintext = removeUnwantedChars(plaintext.toLowerCase());
        for (char c : plaintext.toCharArray()) {
            if (Character.isLetter(c)) {
                if (c >= 'a' && c <= 'z') {
                    ciphertext += (char) ('a' + ('z' - c));

                } else if (c >= 'A' && c <= 'Z') {
                    ciphertext += (char) ('A' + ('Z' - c));

                }
            } else {
                ciphertext += c;
            }
        }
        return ciphertext;
    }

    @Override
    public String decode(String ciphertext) {
        String plaintext = "";
//        ciphertext = removeUnwantedChars(ciphertext.toLowerCase());
        for (char c : ciphertext.toCharArray()) {
            if (Character.isLetter(c)) {
                if (c >= 'a' && c <= 'z') {
                    plaintext += (char) ('z' + ('a' - c));

                } else if (c >= 'A' && c <= 'Z') {
                    plaintext += (char) ('Z' + ('A' - c));
                }
            } else {
                plaintext += c;
            }
        }
        return plaintext;
    }
    // credits to: https://exercism.io/tracks/java/exercises/atbash-cipher/solutions/ce7f9a7a88124b8298c1de831037f051
}
