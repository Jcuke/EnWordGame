package mysrc.player;

import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import tool.Constant;

public class RecordSound {

    /**
     * @param args
     */
    public static void main(String[] args) {

        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File(Constant.PATH_MUSIC_OK));// 获得音频输入流
            AudioFormat baseFormat = ais.getFormat();// 指定声音流中特定数据安排
            System.out.println("baseFormat=" + baseFormat);
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, baseFormat);
            System.out.println("info=" + info);
            SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
            line.open(baseFormat);// 打开具有指定格式的行，这样可使
            // 从混频器获得源数据行
            System.out.println("line=" + line);
            line.open(baseFormat);// 打开具有指定格式的行，这样可使行获得所有所需的系统资源并变得可操作。
            line.start();// 允许数据行执行数据 I/O 
            int BUFFER_SIZE = 4000 * 4;
            int intBytes = 0;
            byte[] audioData = new byte[BUFFER_SIZE];
            while (intBytes != -1) {
                intBytes = ais.read(audioData, 0, BUFFER_SIZE);// 从音频流读取指定的最大数量的数据字节，并将其放入给定的字节数组中。
                if (intBytes >= 0) {
                    int outBytes = line.write(audioData, 0, intBytes);// 通过此源数据行将音频数据写入混频器。
                }
            }

        } catch (Exception e) {
            e.printStackTrace();;
        }
    }
    
    public static void playOkSound(int flag) {

        try {
            String soundFilePath = "";
            if(flag>0){
                soundFilePath = Constant.PATH_MUSIC_SHOOT_OK;
            }else{
                soundFilePath = Constant.PATH_MUSIC_SHOOT_FAIL;
            }
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File(soundFilePath));// 获得音频输入流
            AudioFormat baseFormat = ais.getFormat();// 指定声音流中特定数据安排
            System.out.println("baseFormat=" + baseFormat);
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, baseFormat);
            System.out.println("info=" + info);
            SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
            line.open(baseFormat);// 打开具有指定格式的行，这样可使
            // 从混频器获得源数据行
            System.out.println("line=" + line);
            line.open(baseFormat);// 打开具有指定格式的行，这样可使行获得所有所需的系统资源并变得可操作。
            line.start();// 允许数据行执行数据 I/O 
            int BUFFER_SIZE = 4000 * 4;
            int intBytes = 0;
            byte[] audioData = new byte[BUFFER_SIZE];
            while (intBytes != -1) {
                intBytes = ais.read(audioData, 0, BUFFER_SIZE);// 从音频流读取指定的最大数量的数据字节，并将其放入给定的字节数组中。
                if (intBytes >= 0) {
                    int outBytes = line.write(audioData, 0, intBytes);// 通过此源数据行将音频数据写入混频器。
                }
            }

        } catch (Exception e) {
            e.printStackTrace();;
        }
    }
}
