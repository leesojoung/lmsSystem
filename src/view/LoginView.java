package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import control.StudentControl;
import entity.Student;
import global.Constants;

public class LoginView extends JDialog  {
	private static final long serialVersionUID = 1L;
	// controller
	private StudentControl studentControl;
	// sub-components
	private JLabel lbUserName, lbPassword;
	private JTextField tfUserName; 
	private JPasswordField tfPassword;
	private JButton btOk, btCancel;
	private boolean login;
	private Student student;
	
	public LoginView(JFrame frame) throws FileNotFoundException {
		super(frame, Constants.LOGINVIEW_TITLE, true);
		// attributes
		this.setLocationRelativeTo(frame);
		this.setSize(200,150);
		this.setLayout(new FlowLayout());;
		this.setResizable(false);
		// add sub-components
		this.lbUserName = new JLabel(Constants.LOGINVIEW_ID);
		this.add(this.lbUserName);		
		this.tfUserName = new JTextField(10);
		this.add(this.tfUserName);		
		this.lbPassword = new JLabel(Constants.LOGINVIEW_PASSWORD);
		this.add(this.lbPassword);		
		this.tfPassword = new JPasswordField(10);
		this.add(this.tfPassword);
		
		ActionHandler actionHandler = new ActionHandler();
		this.btOk = new JButton(Constants.LOGINVIEW_Ok);
		this.add(this.btOk);
		this.btOk.setActionCommand(Constants.LOGINVIEW_OK);
		this.btOk.addActionListener(actionHandler);
		
		this.btCancel = new JButton(Constants.LOGINVIEW_Cancel);		
		this.add(this.btCancel);
		this.btCancel.setActionCommand(Constants.LOGINVIEW_CANCEL);
		this.btCancel.addActionListener(actionHandler);

		this.studentControl = new StudentControl();
	}
	
	public boolean isLogin() {return login;}
	public void setLogin(boolean login) {this.login = login;}
	
	public Student getStudent() {return student;}
	public void setStudent(Student student) {this.student = student;}
	
	private void login() {
		String userName = this.tfUserName.getText();
		String password = 
				new String(this.tfPassword.getPassword());
		Student student = 
				this.studentControl.login(userName, password);
		if (student == null) {
			JOptionPane.showMessageDialog(this, "잘못 입력", "", JOptionPane.ERROR_MESSAGE);
		} else {
			this.setLogin(true);
			this.dispose();
			
		}
	}
	private void cancel() {
		this.dispose();
	}
	
	class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent actionEvent) {
			if (actionEvent.getActionCommand().equals(Constants.LOGINVIEW_OK)) {
				login();
//				System.out.println("OK");
			} else if (actionEvent.getActionCommand().equals(Constants.LOGINVIEW_CANCEL)) {
				cancel();
//				System.out.println("Cancel");
			}
		}		
	}
}
