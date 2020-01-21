package swing;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TableTest extends JFrame {
	private JPanel jp;
	private JTable jt;
	private JScrollPane jsp;
	private JLabel jl1;
	private JLabel jl2;
	private JLabel jl3;
	private JTextField jf1;
	private JTextField jf2;
	private JTextField jf3;
	private JButton jb1;
	private JButton jb2;
	private JButton jb3;
	private JButton jb4;
	private JMenuBar jmb;
	private JMenu jm;
	private JMenuItem jmi;
	
	public TableTest() {
		//JOptionPane.showMessageDialog(this, "테스트!", "메시지 다이얼로그", JOptionPane.ERROR_MESSAGE);
		int result = JOptionPane.showConfirmDialog(this, "확인하셨나요", "컨펌 다이얼로그", JOptionPane.YES_NO_CANCEL_OPTION);
		String msg=null;
		if(result == JOptionPane.YES_OPTION) {
			msg = "예";
		}else if(result == JOptionPane.NO_OPTION) {
			msg = "아니오";
		}else if(result == JOptionPane.CANCEL_OPTION) {
			msg = "취소";
		}
		System.out.println(msg);
		
		String input = JOptionPane.showInputDialog(this, "입력하세요", "");
		
		System.out.println(input);
		
		setTitle("테이블 테스트");
		setSize(500, 600);
		setLocation(100, 100);
		
		
		jp = new JPanel();
		String[] titles = {"이름", "전화번호", "주소"};
		String[][] contents = {{"홍길동", "000-0000-0000", "대한민국 서울"}, {"제시카", "010-2322-5555", "뉴질랜드 크라이스트처치"}};
		DefaultTableModel model = new DefaultTableModel(contents, titles);
		jt = new JTable(model);
		jsp = new JScrollPane(jt);
		jl1 = new JLabel("이름");
		jl2 = new JLabel("전화번호");
		jl3 = new JLabel("주소");
		jf1 = new JTextField(5);
		jf2 = new JTextField(15);
		jf3 = new JTextField(30);
		jb1 = new JButton("추가");
		jb2 = new JButton("삭제");
		jb3 = new JButton("위로");
		jb4 = new JButton("아래로");
		
		
		
		add(jp);
		jp.add(jsp);
		jp.add(jl1);
		jp.add(jf1);
		jp.add(jl2);
		jp.add(jf2);
		jp.add(jl3);
		jp.add(jf3);
		jp.add(jb1);
		jp.add(jb2);
		jp.add(jb3);
		jp.add(jb4);
		
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(e.getActionCommand()) {
				case "추가":
					String t1 = jf1.getText();
					String t2 = jf2.getText();
					String t3 = jf3.getText();
					Object [] o = {t1, t2, t3};
					model.addRow(o);
					break;
				case "삭제":
					model.removeRow(jt.getSelectedRow());
					System.out.println(jt.getSelectedRow());
					break;
				case "위로":
					break;
				case "아래로":
					break;
				}
			}
		};
		
		jb1.addActionListener(al);
		jb2.addActionListener(al);
		jb3.addActionListener(al);
		jb4.addActionListener(al);
		
		
		jmb = new JMenuBar();
		jm = new JMenu("메뉴(T)");
		jm.setMnemonic('t'); // 알트 t
		jmi = new JMenuItem("메시지 출력");
		jm.add(jmi);
		jmb.add(jm);
		setJMenuBar(jmb);
		
		jmi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(TableTest.this, "메시지 출력 버튼을 누르셨네요.");
			}
		});
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
