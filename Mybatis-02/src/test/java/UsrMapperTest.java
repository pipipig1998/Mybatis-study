import com.pipizhu.dao.UsrMapper;
import com.pipizhu.pojo.Usr;
import com.pipizhu.mybatisUtils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsrMapperTest {

    @Test
    public void getUsrById(){

        SqlSession sqlSession=MybatisUtils.getSqlSession();
        UsrMapper mapper = sqlSession.getMapper(UsrMapper.class);
        Usr usr=mapper.getUsrById(2);
        System.out.println(usr.getName());
        sqlSession.close();
    }
    @Test
    public void addUsr(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsrMapper usrMapper = sqlSession.getMapper(UsrMapper.class);
        int num=usrMapper.addUsr(new Usr(5,"小明","666666"));
        System.out.println(num);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void updateUsr(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsrMapper usrMapper = sqlSession.getMapper(UsrMapper.class);
        usrMapper.updateUsr(new Usr(1,"李武","password"));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUsr(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsrMapper usrMapper = sqlSession.getMapper(UsrMapper.class);
        usrMapper.deleteUsr(4);
        sqlSession.commit();
        sqlSession.close();
    }


}
