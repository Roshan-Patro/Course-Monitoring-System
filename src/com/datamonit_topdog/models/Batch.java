package com.datamonit_topdog.models;

public class Batch {
	private int batchId;
	private String batchName;
	private int courseId;
	private int facultyId;
	private int numberofStudents;
	private String batchstartDate;
	private int durationInMonths;
	
	public Batch() {
		
	}

	public Batch(int batchId, String batchName, int courseId, int facultyId, int numberofStudents,
			String batchstartDate, int durationInMonths) {
		super();
		this.batchId = batchId;
		this.batchName = batchName;
		this.courseId = courseId;
		this.facultyId = facultyId;
		this.numberofStudents = numberofStudents;
		this.batchstartDate = batchstartDate;
		this.durationInMonths = durationInMonths;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	public int getNumberofStudents() {
		return numberofStudents;
	}

	public void setNumberofStudents(int numberofStudents) {
		this.numberofStudents = numberofStudents;
	}

	public String getBatchstartDate() {
		return batchstartDate;
	}

	public void setBatchstartDate(String batchstartDate) {
		this.batchstartDate = batchstartDate;
	}

	public int getDurationInMonths() {
		return durationInMonths;
	}

	public void setDurationInMonths(int durationInMonths) {
		this.durationInMonths = durationInMonths;
	}

	@Override
	public String toString() {
		return "Batch [batchId=" + batchId + ", batchName=" + batchName + ", courseId=" + courseId + ", facultyId="
				+ facultyId + ", numberofStudents=" + numberofStudents + ", batchstartDate=" + batchstartDate
				+ ", durationInMonths=" + durationInMonths + "]";
	}
	
	

}
