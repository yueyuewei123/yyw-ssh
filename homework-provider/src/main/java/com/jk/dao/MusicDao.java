package com.jk.dao;

import com.jk.model.*;

import java.util.List;
import java.util.Map;

public interface MusicDao {

    User queryUser(String username);

    List<Tree> getTreeAll(String id);

    Integer selCount(Map map);

    List<User> queryUserList(Map map);

    Integer seltree(Map map);

    List<Tree> querytreeList(Map map);

    Integer selrole(Map map);

    List<Role> queryroleList(Map map);

    List<Role> getUserAll();

    List<Integer> getUserById(Integer id);

    int delectUserById(Integer id);

    int insertUser(UserRole userRole);

    List<Tree> getTreeAllBy();

    List<String> getTreeById(Integer id);

    int deleteTree(Integer id);

    int insertRole(RoleTree re);

    List<User> queryUserById();

    void addUser(List<User> list);
}
