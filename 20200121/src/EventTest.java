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
		setTitle("�׽�Ʈ");
		setSize(800, 600);
		setLocation(100, 100);
		buttons = new Button[2];
		testPanel = new Panel();
		testBtn = new Button("��ư");
		testBtn2 = new Button("�׸�");
		testLabel = new Label("���̺�");
		testText = new TextField(10);
		buttons[0] = new Button("Ŭ��");
		buttons[1] = new Button("Ŭ��2");
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
				
				// �̰��� �¼� ���� ���α׷��̶��
				// System.out.println(e.getActionCommand() + "����");
				// �̷��� �����ϰ� �� �� �ִ�
				
				switch(e.getActionCommand()) {
				case "Ŭ��":
					testLabel.setBackground(Color.RED);
					break;
				case "Ŭ��2":
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
					System.out.println("���� ����");
				} else {
					System.out.println("���� ����");
				}
				*/
				
				if(dae*so*su*etc != 0) {
					System.out.println("���� ����");
				} else {
					System.out.println("���� ����");
				}
			}
		});
	}

}
