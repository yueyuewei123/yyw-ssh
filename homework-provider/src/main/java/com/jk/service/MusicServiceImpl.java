package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.MusicDao;
import com.jk.model.*;
import com.jk.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.Map;


@Service
public class MusicServiceImpl implements MusicService {

    @Autowired
    private MusicDao musicDao;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public User queryUser(String username) {
        return musicDao.queryUser(username);
    }

    @Override
    public List<Tree> getTreeAll(String id) {
        return musicDao.getTreeAll(id);
    }

    @Override
    public Integer selCount(Map map) {
        return musicDao.selCount(map);
    }

    @Override
    public List<User> queryUserList(Map map) {
        return musicDao.queryUserList(map);
    }

    @Override
    public Integer seltree(Map map) {
        return  musicDao.seltree(map);
    }

    @Override
    public List<Tree> querytreeList(Map map) {
        return  musicDao.querytreeList(map);
    }

    @Override
    public Integer selrole(Map map) {
        return  musicDao.selrole(map);
    }

    @Override
    public List<Role> queryroleList(Map map) {
        return  musicDao.queryroleList(map);
    }

    @Override
    public List<Role> getUserById(Integer id) {
        List<Integer> list = musicDao.getUserById(id);
        List<Role> listtwo = musicDao.getUserAll();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < listtwo.size(); j++) {
                if (list.get(i).equals(listtwo.get(j).getId())) {
                    listtwo.get(j).setChecked("true");
                }
            }
        }
        return listtwo;
    }

    @Override
    public int updateUserBy(Integer[] ids, Integer id) {
        int i = musicDao.delectUserById(id);
        if(i>0){
            for(int j=0;j<ids.length;j++){
                UserRole userRole = new UserRole();
                userRole.setRoleid(ids[j]);
                userRole.setUserid(id);
                i=musicDao.insertUser(userRole);
            }
        }
        return i;
    }

    @Override
    public List<Tree> getTreeById(Integer id) {
        List<String> list = musicDao.getTreeById(id);
        List<Tree> listTwo = musicDao.getTreeAllBy();
        for(int i=0;i<list.size();i++){
            for(int j=0;j<listTwo.size();j++){
                if (list.get(i).equals(listTwo.get(j).getId().toString())) {
                    listTwo.get(j).setChecked("l");
                }
            }
        }
        return listTwo;
    }

    @Override
    public int updateTree(Integer[] ids, Integer id) {
        int i = musicDao.deleteTree(id);
        if (i>=0) {
            for (int j = 0; j < ids.length; j++) {
                RoleTree re = new RoleTree();
                re.setTreeid(ids[j]);
                re.setRoleid(id);
                i=musicDao.insertRole(re);
            }
        }
        return i;
    }

    @Override
    public List<User> queryUserById() {
        return musicDao.queryUserById();
    }

    @Override
    public void addUser(List<User> list) {
        musicDao.addUser(list);
    }

    @Override
    public PageUtil queryLog(Integer page, Integer rows) {
        Query query = new Query();
        long sumSize = mongoTemplate.count(query,Log.class,"log");
        PageUtil pageUtil = new PageUtil((int) sumSize,page,rows);
        Integer skip = pageUtil.getFirstResultCount();
        query.skip(skip);
        query.limit(rows);
        List<Log> list = mongoTemplate.find(query,Log.class,"log");
        pageUtil.setList(list);
        return pageUtil;
    }
}
