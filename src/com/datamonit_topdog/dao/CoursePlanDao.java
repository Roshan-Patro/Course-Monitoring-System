package com.datamonit_topdog.dao;

public interface CoursePlanDao {
	public String createCoursePlan(int courseId, int batchId, int daynumber, String topic, String status);
	
	public String updateCourseIdUsingPlanId(int planId, int courseId);
	
	public String updateBatchIdUsingPlanId(int planId, int batchId);
	
	public String updateDayNumberUsingPlanId(int planId, int dayNumber);
	
	public String updateTopicUsingPlanId(int planId, String newTopic);
	
	public String updateStatusUsingPlanId(int planId, String newStatus);
}