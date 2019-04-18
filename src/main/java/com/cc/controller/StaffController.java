package com.cc.controller;

import com.cc.common.JsonBean;
import com.cc.common.JsonLayBean;
import com.cc.entity.Staff;
import com.cc.service.StaffService;
import com.cc.utils.ImportExcel;
import com.cc.utils.JsonUtils;
import com.cc.vo.VStaff;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller

public class StaffController {
    @Autowired
    private StaffService staffService;

    @InitBinder
    protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }


    @RequestMapping("/staff/staffpage.do")
    @ResponseBody
    public JsonLayBean listAll(int page, int limit) {

        List<VStaff> list = staffService.selectAllByPage((page - 1) * limit, limit);

        List<VStaff> list1 = staffService.listAll();
        return JsonUtils.createJsonBean(0, "", list1.size(), list);
    }

    @RequestMapping("/staff/staffdelete.do")
    @ResponseBody
    public JsonLayBean listAll(String no) {

        staffService.deleteByNo(no);
        return JsonUtils.createJsonBean(1, "", 0, null);
    }

    @RequestMapping("/staff/update.do")
    @ResponseBody
    public JsonLayBean update(Staff staff, String date) {
        SimpleDateFormat adf = new SimpleDateFormat("yyyy-MM-dd");
        Date createdate = null;
        try {
            Date newdate = adf.parse(date);
            createdate = newdate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        staff.setCreatedate(createdate);
        staffService.update(staff);
        return JsonUtils.createJsonBean(1, "", 0, null);
    }


    @RequestMapping("/staff/photoupload.do")
    @ResponseBody
    public JsonLayBean upload(@RequestParam("file") MultipartFile upFile, HttpServletRequest request) {

        // 获取上传文件的文件名
        String fileName = upFile.getOriginalFilename();

        String path = request.getServletContext().getRealPath("/");
        System.out.println(path);
        File parentPath = new File(path);
        // 获取父级目录的路径
        path = parentPath.getParent() + "/webapp/images";

        System.out.println("path == " + path);
        File dirPath = new File(path);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
        //upfile.getInputStream()
        File file = new File(path, fileName);
        try {
            // 保存文件
            upFile.transferTo(file);
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return JsonUtils.createJsonBean(1, fileName, 0, fileName);
    }


//    public Object uploadModel(HttpServletRequest request, HttpServletResponse response) {
//
//        //创建文件上传的工厂类对象
//        FileItemFactory factory = new DiskFileItemFactory();
//        //根据工厂类对象创建ServletFileUpload对象
//        ServletFileUpload upload = new ServletFileUpload(factory);
//
//        //解决文件名的中文乱码问题
//        upload.setHeaderEncoding("utf-8");
//
//        //判断表单的类型是否是multpart/form-data
//        if (ServletFileUpload.isMultipartContent(request)) {
//
//            try {
//                //将请求参数转换为FileItem对象的集合
//                List<FileItem> items = (List<FileItem>) upload.parseRequest(request);
//                for (FileItem fileItem : items) {
//                    //判断是否是普通的表单控件数据
//                    if (fileItem.isFormField()) {
//                        //得到表单中name属性的值
//                        System.out.println(fileItem.getFieldName());
//                        //得到表单参数的值
//                        //指定编码方式，解决提交数据的中文乱码
//                        System.out.println(fileItem.getString("utf-8"));
//                    } else {
//                        System.out.println(fileItem.getFieldName());
//                        //得到文件名
//                        System.out.println(fileItem.getName());
//                        String path = request.getServletContext().getRealPath("/");
//                        System.out.println(path);
//                        File parentPath = new File(path);
//
//                         path = parentPath.getParent() +"/webapp/images";
//                        File dir = new File(path);
//                        //如果文件夹不存在，创建
//                        if (!dir.exists()) {
//                            dir.mkdir();
//                        }
//                        String name = fileItem.getName();
//
//                        Date date = new Date();
//                        long time = date.getTime();
//                        //得到文件的名称和后缀
//                        String fileName = name.substring(0, name.lastIndexOf("."));
//                        String ext = name.substring(name.lastIndexOf(".") + 1);
//                        name = fileName + "_" + time + "." + ext;
//                        //创建上传文件的File对象
//                        File file = new File(path, name);
//                        //保存文件
//                        fileItem.write(file);
//                        //删除临时文件
//                        fileItem.delete();
//
//
//                        return JsonUtils.createJsonBean(1,file.getName(),0,null);
//                    }
//
//                }
//
//
//            } catch (FileUploadException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            } catch (Exception e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//
//        }
//        return JsonUtils.createJsonBean(0,"",0,null);
//
//
//    }

    @RequestMapping("/staff/staffno.do")
    @ResponseBody
    public JsonLayBean getNo(){
        String no = staffService.getLastNo();
        System.out.println(no);


        String num=no.substring(2);// no.substring(2)去掉前两个字符
        System.out.println(num);
        int num1=Integer.parseInt(num);

        num1++;
        String str = String.format("%06d", num1);//如果小于6位左边补0
        System.out.println(str);

        String ret=no.substring(0,2)+str;
        System.out.println(ret);

        return JsonUtils.createJsonBean(1,ret,0,ret);


    }


    @RequestMapping("/staff/staffadd.do")
    public String addStaff(Staff staff){

        staff.setFlag(1);
        staffService.addStaff(staff);
        return "redirect:/oa_staff/stafflist.html";

    }

    @RequestMapping("/staff/import.do")
    @ResponseBody
    public JsonBean importExcel(@RequestParam MultipartFile mFile){


        try {
            String fileName = mFile.getOriginalFilename();
            // 获取上传文件的输入流
            InputStream inputStream = mFile.getInputStream();
            // 调用工具类中方法，读取excel文件中数据
            List<Map<String, Object>> sourceList = ImportExcel.readExcel(fileName, inputStream);

            // 将对象先转为json格式字符串，然后再转为List<SysUser> 对象
            ObjectMapper objMapper = new ObjectMapper();
            String infos = objMapper.writeValueAsString(sourceList);

            // json字符串转对象
            List<Staff> list = objMapper.readValue(infos, new TypeReference<List<Staff>>() {});

            // 批量添加
            staffService.addStaffBatch(list);

            return JsonUtils.createJsonBean(1, null);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

            return JsonUtils.createJsonBean(0, e.getMessage());
        }

    }

}
