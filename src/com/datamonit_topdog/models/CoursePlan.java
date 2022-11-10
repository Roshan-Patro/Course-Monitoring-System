package com.datamonit_topdog.models;

public class CoursePlan {
	private int planId;
	private int courseId;
	private int batchId;
	private int daynumber;
	private String topic;
	private String status;
	
	public CoursePlan() {
		
	}

	public CoursePlan(int planId, int courseId, int batchId, int daynumber, String topic, String status) {
		super();
		this.planId = planId;
		this.courseId = courseId;
		this.batchId = batchId;
		this.daynumber = daynumber;
		this.topic = topic;
		this.status = status;
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public int getDaynumber() {
		return daynumber;
	}

	public void setDaynumber(int daynumber) {
		this.daynumber = daynumber;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CoursePlan [planId=" + planId + ", courseId=" + courseId + ", batchId=" + batchId + ", daynumber="
				+ daynumber + ", topic=" + topic + ", status=" + status + "]";
	}

}
