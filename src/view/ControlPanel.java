package view;

import javax.swing.JButton;
import javax.swing.JPanel;

import global.Constants;
import view.RegistrationPanel.ActionHandler;

public class ControlPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JButton btSincheong;
	private JButton btSave;
	private JButton btLogout;
	public ControlPanel(ActionHandler actionHandler) {
		
		this.btSincheong = new JButton(Constants.BTITLE_SINCHEONG);
		this.btSincheong.addActionListener(actionHandler);
		this.add(this.btSincheong);
		
		this.btSave = new JButton(Constants.BTITLE_SAVE);
		this.btSave.addActionListener(actionHandler);
		this.add(this.btSave);
		
		this.btLogout = new JButton(Constants.BTITLE_LOGOUT);
		this.add(this.btLogout);
	}
	public void initialize() {
	}
	public Object getBtSincheong() { return this.btSincheong; }
	public Object getBtSave() { return this.btSave; }
}
