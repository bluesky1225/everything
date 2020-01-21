import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerTest implements ActionListener {
	private Label l;
	
	public ActionListenerTest(Label l) {
		this.l = l;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if((e.getModifiers() & 512) == 512) {
			l.setText("Alt키도 누르셨네요");
			l.setBackground(Color.GREEN);
		} else {
			l.setBackground(Color.CYAN);
		}
	}

}
