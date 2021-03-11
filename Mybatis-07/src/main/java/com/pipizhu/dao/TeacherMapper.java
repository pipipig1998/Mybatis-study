package com.pipizhu.dao;

import com.pipizhu.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {

//    public List<Teacher> getTeacher();

    Teacher getTeacher(@Param("tid") int id);
}
