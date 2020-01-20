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
		setTitle("��ư������");
		setLocation(200, 200);
		setSize(500, 500);
		count=0;
		Panel p = new Panel();
		
		FileDialog open = new FileDialog(this, "����", FileDialog.LOAD);
		open.setDirectory("C:\\Users\\admin\\Desktop");
		
		for(int i=0; i<200; i++) {
			btn = new Button("��ư");
			
			p.add(btn);
		}
		btn2 = new Button("�׸�");
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
		man = new Checkbox("����", group, true);
		women = new Checkbox("����", group, true);
		
		
		p.add(man);
		p.add(women);
		
		
		Label l = new Label("���̺�");
		p.add(l);
		ScrollPane sp = new ScrollPane(ScrollPane.SCROLLBARS_AS_NEEDED);
		sp.add(p);
		add(sp);
		
		// �޴��� ����
		MenuBar menuBar = new MenuBar();
		
		// �޴� ����
		Menu menu = new Menu("����");
		
		// �޴� ������ ����
		MenuItem item = new MenuItem("����");
		
		// �޴��� �޴� ������ ����
		menu.add(item);
		// �޴��ٿ� �޴� ����
		menuBar.add(menu);		
		// �����ӿ� �޴��� ����
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
				btn2.setLabel("��ư"+i);
				btn2.setBackground(colors[i%colors.length]);
				Thread.sleep(1000);
			} catch(InterruptedException e) {}
		}
		
		
		String[] lbls = {"�ȳ�", "�ϼ���", "�ݰ�����"};
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
