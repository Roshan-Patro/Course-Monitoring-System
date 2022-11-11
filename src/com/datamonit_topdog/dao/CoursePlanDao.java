package com.datamonit_topdog.dao;

public interface CoursePlanDao {
	public String createCoursePlan(int courseId, int batchId, int daynumber, String topic, String status);
}
