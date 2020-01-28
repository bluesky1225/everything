import java.awt.Color;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class IOTest extends JFrame {
	private JPanel p;
	private JTextArea jl;
	private JScrollPane jsp;
	private JTextField ta;
	private JButton jb;
	private JButton jb2;
	private JButton jb3;
	
	public IOTest() {
		Image img = Toolkit.getDefaultToolkit().getImage("../maxresdefault.jpg");
		setTitle("�׽�Ʈ");
		setSize(800, 600);
		setIconImage(img);
		setLocation(100, 100);
		
		p = new JPanel();
		jl = new JTextArea();
		jsp = new JScrollPane(jl);
		//jl.setBackground(Color.BLUE); 		
		ta = new JTextField(10);
		jb = new JButton("����");
		jb2 = new JButton("����");
		jb3 = new JButton("Ŭ����");
		
		p.setSize(790, 590);
		jsp.setSize(780, 510);
		jl.setSize(770, 500);
		ta.setSize(400, 30);
		jb.setSize(70, 30);
		jb2.setSize(70, 30);
		jb3.setSize(90, 30);
		p.setLocation(0, 0);
		jsp.setLocation(5, 5);
		jl.setLocation(5, 5);
		ta.setLocation(5, 530);
		jb.setLocation(410, 530);
		jb2.setLocation(480, 530);
		jb3.setLocation(550, 530);
		ta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = ta.getText();
				jl.setText(jl.getText()+str+'\n'); // 
				ta.setText("");
			}
		});
		//ta.setBackground(new Color(255, 255, 255));
		//ta.setSize(400, 100);
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				switch(e1.getActionCommand()) {
				case "클릭":
					String text = jl.getText();
					
					try(PrintWriter pw = new PrintWriter("./src/test.txt") )
					{
						pw.println(text);
					} catch(Exception e) {
						
					}
					break;
				case "깨짐":
					try(BufferedReader br = new BufferedReader(new FileReader("../log.txt")) )
					{
						int total = 0;
						HashSet<String> hs = new HashSet<String>();
						// IP�� �ߺ� ���� ����ϱ����ؼ� SET ���
						
						HashMap<String, Integer> hm = new HashMap<String, Integer>();
						
						while(true) {
							String temp = br.readLine();
							if(temp==null) break;
							jl.setText(jl.getText()+temp+'\n');
							
							String[] temp2 = temp.split(" ");
							
							total+=Integer.parseInt(temp2[temp2.length-1]);	
							hs.add(temp2[0]);
							
							Integer traffic = hm.get(temp2[0]); // Ű�� ������ null
							
							if(traffic == null) {
								traffic = 0; // ���� Ű�϶� 0���� �ʱ�ȭ
							}
							traffic += Integer.parseInt(temp2[temp2.length-1]);
							hm.put(temp2[0], traffic);
						}
						
						for(String str:hs) {
							System.out.println(str);
						}
						System.out.println();
						System.out.println("Ʈ���� ��ü �հ� : "+total);
						System.out.println();
						Set<String> keys = hm.keySet();
						
						System.out.println("�����Ǵ� Ʈ���� �հ�");
						
						for(String key:keys) {
							System.out.println(key + " : " + hm.get(key));
						}
						
					} catch(Exception e) {
						System.out.println("���� : "+e.getMessage());
					}
					break;
				case "Ŭ����":
					jl.setText("");
					break;
				
				}
			}
		};
		jb.addActionListener(al);
		jb2.addActionListener(al);
		jb3.addActionListener(al);
		p.add(jsp);
		p.add(ta);
		p.add(jb);
		p.add(jb2);
		p.add(jb3);
		add(p);
		p.setLayout(null);
		setLayout(null);
		setVisible(true);		
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
	}
	
}
