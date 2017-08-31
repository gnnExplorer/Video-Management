package com.zhiyou100.vm.mapper;

import com.zhiyou100.vm.model.CSVVo;
import com.zhiyou100.vm.model.Video;
import com.zhiyou100.vm.model.VideoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VideoMapper {
    int countByExample(VideoExample example);

    int deleteByExample(VideoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Video record);

    int insertSelective(Video record);

    List<Video> selectByExample(VideoExample example);

    Video selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByExample(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);

	int getTotalVideo(CSVVo csvvo);

	List<Video> getAllVideo(CSVVo csvvo);

	void multiDeleteVideo(Integer[] arr);

	List<Video> findVideosByCourseId(Integer courseId);
	
	
}