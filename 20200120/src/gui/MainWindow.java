package gui;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.*;

public class MainWindow extends Frame {
	public MainWindow() {
		setTitle("�Խù� �Է�");
		setLocation(100, 100);
		setSize(600, 400);
		// ũ�� ������ �� �ϰ� ����
		setResizable(false);
		Panel northPanel = new Panel();
		Label lblTitle = new Label("����");
		TextField txtTitle = new TextField(30);
		Panel centerPanel = new Panel();
		Label lblContent = new Label("����");
		TextArea taContent = new TextArea();
		GridLayout gl = new GridLayout(2, 2);
		Panel southPanel = new Panel();
		southPanel.setLayout(gl);
		
		// ȭ�鿡 �������� ����
		//txtTitle.setEchoChar('*');
		
		add("North", northPanel);
		northPanel.add(lblTitle);
		northPanel.add(txtTitle);
		
		add("Center", centerPanel);
		centerPanel.add(lblContent);
		centerPanel.add(taContent);
		
		add("South", southPanel);
		for(int i=0; i<4; i++) {
			Button button = new Button("��ư");
			southPanel.add(button);
		}
		
		setVisible(true);
		
	}
}
