/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

/**
 *
 * @author luizb
 */
public class Fundotela extends JDesktopPane{
    private Image imagem;
    public Fundotela(String imagem){
        this.imagem = new ImageIcon(imagem).getImage();
        
}
  @Override
    public void paintComponent(Graphics g){
        g.drawImage(imagem, 0, 0, getWidth(), getHeight(), this);
        
    }
}