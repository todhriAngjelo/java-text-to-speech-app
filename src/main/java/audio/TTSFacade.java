package audio;

public interface TTSFacade {

    void play(String pl);
    void setVolume(float volume);
    void setPitch(int pitch);
    void setRate(int rate);

}
