package view;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import entity.Lecture;
import global.Constants;
import view.BasketView.ActionHandler;

public class BasketView extends JPanel {
	private static final long serialVersionUID = 1L;
	// sub-components
	private JButton btMoveToRight, btMoveToLeft;
	private JButton btRemoveBasket, btRemoveSincheong;
	LectureList basketList;
	LectureList sincheongList;

	public BasketView(JPanel parentPanel) {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			this.add(Box.createHorizontalStrut(10));//¿ÞÂÊ¶ç±â

		ActionHandler actionHandler = new ActionHandler();
			
		JPanel leftPanel= new JPanel();
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
			this.basketList = new LectureList(null);
			JScrollPane baskeListScrollPane = new JScrollPane();
			baskeListScrollPane.setViewportView(basketList);
			this.btRemoveBasket = new JButton(Constants.BASKETVIEW_C);
			this.btRemoveBasket.addActionListener(actionHandler);
			btRemoveBasket.setAlignmentX(Component.CENTER_ALIGNMENT);
			leftPanel.add(baskeListScrollPane);
			leftPanel.add(btRemoveBasket);
			this.add(leftPanel);
			
			
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		this.add(Box.createHorizontalStrut(10));//¿ÞÂÊ¶ç±â
			this.btMoveToRight = new JButton(Constants.BASKETVIEW_R);
			this.btMoveToRight.setActionCommand("¿À¸¥ÂÊÀ¸·Î");
			this.btMoveToRight.addActionListener(actionHandler);
			centerPanel.add(btMoveToRight);
			this.btMoveToLeft = new JButton(Constants.BASKETVIEW_L);
			this.btMoveToLeft.setActionCommand("¿ÞÂÊÀ¸·Î");
			this.btMoveToLeft.addActionListener(actionHandler);
			centerPanel.add(btMoveToLeft);
			this.add(centerPanel);
			
		JPanel rightPanel= new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		this.add(Box.createHorizontalStrut(10));//¿ÞÂÊ¶ç±â
			this.sincheongList = new LectureList(null);
			JScrollPane sincheongListScrollPane = new JScrollPane();
			sincheongListScrollPane.setViewportView(sincheongList);
			this.btRemoveSincheong = new JButton(Constants.BASKETVIEW_C);
			this.btRemoveSincheong.addActionListener(actionHandler);
			btRemoveSincheong.setAlignmentX(Component.CENTER_ALIGNMENT);
			rightPanel.add(sincheongListScrollPane);
			rightPanel.add(btRemoveSincheong);
			this.add(rightPanel);
			this.add(Box.createHorizontalStrut(10));//¿ÞÂÊ¶ç±â

	}

	public void addLectures(Vector<Lecture> selectedLectures) {
		this.basketList.showLectures(selectedLectures);
	}

	public void saveRegistraions(String basketFileName, String sincheongFileName) throws FileNotFoundException {
		this.basketList.saveLectures(basketFileName);
		this.sincheongList.saveLectures(sincheongFileName);
	}
	public class ActionHandler implements ActionListener {
				
		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getActionCommand().equals("¿À¸¥ÂÊÀ¸·Î")) {
//				System.out.println("¿À¸¥ÂÊÀ¸·Î ¿Å±â±â");
				Vector<Lecture> selectedLectures =basketList.getSelectedLectures();
				sincheongList.showLectures(selectedLectures);
//				sincheongList.setVisible(true);
			}else if(event.getActionCommand().equals("¿ÞÂÊÀ¸·Î")){
//				System.out.println("¿ÞÂÊÀ¸·Î ¿Å±â±â");
				Vector<Lecture> selectedLectures =sincheongList.getSelectedLectures();
				basketList.showLectures(selectedLectures);
			}else if(event.getSource().equals(btRemoveBasket)){
				int i = basketList.getSelectedRow();
				basketList.getTableModel().removeRow(i);
			}else if(event.getSource().equals(btRemoveSincheong)){
				int i = sincheongList.getSelectedRow();
				sincheongList.getTableModel().removeRow(i);
			}	
		}
	}
}
