package view;

import java.io.FileNotFoundException;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.LectureManager;
import entity.Lecture;
import global.Constants;
import view.DirectoryPanel.ListSelectionHandler;

public class LectureList extends JTable {
	private static final long serialVersionUID = 1L;
	// controller
	private LectureManager lectureManager;
	// data model
	private DefaultTableModel tableModel;
	// entity data
	private Vector<Lecture> lectures;
	// selected lectures
	private Vector<Lecture> selectedLectures;

	public Vector<Lecture> getSelectedLectures() {
		boolean k = false;
		for (int i=0; i<this.getRowCount(); i++) {
			if (this.isRowSelected(i)) {
				for(Lecture lecture : selectedLectures){
					if (lectures.get(i).equals(lecture)){
						k = true;
					}
				}if(!k)
					this.selectedLectures.addElement(lectures.get(i));
			}
		}
		return this.selectedLectures; 
	}
	
	public LectureList(ListSelectionHandler listSelectionHandler) {
		// controller
		this.lectureManager = new LectureManager();
		// data model
		Vector<String> header = new Vector<String>();
		header.addElement(Constants.lectureList_m);
		header.addElement(Constants.lectureList_p);
//		header.addElement("학점");
//		header.addElement("요일및시간");
		
		this.tableModel = new DefaultTableModel(header, 0);
		this.setModel(this.tableModel);
		this.selectedLectures = new Vector<Lecture>();

	}
	
	public DefaultTableModel getTableModel() { return this.tableModel; }
	
	public void initialize(){
	}
	
	public String getSelectedFileName() {
		return null;
	}
	public void showLectures(Vector<Lecture> lectures) {
		this.tableModel.setRowCount(0);
		Vector<String> rowData = null;
		this.lectures = lectures;
		for (Lecture lecture: lectures) {
			rowData = new Vector<String>();
			rowData.addElement(lecture.getName());
			rowData.addElement(lecture.getProfessorName());
//			String credit = Integer.toString(lecture.getCredit());
//			rowData.addElement(credit);
//			rowData.addElement(lecture.getTime());
			this.tableModel.addRow(rowData);
		}
		this.updateUI();	
	}

	public void showLectures(String fileName) throws FileNotFoundException {
		this.tableModel.setRowCount(0);
		if (fileName == null) {
			return;
		}
		this.lectures = this.lectureManager.getLectures(fileName);
		Vector<String> rowData = null;
		for (Lecture lecture: lectures) {
			rowData = new Vector<String>();
			rowData.addElement(lecture.getName());
			rowData.addElement(lecture.getProfessorName());
//			String credit = Integer.toString(lecture.getCredit());
//			rowData.addElement(credit);
//			rowData.addElement(lecture.getTime());
			this.tableModel.addRow(rowData);
		}
		this.updateUI();	
	}

	public void saveLectures(String FileName) throws FileNotFoundException {
		this.lectureManager.saveLecrues(FileName, this.lectures);
		System.out.println(this.lectures.size());
	}
}
