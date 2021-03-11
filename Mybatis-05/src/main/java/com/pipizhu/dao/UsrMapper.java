package com.pipizhu.dao;

import com.pipizhu.pojo.Usr;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UsrMapper {
   @Select("select * from Usr")
   List<Usr> getUsr();

   //方法存在多个参数，所有参数前必须加上Param注解
   @Select("select * from usr where id=#{id}")
   Usr getUsrById(@Param("id") int id);

   @Insert("insert into Usr(id,name,pwd) values(#{id},#{name},#{pwd})")
   int addUsr(Usr usr);

   @Delete("delete from usr where id=#{id}")
   int deleteUsr(@Param("id")int id);
}
