import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Main {

    private static int soud=0;
    private static int levelSelector=0;
    private static int speed=75;

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        new HomePage(soud,levelSelector,speed);
    }
}
