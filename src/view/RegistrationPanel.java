package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class RegistrationPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private ControlPanel controlPanel;
	private DirectoryPanel directoryPanel;
	
	public RegistrationPanel(int w, int h) {
		this.setLayout(new BorderLayout());
		
		ActionHandler actionHandler = new ActionHandler();
		this.controlPanel = new ControlPanel(actionHandler);
		this.add(this.controlPanel, BorderLayout.NORTH);

		this.directoryPanel = new DirectoryPanel();		
		this.add(this.directoryPanel, BorderLayout.CENTER);
	}

	public void initialize() {
		this.controlPanel.initialize();
		this.directoryPanel.initialize();
	}
	
	public class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getSource().equals(controlPanel.getBtSincheong())) {
				directoryPanel.showRegistrations();
			} 
			else if (event.getSource().equals(controlPanel.getBtSave())) {
//				System.out.println("¿˙¿Â");
					directoryPanel.saveRegistraions();
				}
			}
		}
	}

