package control;

import java.io.FileNotFoundException;
import java.util.Vector;

import entity.Lecture;
import entity.LectureEntity;

public class LectureManager {
	private LectureEntity lectureEntity;
	public LectureManager() {
		this.lectureEntity = new LectureEntity();
	}
	public Vector<Lecture> getLectures(String selection) throws FileNotFoundException {
		return this.lectureEntity.readFromFile(selection);		
	}
	public void saveLecrues(String fileName, Vector<Lecture> lectures) throws FileNotFoundException {
		// TODO Auto-generated method stub
		this.lectureEntity.writeTofile(fileName, lectures);
	}
}
