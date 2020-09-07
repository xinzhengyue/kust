package xzy.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import xzy.entity.course;
import xzy.entity.student;
import xzy.entity.teacher;
import xzy.service.teacherservice;

import javax.servlet.http.HttpSession;

/**
 * @author wwx
 * @create 2020-08-31-15:29
 */

@Controller//指定当前类为控制层
@RequestMapping("/wwx")

public class teacherController {

    @Autowired

    private teacherservice Ps;

    @RequestMapping("/login")
    public ModelAndView login  (HttpSession session,String teacherId,String teacherPassword) throws Exception{
        System.out.println(teacherId);
        System.out.println(teacherPassword);
        teacher s=Ps.login(teacherId,teacherPassword);
        ModelAndView mv=new ModelAndView();
        if(s!=null){
            //登录成功，将user对象设置到HttpSession作用范围域中
            session.setAttribute("teacherId",teacherId);
            mv.addObject("s",s);
            //转发到main请求
            mv.setViewName("mainte");
        }else {
            //登录失败，设置失败信息，并调转到登录页面

            mv.addObject("message","登录名和密码错误，请重新输入");
            mv.setViewName("loginte");
        }
        return mv;
    }

    @RequestMapping("/selectone")

    public ModelAndView selectone(HttpSession session){


        //student p=ss.selectone(studentNumber);
        // System.out.println(p);
        teacher abc= Ps.selectone((String)session.getAttribute("teacherId"));
        ModelAndView mv=new ModelAndView();
        //System.out.println(abc);
        mv.addObject("teacher",abc);
        mv.setViewName("teacher-list");
        return mv;

    }
    @RequestMapping("/findById")
    public ModelAndView findById(int id){

        //1 测试能否拿id
        System.out.println(id);

        //2,调用业务层，查询id那行数据（业务层去调用持久层中的select语句）
        teacher p= Ps.findById(id);

        //3.调用业务层后，得到一个具有数据的实体类，测试数据是否有效
        //System.out.println(p);

        //4 使用ModelAndView绑定数据pd (作为一个实体类名)，传递给product-update.jsp

        ModelAndView mv=new ModelAndView();
        mv.addObject("wc",p);
        mv.setViewName("teacher-updata");

        return mv;
    }





    @RequestMapping("/updata")
    public String update(teacher p) throws Exception {

        //1.测一下能不能具体拿到id值
        //2.调用业务层,去查询id数据（然后在业务层中去调用持久层，去做修改语句）
        //3.修改成功之后，重定向到findAll
        System.out.println(p);
        Ps.updata(p);
        return "redirect:selectone";
    }



}
