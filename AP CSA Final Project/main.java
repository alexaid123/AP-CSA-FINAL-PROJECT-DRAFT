import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class main {
	static JFrame frame = new JFrame("Game");
	static JPanel panel = new JPanel();
	static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	static JButton start = new JButton("START");
	static JButton levels = new JButton("LEVELS");
	static JButton help = new JButton("HELP");
	static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	static JLabel title = new JLabel("AIDONIS MAZE GAME");
	static BufferedImage image1 = null; 
	static JLabel player = new JLabel();
	static BufferedImage image2 = null; 
	static JLabel ground = new JLabel();
	static BufferedImage image3 = null; 
	static JLabel finish = new JLabel();
	static int y = -12;
	static int x = 0;
	static JFrame game = new JFrame("GAME");
	public static void main(String args[])
	{
		makeMenu();
		//makeScene();
		//level1();
		//gameLoop();
	}
	public static void makeMenu()
	{
		frame.setSize(600,700);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.add(panel);
		panel.setVisible(true);
		panel.setBackground(Color.black);
		panel.add(start);
		panel.setLayout(null);
		panel.add(start);
		panel.add(levels);
		panel.add(help);
		panel.add(title);
		title.setBounds(50,20,500,100);
		title.setForeground(Color.RED);
		title.setFont(new Font("Verdana", Font.BOLD, 40));
		help.setBounds(250,480,100,40);
		help.setBackground(Color.blue);
		help.setForeground(Color.white);
		levels.setBounds(250,330,100,40);
		levels.setBackground(Color.blue);
		levels.setForeground(Color.white);
		start.setBounds(250,180,100,40);
		start.setBackground(Color.blue);
		start.setForeground(Color.white);
		start.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	             start.setVisible(false);
	             levels.setVisible(false);
	             help.setVisible(false);
	             title.setVisible(false);
	             frame.setVisible(false);
	             makeScene();
	             level1();
	          }
		 });
	}
	public static void makeScene()
	{
		game.setSize(600,700);
		game.setVisible(true);
		game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		game.setResizable(false);
		game.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		game.add(panel);
		panel.setVisible(true);
		panel.setBackground(Color.black);
		 try {
			   image1 = ImageIO.read(new File("C:\\Users\\student\\eclipse-workspace\\AP CSA Final Project\\Images\\player.png"));
			   image2 = ImageIO.read(new File("C:\\Users\\student\\eclipse-workspace\\AP CSA Final Project\\Images\\ground.png"));
			   image3 = ImageIO.read(new File("C:\\Users\\student\\eclipse-workspace\\AP CSA Final Project\\Images\\finish.png"));
			  } catch (IOException e) {
			   e.printStackTrace();
			  }
			  ImageIcon icon = new ImageIcon(image1);
			  player.setIcon(icon);
			  ImageIcon icon1 = new ImageIcon(image2);
			  ground.setIcon(icon1);
			  ImageIcon icon2 = new ImageIcon(image3);
			  finish.setIcon(icon2);
		panel.add(player);
		panel.add(ground);
		panel.add(finish);
		finish.setBounds(0,0,60,77);
		player.setBounds(100,292,40,30);
	      game.addKeyListener(new KeyAdapter() {
   			  public void keyPressed(KeyEvent e) {
   			   if(e.getKeyCode() == KeyEvent.VK_RIGHT)
   			   {
   				   if(player.getX()>=545)
   				   {
   					   player.setBounds(545,player.getY(),40,30);
   				   }
   				   else
   				   {
   					   player.setBounds(player.getX()+5,player.getY(),40,30);
   				   }
   			   }
   			   if(e.getKeyCode() == KeyEvent.VK_LEFT)
   			   {
   				   if(player.getX()<=0)
   				   {
   					   player.setBounds(0,player.getY(),40,30);
   				   }
   				   else
   				   {
   					   player.setBounds(player.getX()-5,player.getY(),40,30);
   				   }
   			   }
   			   if(e.getKeyCode() == KeyEvent.VK_UP)
   			   {
   				   if(player.getY()<=0)
   				   {
   					   player.setBounds(player.getX(),0,40,30);
   				   }
   				   else
   				   {
   					   player.setBounds(player.getX(),player.getY()-5,40,30);
   				   }
   			   }
   			   if(e.getKeyCode() == KeyEvent.VK_DOWN)
   			   {
   				   if(player.getY()>=800)
   				   {
   					   player.setBounds(player.getX(),800,40,30);
   				   }
   				   else
   				   {
   					   player.setBounds(player.getX(),player.getY()+5,40,30);
   				   }
   			   }
   			  }
   			 });
		
	}
	public static void level1()
	{
		for(int i = 0; i < 5; i++)
		{
			if(x == 0)
			{
				x = 60;
			}
			else
			{
				x = 0;
			}
			enemies.add(new Enemy(x,y,"C:\\Users\\student\\eclipse-workspace\\AP CSA Final Project\\Images\\ground.png"));
			y += 120;
			enemies.get(enemies.size()-1).display();
		}
	}
	/*public static void gameLoop()
	{
		while(true)
		{
			for(int i = 0; i < enemies.size();i++)
			{
				enemies.get(i).gravity();
			}
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}*/
}