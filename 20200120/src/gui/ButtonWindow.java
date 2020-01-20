package gui;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ButtonWindow extends Frame {
	private Button btn, btn2;
	private Checkbox man, women;
	private int count;
	
	public ButtonWindow() {
		setTitle("버튼윈도우");
		setLocation(200, 200);
		setSize(500, 500);
		count=0;
		Panel p = new Panel();
		
		FileDialog open = new FileDialog(this, "열기", FileDialog.LOAD);
		open.setDirectory("C:\\Users\\admin\\Desktop");
		
		for(int i=0; i<200; i++) {
			btn = new Button("버튼");
			
			p.add(btn);
		}
		btn2 = new Button("그림");
		p.add(btn2);
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				count++;
				if(count%2==0) {
					p.setBackground(new Color(255, 255, 255));
				} else {					
					p.setBackground(new Color(100, 200, 100));
				}				
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
				
				//C:\\Users\\admin\\Desktop\\cumulus-cloud.jpg
			}
		});
		
		CheckboxGroup group = new CheckboxGroup();
		man = new Checkbox("남자", group, true);
		women = new Checkbox("여자", group, true);
		
		
		p.add(man);
		p.add(women);
		
		
		Label l = new Label("레이블");
		p.add(l);
		ScrollPane sp = new ScrollPane(ScrollPane.SCROLLBARS_AS_NEEDED);
		sp.add(p);
		add(sp);
		
		// 메뉴바 생성
		MenuBar menuBar = new MenuBar();
		
		// 메뉴 생성
		Menu menu = new Menu("파일");
		
		// 메뉴 아이템 생성
		MenuItem item = new MenuItem("열기");
		
		// 메뉴에 메뉴 아이템 부착
		menu.add(item);
		// 메뉴바에 메뉴 부착
		menuBar.add(menu);		
		// 프레임에 메뉴바 부착
		setMenuBar(menuBar);
		
		item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				open.setVisible(true);
			}
		});
		
		setVisible(true);
		
		Color [] colors = {Color.RED, Color.GREEN, Color.BLUE};
		for(int i=0; i<10; i++) {
			try {					
				btn2.setLabel("버튼"+i);
				btn2.setBackground(colors[i%colors.length]);
				Thread.sleep(1000);
			} catch(InterruptedException e) {}
		}
		
		
		String[] lbls = {"안녕", "하세요", "반가워요"};
		Color[] lblc = {Color.PINK, Color.YELLOW, Color.CYAN};
		Random r = new Random();
		int j = 0;
		while(true) {
			try {
				Thread.sleep(500);
				j = j + 1;
				l.setText(lbls[j % lbls.length]);
				l.setForeground(lblc[r.nextInt(lblc.length)]);
			}catch(Exception e) {}
		}
		
		
	}
}
