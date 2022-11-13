package com.datamonit_topdog.dao;

import java.util.List;

import com.datamonit_topdog.exceptions.BatchException;
import com.datamonit_topdog.exceptions.CoursePlanException;
import com.datamonit_topdog.exceptions.FacultyException;
import com.datamonit_topdog.models.Batch;
import com.datamonit_topdog.models.CoursePlan;

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
	
	public List<Batch> getAllBatchDetails() throws BatchException;
	
	public Batch getBatchByBatchId(int batchId) throws BatchException;
	
	public Batch getBatchByBatchName(String batchName) throws BatchException;
	
	public List<Batch> getAllBatchesOfACourse(int courseId) throws BatchException;
	
	public List<String> getAllFacultiesOfABatch(int batchid) throws BatchException;
	
	public List<String> getAllBatchesNamesOfAFaculty(int facultyId) throws BatchException;
	
	public List<Integer> getAllBatchesIdsOfAFaculty(int facultyId) throws BatchException;
	
	public List<String> getDaywiseUpdateOfEveryBatch(int dayNumber) throws BatchException,FacultyException,CoursePlanException;
//	
//	public List<CoursePlan> dayWiseUpdateOfEveryBatch() throws CoursePlanException;
}
