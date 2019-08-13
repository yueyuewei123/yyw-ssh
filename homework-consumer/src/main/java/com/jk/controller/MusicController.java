package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Role;
import com.jk.model.Tree;
import com.jk.model.User;
import com.jk.service.MusicService;

import com.jk.util.DataGridResult;
import com.jk.util.ExportExcel;
import com.jk.util.PageUtil;
import com.jk.util.TreeNoteUtil;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("music")
public class MusicController {

    @Reference
    private MusicService musicService;

    @Autowired
    private RedisTemplate redisTemplate;


    @RequestMapping("tologin")
    private String tologin(){
        return "login";
    }

    @RequestMapping("login")
    @ResponseBody
    public String denglu(User user, HttpServletRequest request) {
        User us =musicService.queryUser(user.getUsername());
        if (us==null) {
            return "userError";
        }
        //判断密码
        if (!us.getPassword().equals(user.getPassword())) {
                return "pwdError";
            }

        request.getSession().setAttribute("user", us);
        return "success";
    }

    @RequestMapping("getTreeAll")
    @ResponseBody
    public List<Tree> getTreeAll(HttpServletRequest request){
        List<Tree> list = new ArrayList<>();
        User user =(User) request.getSession().getAttribute("user");
        //1、定义缓存key
        String key = "tree"+user.getId();
        //2、先判断缓存中是否存在
        if (redisTemplate.hasKey(key)) {
            System.out.println("=====走缓存=======");
            //3、a 存在 ：从缓存中获取，返回list
            list = (List<Tree>) redisTemplate.opsForValue().get(key);
        }else {
            System.out.println("=====走数据库=======");
            //3、 b 不存在：
            //先从数据库查询、
            list =musicService.getTreeAll(user.getId());
            list = TreeNoteUtil.getFatherNode(list);
            //放入缓存中、返回list
            redisTemplate.opsForValue().set(key, list);
            //设置过期时间
            redisTemplate.expire(key, 1, TimeUnit.MINUTES);
        }
        return list;
    }

    @RequestMapping("queryUserList")
    @ResponseBody
    public Map<String,Object> queryUserList(Integer page, Integer rows, User user){
        Map map=new HashMap();
        map.put("start", (page-1)*rows);//起始页
        map.put("end", rows);//每页条数
        Integer count=musicService.selCount(map);
        List<User> list = musicService.queryUserList(map);
        Map<String,Object> map1=new HashMap<>();
        map1.put("total",count);
        map1.put("rows",list);
        return map1;
    }

    @RequestMapping("querytreeList")
    @ResponseBody
    public Map<String,Object> querytreeList(Integer page, Integer rows, Tree tree){
        Map map=new HashMap();
        map.put("start", (page-1)*rows);//起始页
        map.put("end", rows);//每页条数
        Integer count=musicService.seltree(map);
        List<Tree> list = musicService.querytreeList(map);
        Map<String,Object> map1=new HashMap<>();
        map1.put("total",count);
        map1.put("rows",list);
        return map1;
    }

    @RequestMapping("queryroleList")
    @ResponseBody
    public Map<String,Object> queryroleList(Integer page, Integer rows, Role role){
        Map map=new HashMap();
        map.put("start", (page-1)*rows);//起始页
        map.put("end", rows);//每页条数
        Integer count=musicService.selrole(map);
        List<Role> list = musicService.queryroleList(map);
        Map<String,Object> map1=new HashMap<>();
        map1.put("total",count);
        map1.put("rows",list);
        return map1;
    }


    @RequestMapping("getUserById")
    @ResponseBody
    public List<Role> getUserById(Integer id){
        List<Role> list = musicService.getUserById(id);
        return list;
    }

    @RequestMapping("updateUserBy")
    @ResponseBody
    public int updateUserBy(Integer[] ids,Integer id){
        int i = musicService.updateUserBy(ids,id);
        return i;
    }

    @RequestMapping("getTreeById")
    @ResponseBody
    public List<Tree> getTreeById(Integer id){
        List<Tree> list =musicService.getTreeById(id);
        list = TreeNoteUtil.getFatherNode(list);
        return list;
    }

    @RequestMapping("updateTree")
    @ResponseBody
    public String updateTree(Integer[] ids,Integer id){
        int i = musicService.updateTree(ids,id);
        if (i<1) {
            return "0";
        }
        return "1";
    }


    @RequestMapping("exportExce")
    public void exportExcel(HttpServletResponse response){
        //导出的excel的标题
        String title = "用户管理";
        //导出excel的列名
        String[] rowName = {"编号","用户名","密码"};
        //导出的excel数据
        List<Object[]>  dataList = new ArrayList<Object[]>();
        //查询的数据库的书籍信息
        List<User> list=   musicService.queryUserById();
        //循环书籍信息
        for(User user:list){
            Object[] obj =new Object[rowName.length];
            obj[0]=user.getId();
            obj[1]=user.getUsername();
            obj[2]=user.getPassword();
            dataList.add(obj);
        }
        ExportExcel exportExcel = new ExportExcel(title,rowName,dataList,response);

        try {
            exportExcel.export();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




    @RequestMapping("importExcel")
    public String importExcel(MultipartFile file, HttpServletResponse response){
        //获得上传文件上传的类型
        String contentType = file.getContentType();
        //上传文件的名称
        String fileName = file.getOriginalFilename();
        //获得文件的后缀名
        String fileType = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        //上传文件的新的路径
        //生成新的文件名称
        String filePath = "./src/main/resources/templates/fileupload/";
        //创建list集合接收excel中读取的数据
        List<User> list =new ArrayList<User>();
        try {
            uploadFile(file.getBytes(),filePath,fileName);
            FileInputStream fileInputStream = new FileInputStream(filePath+fileName);
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            //通过workbook对象获得sheet页 有可能不止一个sheet
            for(int i=0 ;i<workbook.getNumberOfSheets();i++){
                //获得里面的每一个sheet对象
                Sheet sheetAt = workbook.getSheetAt(i);
                //通过sheet对象获得每一行
                for(int j=3;j<sheetAt.getPhysicalNumberOfRows();j++){
                    //创建一个book对象接收excel的数据
                    User user=new User();
                    //获得每一行的数据
                    Row row = sheetAt.getRow(j);

                    //获得每一个单元格的数据
                    if(row.getCell(1)!=null && !"".equals(row.getCell(1))){
                        user.setUsername(this.getCellValue(row.getCell(1)));
                    }
                    if(row.getCell(2)!=null && !"".equals(row.getCell(2))){
                        user.setPassword(this.getCellValue(row.getCell(2)));
                    }

                    list.add(user);
                }
            }
            musicService.addUser(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }

    //上传文件的方法
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    //判断从Excel文件中解析出来数据的格式
    private static String getCellValue(Cell cell){
        String value = null;
        //简单的查检列类型
        switch(cell.getCellType())
        {
            case Cell.CELL_TYPE_STRING://字符串
                value = cell.getRichStringCellValue().getString();
                break;
            case Cell.CELL_TYPE_NUMERIC://数字
                long dd = (long)cell.getNumericCellValue();
                value = dd+"";
                break;
            case Cell.CELL_TYPE_BLANK:
                value = "";
                break;
            case Cell.CELL_TYPE_FORMULA:
                value = String.valueOf(cell.getCellFormula());
                break;
            case Cell.CELL_TYPE_BOOLEAN://boolean型值
                value = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_ERROR:
                value = String.valueOf(cell.getErrorCellValue());
                break;
            default:
                break;
        }
        return value;
    }

    @RequestMapping("queryLog")
    @ResponseBody
    public DataGridResult queryLog(Integer page,Integer rows){
        DataGridResult result = new DataGridResult();
        PageUtil pageUtil = musicService.queryLog(page,rows);
        result.setRows(pageUtil.getList());
        result.setTotal(pageUtil.getSumSize());
        return result;
    }










}
