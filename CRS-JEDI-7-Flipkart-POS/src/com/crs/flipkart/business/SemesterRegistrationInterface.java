package com.crs.flipkart.business;

import java.util.List;

import com.crs.flipkart.bean.Course;

public interface SemesterRegistrationInterface {

	List<Course> viewCourses();

	boolean verifyCourse(String courseId);

	String addCourse(String studentId, String courseId);

	String dropCourse(String studentId, String courseId);

	List<Course> viewOptedCourses(String studentId);

	String submitOptedCourses(String studentId);

}