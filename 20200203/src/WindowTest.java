import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WindowTest extends JFrame implements Runnable {
		private BufferedImage bi;
		private JPanel paper;
		private JLabel paper2;
		
		public WindowTest() {
			setTitle("윈도우 프로그램");
			setBackground(Color.BLACK);
			setSize(1000, 1000);
			setLocation(200, 200);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			try {
				bi = ImageIO.read(new File("./redball.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			paper = new JPanel();
			paper.setSize(1000, 1000);
			paper.setLocation(0, 0);
			add(paper);
			//paper2 = new JLabel();
			//paper2.setSize(1000, 1000);
			//paper2.setLocation(0, 0);
			Thread t1 = new Thread(this);			
			Thread t2 = new Thread(this);
			Thread t3 = new Thread(this);
			
			//paper.add(paper2);
			t1.start();
			//t2.start();
			//t3.start();
			setVisible(true);
		}

		public void paint(Graphics g) {
			for(int i=0; i<1000; i=i+100) {
				g.drawImage(bi, i, i, this.paper);
				try {
					//g.drawImage(bi, i, i, paper);
					//paper2.setIcon(new ImageIcon(bi));
					
					Thread.sleep(300);
					
					//paper.revalidate();
					
					
					
					g.clearRect(i, i, 100, 100);
					g.fillRect(0, 0, 1000, 1000);
				
					paper.repaint();
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			repaint();
			revalidate();
				
				
			
		}
}
