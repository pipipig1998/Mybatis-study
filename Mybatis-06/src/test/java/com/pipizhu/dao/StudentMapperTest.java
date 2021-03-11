package com.pipizhu.dao;

import com.pipizhu.Utils.MybatisUtils;
import com.pipizhu.pojo.Student;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class StudentMapperTest {
    @Test
    public void getStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> student = mapper.getStudent();
        for (Student student1 : student) {
            System.out.println(student1);
        }
        sqlSession.close();
    }
}
