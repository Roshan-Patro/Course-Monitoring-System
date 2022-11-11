package com.datamonit_topdog.dao;

public interface BatchDao {
	public String createBatch(String batchName, int courseId, int facultyId, int numberOfStudents, String batchStartDate, int durationInMonths);

}
