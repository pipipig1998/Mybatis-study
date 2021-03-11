import com.pipizhu.Utils.MybatisUtils;
import com.pipizhu.dao.TeacherMapper;
import com.pipizhu.pojo.Student;
import com.pipizhu.pojo.Teacher;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);

        sqlSession.close();
    }

}
