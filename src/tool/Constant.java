/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;

import java.io.IOException;

/**
 *
 * @author Administrator
 */
public class Constant {

    public static String PATH_MUSIC_OK = "src/media/hitTarget.wav";
    public static String PATH_MUSIC_SHOOT_OK = "src/media/shotOk.wav";
    public static String PATH_MUSIC_SHOOT_FAIL = "src/media/shootFail.wav";
    public static String PATH_MUSIC_MISS = "src/media/missShot.wav";
    public static String PATH_MUSIC_SOUND = "src/media/JayzRunThisTown.mp3";
    public static String PATH_BACKGROUND_MUSIC1 = "src/media/backgroundMusic1.mp3";
    public static String PATH_SINGLE_CHAR_HIT = "src/media/sound/singleCharHit.wav";
    
    
    public static int HEIGHT_JP = 100;
    

    public static void main(String[] args) throws IOException {
        String file = PATH_BACKGROUND_MUSIC1;
        Runtime.getRuntime().exec("cmd /c start " + file.replaceAll(" ", "\" \""));
    }
}
