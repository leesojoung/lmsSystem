package view;

import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entity.Student;
import global.Constants;

public class MainView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton btLogin;
	private Student loginStudent;
	private LoginView loginView;
	private boolean login;
	private RegistrationPanel registrationPanel;
	private JPanel loginPanel;
	
	public MainView() {
		// set attributes
		this.setLocation(Constants.MAINVIEW_X, Constants.MAINVIEW_Y);
		this.setSize(Constants.MAINVIEW_W, Constants.MAINVIEW_H);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.loginPanel = new JPanel();
		loginPanel.setLayout(new FlowLayout());
		btLogin= new JButton(Constants.MAINVIEW_LOGIN);
		btLogin.setActionCommand(Constants.MAINVIEW_Login);
		btLogin.addActionListener(new ActionHandler());
		loginPanel.add(btLogin);
		this.add(loginPanel);
	}
	
	public void setLoginStudent(Student loginStudent) {this.loginStudent = loginStudent;}
	public void setLogin(boolean login) {this.login = login;}
	
	private void login() {   
		 try {         
	         loginView= new LoginView(this);         
	         loginView.setVisible(true);
	         this.setLogin(this.loginView.isLogin());
	
	         if (this.login){            
		            this.setLoginStudent(this.loginView.getStudent());
		            this.btLogin.setEnabled(false);
		            this.btLogin.setVisible(false);
//		            this.setLoginView(this.loginStudent);
		            System.out.println("∫Ÿ¿”");
		            
		            this.registrationPanel= new RegistrationPanel(Constants.MAINVIEW_W, Constants.MAINVIEW_H);
		            this.registrationPanel.initialize();
		    		this.add(this.registrationPanel);
		    		
		            	         	            	            
		            }
		      } catch (FileNotFoundException e) {
		         e.printStackTrace();
		      }
		 }
	
//	 private void setLoginView(Student loginStudent) {
//			JLabel loginName = new JLabel(/*loginStudent.getUserName()+*/Constants.MAINVIEW_NIM);
//			this.add(loginName);
//		}
	 
	 class ActionHandler implements ActionListener {
			public void actionPerformed(ActionEvent actionEvent) {
				if(actionEvent.getActionCommand().equals(Constants.MAINVIEW_Login)){
					login();
				}else if(actionEvent.getActionCommand().equals(Constants.MAINVIEW_BS)){
				}			
			}
	}
}
