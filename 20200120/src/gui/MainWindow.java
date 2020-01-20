package gui;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.*;

public class MainWindow extends Frame {
	public MainWindow() {
		setTitle("게시물 입력");
		setLocation(100, 100);
		setSize(600, 400);
		// 크기 변경을 못 하게 설정
		setResizable(false);
		Panel northPanel = new Panel();
		Label lblTitle = new Label("제목");
		TextField txtTitle = new TextField(30);
		Panel centerPanel = new Panel();
		Label lblContent = new Label("내용");
		TextArea taContent = new TextArea();
		GridLayout gl = new GridLayout(2, 2);
		Panel southPanel = new Panel();
		southPanel.setLayout(gl);
		
		// 화면에 보여지는 문자
		//txtTitle.setEchoChar('*');
		
		add("North", northPanel);
		northPanel.add(lblTitle);
		northPanel.add(txtTitle);
		
		add("Center", centerPanel);
		centerPanel.add(lblContent);
		centerPanel.add(taContent);
		
		add("South", southPanel);
		for(int i=0; i<4; i++) {
			Button button = new Button("버튼");
			southPanel.add(button);
		}
		
		setVisible(true);
		
	}
}
