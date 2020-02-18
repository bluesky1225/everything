import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestSwing extends JFrame {
	private JPanel panel;
	private List<JPanel> fragment;
	private JLabel[] mainDisplay;
	private JLabel display;
	private JButton[] mainButtons;
	public static TestSwing ins;
	
	public class BtnEvent implements ActionListener {
		private String text;
		public BtnEvent() {
			text="";
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			switch(e.getActionCommand()) {
			case "1":
				text+="1";
				break;
			case "2":
				text+="2";
				break;
			case "3":
				text+="3";
				break;
			case "4":
				text+="4";
				break;
			case "5":
				text+="5";
				break;
			case "6":
				text+="6";
				break;
			case "7":
				text+="7";
				break;
			case "8":
				text+="8";
				break;
			case "9":
				text+="9";
				break;
			case "*":
				text+="*";
				break;
			case "0":
				text+="0";
				break;
			case "#":
				text+="#";
				break;
			case "지우기":
				text=text.substring(0, text.length()-1);
				break;
			case "문자":
				fragment.add(new JPanel());
				fragment.get(1).setLayout(null);		
				fragment.get(1).setBackground(Color.BLUE);
				fragment.get(1).setBackground(Color.white);
				JLabel tempLabel = new JLabel(text+"문자를 보내기 위해 화면을 준비중입니다.");
				tempLabel.setSize(400, 600);
				tempLabel.setLocation(0, 0);
				fragment.get(1).add(tempLabel);
				panel = fragment.get(1);	
				panel.updateUI();
				TestSwing ins = TestSwing.getInstance();
				
				ins.repaint();
				ins.setVisible(true);
				break;
			}
			if(e.getActionCommand().equals("통화"))
				display.setText(text+"로 전화 거는중");
			else
				display.setText(text);
		}
		
	}
	
	public static TestSwing getInstance() {
		if(ins==null) ins = new TestSwing();
		return ins;
	}
	
	private TestSwing() {
		
		setSize(400, 600);
		setLocation(100, 100);
		setTitle("테스트");	
		
		fragment = new ArrayList<JPanel>();
		fragment.add(new JPanel());
		fragment.get(0).setLayout(null);		
		fragment.get(0).setBackground(Color.BLUE);
		fragment.get(0).setBackground(Color.white);
		
		int lWidth = 400;
		int lHeight = 350;
		mainDisplay = new JLabel[3];
		for(int i=0;i<mainDisplay.length;i++) {
			mainDisplay[i] = new JLabel();
			mainDisplay[i].setSize(lWidth, lHeight);
			mainDisplay[i].setLocation(0, 0);
		}
		display = mainDisplay[0];
		fragment.get(0).add(display);
		
		int bWidth = 100;
		int bHeight = 35;
		int bWidthPadding = 28;
		int bHeightPadding = 3;
		int bXLocBegin = 20;
		int temp = bXLocBegin;
		int bYLocBegin = 350;
		mainButtons = new JButton[15];
		BtnEvent btnEvent = new BtnEvent();
		for(int i=0;i<mainButtons.length;i++) {
			
			if(i==9) mainButtons[i] = new JButton("*");
			else if(i==10) mainButtons[i] = new JButton("0");
			else if(i==11) mainButtons[i] = new JButton("#");
			else if(i==12) mainButtons[i] = new JButton("지우기");
			else if(i==13) mainButtons[i] = new JButton("통화");
			else if(i==14) mainButtons[i] = new JButton("문자");
			else mainButtons[i] = new JButton(i+1+"");
			
			mainButtons[i].addActionListener(btnEvent);
		}
		for(JButton btn:mainButtons) {
			btn.setSize(bWidth, bHeight);
			btn.setLocation(bXLocBegin, bYLocBegin);
			fragment.get(0).add(btn);
			
			if(bXLocBegin+bWidth+bWidthPadding>lWidth) {
				bXLocBegin=temp;
				bYLocBegin=bYLocBegin+bHeight+bHeightPadding;
			}else {
				bXLocBegin=bXLocBegin+bWidth+bWidthPadding;
			}					
		}
		
		panel = fragment.get(0);		
		add(panel);
		setVisible(true);
	}

	public List<JPanel> getFragment() {
		return fragment;
	}

	public void setFragment(List<JPanel> fragment) {
		this.fragment = fragment;
	}

}
