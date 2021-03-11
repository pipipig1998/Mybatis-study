package com.pipizhu.dao;

import com.pipizhu.Utils.MybatisUtils;
import com.pipizhu.pojo.Teacher;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TeacherMapperTest {
    @Test
    public void getTeacher()
    {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper sqlSessionMapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = sqlSessionMapper.getTeacher(1);
        System.out.println(teacher);
        sqlSession.close();
    }
}
