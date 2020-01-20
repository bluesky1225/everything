package gui;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;

public class MyFrame extends Frame {
	public MyFrame() {
		setTitle("상속 클래스");
		setSize(800, 600);
		setBackground(new Color(250, 200, 200));
		setLocation(100, 100);
		
		Dialog d = new Dialog(this, "다이얼로그", true); // 3번째 매개변수가 true면 Modal
		d.setSize(200, 200);
		d.setLocation(200, 200);
		d.setBackground(new Color(200, 200, 200));
		setVisible(true);
		d.setVisible(true);
		
		
	}
}
