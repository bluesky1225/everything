package gui;

import java.awt.Frame;
import java.awt.*;

public class NullLayout extends Frame {
	private Label l1;
	
	public NullLayout() {
		setTitle("널 레이아웃");
		setLocation(100, 100);
		setSize(400, 400);
		setResizable(false);
		
		setLayout(null); //레이아웃 null 설정
		l1 = new Label("테스트");
		l1.setSize(60, 20);
		l1.setLocation(0, 0);
		l1.setBackground(Color.RED);
		add(l1);
		setVisible(true);
		for(int i =0; i<50; i++) {
			try {
				Thread.sleep(100);
				l1.setLocation(i, i);
			} catch(Exception e) {}
		}
		
		while(true) {
			int x = l1.getLocation().x;
			int y = l1.getLocation().y;
			int sign = 20;
			
			if(x == 300) {
				sign = -20;
			} else if(x == 0) {
				sign = +20;
			}
			
			x = x + sign;
			
			try {
				Thread.sleep(100);
				l1.setLocation(x, y);
			} catch(Exception e) {}
		}
		
		
		
	}
}
