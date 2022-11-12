package com.datamonit_topdog.dao;

public interface BatchDao {
	public String createBatch(String batchName, int courseId, int facultyId, int numberOfStudents, String batchStartDate, int durationInMonths);
	
	public String updateBatchNameUsingBatchId(int batchId,String batchName);
	
	public String updateBatchNameUsingBatchName(String BatchName,String newBatchName);
	
	public String updateFacultyIdUsingBatchId(int batchId,int facultyId);
	
	public String updateFacultyIdUsingBatchName(String batchName,int facultyId);
	
	public String updateNumberOfStudentsUsingBatchId(int batchId,int numberOfStudents);
	
	public String updateNumberOfStudentsUsingBatchName(String batchName,int numberOfStudents);
	
	public String updateBatchStartDateUsingBatchId(int batchId,String batchStartDate);
	
	public String updateBatchStartDateUsingBatchName(String batchName,String batchStartDate);
	
	public String updateDurationInMonthsUsingBatchId(int batchId,int durationInMonths);
	
	public String updateDurationInMonthsUsingBatchName(String batchName,int durationInMonths);
}
