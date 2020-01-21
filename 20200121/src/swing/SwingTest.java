package swing;

import javax.swing.JFrame;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SwingTest extends JFrame {
	private JLabel jl;
	private JButton jb;
	private Thread th;
	private ImageIcon ii;
	
	public SwingTest() {
		setTitle("테스트");
		setSize(800, 600);
		setLocation(100, 100);
		String [] images = {"0.png", "1.png", "2.png", "3.png", "4.png", "5.png","6.png","7.png","8.png","9.png"};
		
		jl = new JLabel();
		jl.setSize(550, 530);
		jl.setLocation(0, 0);
		jl.setToolTipText("레이블입니다");
		add(jl);
		jb = new JButton("on");
		jb.setSize(100, 40);
		jb.setLocation(550, 0);
		jb.setToolTipText("애니메이션을 켜고 끌수있는 버튼입니다.");
		add(jb);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					System.out.println(arg0.getActionCommand());
					switch(arg0.getActionCommand()) {
					case "on":						
						jb.setText("off");
						th = new Thread() {
							public void run() {
								try {
									int i = 0;
									while(true)  {
										
										Thread.sleep(100);
										ii = new ImageIcon("C:\\Users\\admin\\Desktop\\"+images[i++%10]);
										jl.setIcon(ii);
										System.out.println(i);
									} 
								}catch(InterruptedException e) {}
							}
						};
						
						th.start();
						break;
					case "off":					
						jb.setText("on");
						th.interrupt();
						break;
					}
					
					
				} catch(Exception e) {}
			}
		};
		
		jb.addActionListener(al);
		
		
		
		
		/*
		int i = 0;
		while(true) {
			
			try {
				if(i==10) i=0;
				ImageIcon ii = new ImageIcon("C:\\Users\\admin\\Desktop\\"+images[i]);
				jl.setIcon(ii);
				Thread.sleep(200);
				i++;
			} catch(InterruptedException e) {}
		}
		*/	
	}
}
