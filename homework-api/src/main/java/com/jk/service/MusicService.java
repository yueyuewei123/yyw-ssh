package com.jk.service;

import com.jk.model.Role;
import com.jk.model.Tree;
import com.jk.model.User;
import com.jk.util.PageUtil;

import java.util.List;
import java.util.Map;

public interface MusicService {
    User queryUser(String username);

    List<Tree> getTreeAll(String id);

    Integer selCount(Map map);

    List<User> queryUserList(Map map);

    Integer seltree(Map map);

    List<Tree> querytreeList(Map map);

    Integer selrole(Map map);

    List<Role> queryroleList(Map map);

    List<Role> getUserById(Integer id);

    int updateUserBy(Integer[] ids, Integer id);

    List<Tree> getTreeById(Integer id);

    int updateTree(Integer[] ids, Integer id);

    List<User> queryUserById();

    void addUser(List<User> list);

    PageUtil queryLog(Integer page, Integer rows);
}
