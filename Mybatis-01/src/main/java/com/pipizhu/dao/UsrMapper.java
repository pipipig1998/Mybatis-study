package com.pipizhu.dao;

import com.pipizhu.pojo.Usr;

import java.util.List;
import java.util.Map;

public interface UsrMapper {
   public List<Usr> getUsrList();
   Usr getUsrById(int id);
   int addUsr(Usr usr);
   int updateUsr(Usr usr);
   int deleteUsr(int id);

   int addUsr2(Map<String ,Object> map);

   List<Usr> getUsrLike(String value);
   ;
}
