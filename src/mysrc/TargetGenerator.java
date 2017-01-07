/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysrc;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class TargetGenerator extends Thread {

    private JPanel jp;
    private JLabel labelOfShowCount;

    public TargetGenerator(JPanel jp, JLabel labelOfShowCount) {
        this.jp = jp;
        this.labelOfShowCount = labelOfShowCount;
    }

    @Override
    public void run() {
        int i = 0;
        try {
            while (true) {
                sleep(1500);
                Target ct = new Target(jp);
                Thread t = new Thread(ct);
                t.start();
                labelOfShowCount.setFont(new Font("隶书", Font.BOLD, 40));
                labelOfShowCount.setText(String.valueOf(i++));
            }
        } catch (Exception e) {
            e.printStackTrace();;
        }
    }

}
