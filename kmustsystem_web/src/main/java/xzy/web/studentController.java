package xzy.web;


//不同模块间建立依赖
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

import xzy.entity.student;

import xzy.entity.teacher;
import xzy.service.studentservice;


@Controller//指定当前类为控制层
@RequestMapping("/xzy")
public class studentController  {
    @Autowired
    private studentservice ss;
    String a;
    @RequestMapping("/login")
    public ModelAndView login  (HttpSession session,String studentNumber,String studentPassword) throws Exception{
        System.out.println(studentNumber);
        System.out.println(studentPassword);

        student s=ss.login(studentNumber,studentPassword);
        ModelAndView mv=new ModelAndView();
        if(s!=null){
            //登录成功，将user对象设置到HttpSession作用范围域中
            session.setAttribute("studentNumber",studentNumber);
            mv.addObject("s",s);
            //转发到main请求
            mv.setViewName("main");

        }else {
            //登录失败，设置失败信息，并调转到登录页面

            mv.addObject("message","登录名和密码错误，请重新输入");
            mv.setViewName("login");
        }
        return mv;
    }


    @RequestMapping("/selectone")

    public ModelAndView selectone(HttpSession session){

        //System.out.println(studentNumber);
        //student p=ss.selectone(studentNumber);
       // System.out.println(p);
        student abc= ss.selectone((String)session.getAttribute("studentNumber"));
        ModelAndView mv=new ModelAndView();


        mv.addObject("student",abc);
        mv.setViewName("student-list");
        return mv;

    }
    @RequestMapping("/findById")
    public ModelAndView findById(int id){

        //1 测试能否拿id
        System.out.println(id);

        //2,调用业务层，查询id那行数据（业务层去调用持久层中的select语句）
        student p= ss.findById(id);

        //3.调用业务层后，得到一个具有数据的实体类，测试数据是否有效
        //System.out.println(p);

        //4 使用ModelAndView绑定数据pd (作为一个实体类名)，传递给product-update.jsp

        ModelAndView mv=new ModelAndView();
        mv.addObject("wc",p);
        mv.setViewName("student-updata");

        return mv;
    }

    @RequestMapping("/updata")
    public String update(student p) throws Exception {

        //1.测一下能不能具体拿到id值
        //2.调用业务层,去查询id数据（然后在业务层中去调用持久层，去做修改语句）
        //3.修改成功之后，重定向到findAll
        System.out.println(p);
        ss.updata(p);
        return "redirect:selectone";
    }

}







