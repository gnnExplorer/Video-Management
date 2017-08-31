package com.zhiyou100.vm.mapper;

import com.zhiyou100.vm.model.Course;
import com.zhiyou100.vm.model.CourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseMapper {
    int countByExample(CourseExample example);

    int deleteByExample(CourseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    List<Course> selectByExample(CourseExample example);

    Course selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

	int getAlltotalCount();

	List<Course> findAllCourse(@Param("page") Integer page);

	List<Course> analysisCourse();

	List<Course> findCourseWithVideos(Integer subjectId);

	Course findCourseById(Integer courseId);

}