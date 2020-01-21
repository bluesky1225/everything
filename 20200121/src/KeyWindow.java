import java.awt.*;
import java.awt.event.*;

public class KeyWindow extends Frame {
	private Label l1, l2;	
	Image img;

	public void paint(Graphics g) {
		String filePath = "C:\\Users\\admin\\Desktop\\cumulus-cloud.jpg";
		img = Toolkit.getDefaultToolkit().getImage(filePath);
		
		g.drawImage(img, 0, 0, 400, 400, this);
	}
	
	public KeyWindow() {		
		
		setTitle("키보드 이벤트");
		setLocation(100, 100);
		setSize(400, 400);
		l1 = new Label("");
		l1.setBackground(Color.BLUE);
		l1.setLocation(50, 50);
		l1.setSize(30, 30);
		l2 = new Label("");
		l2.setBackground(Color.CYAN);
		l2.setLocation(100, 30);
		l2.setSize(30, 30);
		setLayout(null);
		add(l1);	
		add(l2);
		
		Thread th = new Thread() {
			public void run() {
				while(true) {
					try {
						Thread.sleep(500);
						int x = l2.getLocation().x;
						int y = l2.getLocation().y;
						if(y>=360) break;
						y += 5;
						l2.setLocation(x, y);
					}catch(InterruptedException e) {}
				}
			}
		};
		th.start();
		
		setVisible(true);
		
		addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent ke) {
				//System.out.println(ke.getKeyChar()); // 대소문자 구분
				//System.out.println(ke.getKeyCode()); // 대소문자 구분 X
				int x = l1.getLocation().x;
				int y = l1.getLocation().y;
				
				int code = ke.getKeyCode();
				
				switch(code) {
				case KeyEvent.VK_UP:
					y-=5;
					break;
				case KeyEvent.VK_LEFT:
					x-=5;
					break;
				case KeyEvent.VK_RIGHT:
					x+=5;
					break;
				case KeyEvent.VK_DOWN:
					y+=5;
					break;
				case KeyEvent.VK_X:
					System.exit(0);
				}
				
				if(ke.getModifiers()==KeyEvent.ALT_MASK) {
					l1.setBackground(Color.YELLOW);
				} else if(ke.getModifiers()==KeyEvent.CTRL_MASK) {
					l1.setBackground(Color.BLUE);
				}
				
				l1.setLocation(x, y);
			}
			
			public void keyTyped(KeyEvent ke) {
				if(ke.getModifiers()==512) {
					System.out.println("Alt를 누르셨네요.");
					l1.setBackground(Color.YELLOW);
				}
			}
			
			public void keyReleased(KeyEvent ke) {
				
			}			
		});	
		
		// 어댑터 클래스로 해결
		WindowAdapter wl = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) { // 종료 버튼 누를때 호출되는 메소드
				// TODO Auto-generated method stub
				System.exit(0);
			}			
		};
		/*  리스너 인터페이스 구현	
		WindowListener wl = new WindowListener() {

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent arg0) { // 종료 버튼 누를때 호출되는 메소드
				// TODO Auto-generated method stub
				System.exit(0);
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		};
		*/
		this.addWindowListener(wl);
	}
	
}
