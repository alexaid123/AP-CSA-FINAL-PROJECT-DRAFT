import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Enemy extends main {
		 private static final long serialVersionUID = 1L;
		 int xpo;
		 int ypo;
		 BufferedImage image = null; 
		 JLabel character = new JLabel();
		 public Enemy(int x, int y,String path)
		 {
		  try {
		   image = ImageIO.read(new File(path));
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
		  ImageIcon icon = new ImageIcon(image);
		  character.setIcon(icon);
		  xpo = x;
		  ypo = y;
		 }
		 
		 public int getX()
		 {
		  return xpo;
		 }
		 public int getY()
		 {
		  return ypo;
		 }
		 /* public void gravity()
		 {
		  if(ypo >= 800)
		  {
		   makeEnemies();
		  }
		  else
		  {
		  ypo += 4;
		  }
		  character.setLocation(xpo,ypo);
		 }*/
		 public void display()
		 {
		  panel.add(character);
		  character.setVisible(true);
		  character.setBounds(xpo,ypo,540,100);
		 }	
}
