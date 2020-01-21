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
		//JOptionPane.showMessageDialog(this, "�׽�Ʈ!", "�޽��� ���̾�α�", JOptionPane.ERROR_MESSAGE);
		int result = JOptionPane.showConfirmDialog(this, "Ȯ���ϼ̳���", "���� ���̾�α�", JOptionPane.YES_NO_CANCEL_OPTION);
		String msg=null;
		if(result == JOptionPane.YES_OPTION) {
			msg = "��";
		}else if(result == JOptionPane.NO_OPTION) {
			msg = "�ƴϿ�";
		}else if(result == JOptionPane.CANCEL_OPTION) {
			msg = "���";
		}
		System.out.println(msg);
		
		String input = JOptionPane.showInputDialog(this, "�Է��ϼ���", "");
		
		System.out.println(input);
		
		setTitle("���̺� �׽�Ʈ");
		setSize(500, 600);
		setLocation(100, 100);
		
		
		jp = new JPanel();
		String[] titles = {"�̸�", "��ȭ��ȣ", "�ּ�"};
		String[][] contents = {{"ȫ�浿", "000-0000-0000", "���ѹα� ����"}, {"����ī", "010-2322-5555", "�������� ũ���̽�Ʈóġ"}};
		DefaultTableModel model = new DefaultTableModel(contents, titles);
		jt = new JTable(model);
		jsp = new JScrollPane(jt);
		jl1 = new JLabel("�̸�");
		jl2 = new JLabel("��ȭ��ȣ");
		jl3 = new JLabel("�ּ�");
		jf1 = new JTextField(5);
		jf2 = new JTextField(15);
		jf3 = new JTextField(30);
		jb1 = new JButton("�߰�");
		jb2 = new JButton("����");
		jb3 = new JButton("����");
		jb4 = new JButton("�Ʒ���");
		
		
		
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
				case "�߰�":
					String t1 = jf1.getText();
					String t2 = jf2.getText();
					String t3 = jf3.getText();
					Object [] o = {t1, t2, t3};
					model.addRow(o);
					break;
				case "����":
					model.removeRow(jt.getSelectedRow());
					System.out.println(jt.getSelectedRow());
					break;
				case "����":
					break;
				case "�Ʒ���":
					break;
				}
			}
		};
		
		jb1.addActionListener(al);
		jb2.addActionListener(al);
		jb3.addActionListener(al);
		jb4.addActionListener(al);
		
		
		jmb = new JMenuBar();
		jm = new JMenu("�޴�(T)");
		jm.setMnemonic('t'); // ��Ʈ t
		jmi = new JMenuItem("�޽��� ���");
		jm.add(jmi);
		jmb.add(jm);
		setJMenuBar(jmb);
		
		jmi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(TableTest.this, "�޽��� ��� ��ư�� �����̳׿�.");
			}
		});
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
