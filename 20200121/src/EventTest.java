import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

import javax.swing.ImageIcon;

public class EventTest extends Frame {
	private Panel testPanel;
	private Button testBtn;
	private Button testBtn2;
	private Label testLabel;
	private TextField testText;
	private Button[] buttons;
	private Image img;
	
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this.testLabel);
	}
	
	public EventTest() {
		setTitle("테스트");
		setSize(800, 600);
		setLocation(100, 100);
		buttons = new Button[2];
		testPanel = new Panel();
		testBtn = new Button("버튼");
		testBtn2 = new Button("그림");
		testLabel = new Label("레이블");
		testText = new TextField(10);
		buttons[0] = new Button("클릭");
		buttons[1] = new Button("클릭2");
		add(testPanel);
		testPanel.add(testLabel);
		testPanel.add(testBtn);
		testPanel.add(testBtn2);
		testPanel.add(testText);
		testPanel.add(buttons[0]);
		testPanel.add(buttons[1]);
		testPanel.setLayout(null);
		testText.setSize(100, 40);
		testBtn.setSize(100, 40);
		testBtn2.setSize(100, 40);
		buttons[0].setSize(100, 40);
		buttons[1].setSize(100, 40);
		testLabel.setSize(300, 300);
		testBtn.setLocation(300, 0);
		testBtn2.setLocation(410, 0);
		buttons[0].setLocation(520, 0);
		buttons[1].setLocation(630, 0);
		testLabel.setLocation(0, 0);
		testLabel.setBackground(Color.GREEN);
		testText.setLocation(0, 300);
		setVisible(true);
		
		
		testText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = testText.getText();
				testLabel.setText(msg);
			}
		});		
		
		ActionListenerTest alt = new ActionListenerTest(testLabel);
		testBtn.addActionListener(alt);
		
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filePath = "C:\\Users\\admin\\Desktop\\cumulus-cloud.jpg";
				img = Toolkit.getDefaultToolkit().getImage(filePath);
				
				System.out.println(img);
				repaint();
				
			}
		};
		testBtn2.addActionListener(al);		
		
		ActionListener al2 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				switch(e.getSource()) {
				case buttons[0]:
				case buttons[1]:
				}
				*/
				
				// 이것이 좌석 예약 프로그램이라면
				// System.out.println(e.getActionCommand() + "예약");
				// 이렇게 간단하게 할 수 있다
				
				switch(e.getActionCommand()) {
				case "클릭":
					testLabel.setBackground(Color.RED);
					break;
				case "클릭2":
					testLabel.setBackground(Color.BLUE);
					break;
				}
			}
		};
		
		for(Button temp:buttons) {
			temp.addActionListener(al2);
		}
		
		testText.addTextListener(new TextListener() {
			public void textValueChanged(TextEvent te) {
				String msg = testText.getText();
				
				int dae = 0;
				int so = 0;
				int su = 0;
				int etc = 0;
				
				for(int i=0; i<msg.length(); i++) {
					char ch = msg.charAt(i);
					
					if(ch>='A'&&ch<='Z') {
						dae+=1;
					}else if(ch>='a'&&ch<='z') {
						so+=1;
					}else if(ch>='0'&&ch<='9') {
						su+=1;
					}else {
						etc+=1;
					}
				}
				/*
				if(dae>0 && so>0 && su>0 && etc>0) {
					System.out.println("보안 강함");
				} else {
					System.out.println("보안 약함");
				}
				*/
				
				if(dae*so*su*etc != 0) {
					System.out.println("보안 강함");
				} else {
					System.out.println("보안 약함");
				}
			}
		});
	}

}
