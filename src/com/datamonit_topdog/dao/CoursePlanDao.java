package com.datamonit_topdog.dao;

import java.util.List;

import com.datamonit_topdog.exceptions.CoursePlanException;
import com.datamonit_topdog.models.CoursePlan;

public interface CoursePlanDao {
	public String createCoursePlan(int courseId, int batchId, int daynumber, String topic, String status);
	
	public String updateCourseIdUsingPlanId(int planId, int courseId);
	
	public String updateBatchIdUsingPlanId(int planId, int batchId);
	
	public String updateDayNumberUsingPlanId(int planId, int dayNumber);
	
	public String updateTopicUsingPlanId(int planId, String newTopic);
	
	public String updateStatusUsingPlanId(int planId, String newStatus);
	
	public List<CoursePlan> getAllCoursePlanDetails() throws CoursePlanException;
	
	public List<CoursePlan> getAllCoursePlansOfACourse(int courseid) throws CoursePlanException;
	
	public CoursePlan getACoursePlanByPlanId(int planId) throws CoursePlanException;
	
	public List<CoursePlan> getAllCoursePlansByStatus(String status) throws CoursePlanException;
}