package com.jk.controller;

import com.jk.model.Bok;
import com.jk.service.BookService;
import com.jk.util.ExportExcel;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("toshow")
    private String toshow(){
        return "show";
    }

    @RequestMapping("queryBook")
    @ResponseBody
    public List<Bok> queryBook(){
        List<Bok> list = bookService.queryBook();
        return list;
    }

    @RequestMapping("queryBookList")
    @ResponseBody
    public Map<String,Object> queryBookList(Integer page, Integer rows, Bok bok){
        Map map=new HashMap();
        map.put("start", (page-1)*rows);//起始页
        map.put("end", rows);//每页条数
        Integer count=bookService.selCount(map);
        List<Bok> list = bookService.queryBookList(map);
        Map<String,Object> map1=new HashMap<>();
        map1.put("total",count);
        map1.put("rows",list);
        return map1;
    }




    @RequestMapping("exportExce")
    public void exportExcel(HttpServletResponse response){
        //导出的excel的标题
        String title = "1902B书籍管理";
        //导出excel的列名
        String[] rowName = {"编号","名称","价格","类型","作者"};
        //导出的excel数据
        List<Object[]>  dataList = new ArrayList<Object[]>();
        //查询的数据库的书籍信息
        List<Bok> list=   bookService.queryBook();
        //循环书籍信息
        for(Bok bok:list){
            Object[] obj =new Object[rowName.length];
            obj[0]=bok.getId();
            obj[1]=bok.getName();
            obj[2]=bok.getPrice();
            obj[3]=bok.getBookType();
            obj[4]=bok.getAuthor();
            dataList.add(obj);
        }
        ExportExcel exportExcel = new ExportExcel(title,rowName,dataList,response);
        try {
            exportExcel.export();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    @RequestMapping("exportExcel")
    public void exportExcel(HttpServletResponse response,String ids){
        //导出的excel的标题
        String title = "图书管理系统";
        //导出excel的列名
        //String[] rowName = {"序号","音乐名称","歌手","上架日期","价格"};
        String[] rowName = ids.split(",");
        List<Object[]>  dataList = new ArrayList<Object[]>();
        //查询的数据库的书籍信息
        List<Bok> list = bookService.queryBook();
        //循环信息
        for(Bok bok:list){
            int temp = 1;
            Object[] obj =new Object[rowName.length];
            if (ids.contains("id")){
                obj[0]=bok.getId();

            }
            if (ids.contains("name")){
                obj[temp]=bok.getName();
                temp++;
            }
            if (ids.contains("author")){
                obj[temp]=bok.getAuthor();
                temp++;
            }
            if (ids.contains("price")){
                obj[temp]=bok.getPrice();
                temp++;
            }
            if (ids.contains("bookType")){
                obj[temp]=bok.getBookType();
            }
            dataList.add(obj);
            ExportExcel exportExcel = new ExportExcel(title,rowName,dataList,response);

            try {
                exportExcel.export();
            } catch (Exception e) {
                e.printStackTrace();
            }

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
        List<Bok> list =new ArrayList<Bok>();
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
                    Bok book=new Bok();
                    //获得每一行的数据
                    Row row = sheetAt.getRow(j);

                    //获得每一个单元格的数据
                    if(row.getCell(1)!=null && !"".equals(row.getCell(1))){
                        book.setName(this.getCellValue(row.getCell(1)));
                    }
                    if(row.getCell(2)!=null && !"".equals(row.getCell(2))){
                        book.setPrice(Integer.parseInt(this.getCellValue(row.getCell(2))));
                    }
                    if(row.getCell(3)!=null && !"".equals(row.getCell(3))){
                        book.setBookType(this.getCellValue(row.getCell(3)));
                    }
                    if(row.getCell(4)!=null && !"".equals(row.getCell(4))){
                        book.setAuthor(this.getCellValue(row.getCell(4)));
                    }

                    list.add(book);
                }
            }
            bookService.addBook(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "show";
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





}
