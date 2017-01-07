/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysrc;

import java.awt.Color;
import tool.PanelWithPic;
import tool.Constant;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import tool.WordStringGenerator;

/**
 *
 * @author Administrator
 */
public class Target extends PanelWithPic implements Runnable {

    private int f = 2;//图标等，设置大小的系数
    private JPanel jp;
    private Random rd = new Random();
    public JLabel lab;//这个lab不能用static，下面的getLab()方法会导致lab永不为空，GameJframe也永不为空，最新的单词总会得到锁定
    private Integer x = 0, y = 0;
    private int move = 1;
    private Font font = new Font("隶书", Font.LAYOUT_NO_LIMIT_CONTEXT, 14 + rd.nextInt(1));
    Image im;

    @Override
    protected void paintComponent(Graphics g) {
        // 清屏
        super.paintComponent(g);
        //g.drawImage(im, 0, 0, this.getWidth()-5, this.getHeight()-5, this);
        g.drawImage(im, (this.getWidth() - 20), 0, 20, 20, this);
        ///.out.println("this.getWidth():" + this.getWidth());
    }

    public Target(JPanel jp) {
        ImageIcon icon = new ImageIcon("src/media/pic/aircraft1.gif");
        Image image = icon.getImage();
        this.im = image;
        try {
            getLab();
            this.setOpaque(false);
            this.jp = jp;
            x = rd.nextInt(jp.getWidth() - 45);
            this.setLocation(x, y);
            this.setSize(80, 30);
            this.add(lab);
            lab.setSize(60, 30);
            //System.out.println("------------------------------PanelWithPic==>lab.getWidth():" + lab.getWidth() + ",getHeight():" + lab.getHeight());
            lab.setLocation(0, 0);
            lab.setOpaque(false);
            jp.add(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void getLab() {
        lab = new JLabel();
        String s = WordStringGenerator.parseXml().get(rd.nextInt(500));
        lab.setText(s);
        lab.setFont(font);
        lab.setForeground(Color.WHITE);
        //lab.setSize(20, 10);
        //System.out.println("------------------------------PanelWithPic==>lab.getWidth():" + lab.getWidth() + ",getHeight():" + lab.getHeight());
        //lab.setLocation(0, 0);
        //lab.setOpaque(true);
    }

    public void changeLablePic() {
        this.setSize(80,80);
        this.lab.setSize(80, 80);  
        Icon icon = new ImageIcon("src/media/pic/spaceMove.gif");     //在此直接创建对象
        this.lab.setIcon(icon);
        this.lab.repaint();
        this.repaint();
        try {
            Thread.sleep(3000);
            this.remove(lab);
            this.repaint();
        } catch (InterruptedException ex) {
            Logger.getLogger(Target.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("*************************"+this.lab.getSize());
    }

    public void run() {
        boolean f = true;
        try {
            while (f) {
                if (this.getLocation().getY() + Constant.HEIGHT_JP < jp.getHeight()) {
                    y++;
                    if (move == 1 && x >= jp.getWidth() - 100) {
                        move = -1;
                    }

                    if (move == -1 && x <= 10) {
                        move = 1;
                    }
                    x = x + move * 3;
                    Thread.sleep(130);
                    this.setLocation(x, y);
//                    synchronized (this){
//                    if(this.lab.getText().length()==0)changeLablePic();
//                    }
                } else {
                    synchronized (this) {
                        if (this.getComponentCount() > 0) {
                            this.remove(this.lab);
                        }
                        if (null != this.lab) {
                            this.lab = null;
                        }
                        if (jp.getComponentCount() > 0) {
                            jp.remove(this);
                            jp.repaint();
                        }
                    }
                    System.gc();
                    f = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();;
        }
    }
}
