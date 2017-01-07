/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysrc.player;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Administrator
 */
public class VedioPlay {

    private AudioFormat format;
    private byte[] samples;

    public static void main(String args[]) {
        System.out.print(System.getProperty("user.dir"));
        String pathPre = System.getProperty("user.dir");
        try {
            URL cb;
            File f = new File(pathPre + "/src/doorRing.wav");
            cb = f.toURL();
            AudioClip aau;
            aau = Applet.newAudioClip(cb);
            //while(true)
//            aau.play();
            aau.play();
            aau.loop();
            aau.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playVedio(String fileName) {
        try {
            AudioInputStream stream = AudioSystem.getAudioInputStream(new File(fileName));
            format = stream.getFormat();
            samples = getSamples(stream);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private byte[] getSamples(AudioInputStream audioStream) {
        // get the number of bytes to read
        int length = (int) (audioStream.getFrameLength() * format.getFrameSize());
        // read the entire stream
        byte[] samples = new byte[length];
        DataInputStream is = new DataInputStream(audioStream);
        try {
            is.readFully(samples);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        // return the samples
        return samples;
    }

    public AudioFormat getFormat() {
        return format;
    }

    public byte[] getSamples() {
        return samples;
    }

    public void setFormat(AudioFormat format) {
        this.format = format;
    }

    public void setSamples(byte[] samples) {
        this.samples = samples;
    }

}
