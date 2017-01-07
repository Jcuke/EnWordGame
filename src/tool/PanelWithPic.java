/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.event.EventListenerList;
import javax.swing.plaf.ComponentUI;

/**
 *
 * @author Administrator
 */
public class PanelWithPic  extends JPanel{

    Image im;
    String picFilePath;
    
    public PanelWithPic(String picFilePath) {
        ImageIcon icon = new ImageIcon(picFilePath);
        Image image = icon.getImage();
        this.im = image;
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    }
    
    public PanelWithPic() {
//        ImageIcon icon = new ImageIcon("src/media/pic/spaceMove.gif");
//        Image image = icon.getImage();
//        this.im = image;
//        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
//        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
//        System.out.println("width:"+width+",height:"+height);
    }
    
    

    //画出背景
    @Override
    protected void paintComponent(Graphics g) {
        // 清屏
        super.paintComponent(g);
        g.drawImage(im, 0, 0, this.getWidth(), this.getHeight(), this);
       // System.out.println("PanelWithPic==>this.getWidth():"+this.getWidth()+",getHeight():"+getHeight());
    }

    public Image getIm() {
        return im;
    }

    public void setIm(Image im) {
        this.im = im;
    }

    public String getPicFilePath() {
        return picFilePath;
    }

    public void setPicFilePath(String picFilePath) {
        this.picFilePath = picFilePath;
    }

    public ComponentUI getUi() {
        return ui;
    }

    public void setUi(ComponentUI ui) {
        this.ui = ui;
    }

    public EventListenerList getListenerList() {
        return listenerList;
    }

    public void setListenerList(EventListenerList listenerList) {
        this.listenerList = listenerList;
    }

   
    
}
