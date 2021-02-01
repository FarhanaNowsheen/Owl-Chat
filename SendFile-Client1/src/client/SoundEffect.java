package client;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.*;


/**
 *
 * @author Hunk501
 */
public enum SoundEffect {
    
    MessageReceive("/audio/stairs.wav", false), //  Ringtone for Chat message receive
    FileSharing("/audio/to-the-point.wav", false); //   Ringtone for income file
    private Clip clip;
    private boolean loop;
    
    SoundEffect(String filename, boolean loop){
        try {
            this.loop = loop;
            URL url = this.getClass().getResource(filename);
            AudioInputStream audioIS = AudioSystem.getAudioInputStream(url);
            
            clip = AudioSystem.getClip();
            clip.open(audioIS);
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            System.out.println("[SoundEffect]" +e.getMessage());
        }
    }
    
    public void play(){
        if(clip.isRunning()){
            clip.stop(); //  Stop Audio
        }
        //  Reset Audio from the beginning
        clip.setFramePosition(0);
        clip.start();
        //  Check if audio play contineously
        if(loop){
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }
    
    public void stop(){
        if(clip.isRunning()){
            clip.stop(); //   Stop Audio
        }
    }
}
