package xzy.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import xzy.entity.course;
import xzy.service.courseservice;

import java.util.List;

@Controller//指定当前类为控制层
@RequestMapping("/course")
public class courseController {
    @Autowired
    private courseservice cs;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        List<course> list = cs.findAll();
        ModelAndView mv=new ModelAndView();
        mv.addObject("courseList",list);
        mv.setViewName("course-listst");
        System.out.println(list);
        return mv;
    }
    @RequestMapping("/findAlls")
    public ModelAndView findAlls(){
        List<course> list = cs.findAll();
        ModelAndView mv=new ModelAndView();
        mv.addObject("courseList",list);
        mv.setViewName("course-listte");
        System.out.println(list);
        return mv;
    }

    @RequestMapping("/save")
    public String save(course information){


        //     取得product 数据的途径？？？
        cs.save(information);
        System.out.println("success");
//        mv.setViewName("success");
//        return mv;

        return "redirect:findAlls"; //重定向,不能用ModelAndView方法
    }

    @RequestMapping("/delete")
    public String delete(int id){

        //1.测试能否拿到id ,来源于product-list 中 onclick点击删除事件
        System.out.println(id);
        //2调用业务层（业务层去调用持久层，发送delete语句）
        cs.delete(id);
        //3重定向到findAllProduct
        return "redirect:findAlls"; //重定向,用String方法
    }

    @RequestMapping("/findById")
    public ModelAndView findById(int id){

        //1 测试能否拿id
        System.out.println(id);

        //2,调用业务层，查询id那行数据（业务层去调用持久层中的select语句）
        course p= cs.findById(id);

        //3.调用业务层后，得到一个具有数据的实体类，测试数据是否有效
        System.out.println(p);

        //4 使用ModelAndView绑定数据pd (作为一个实体类名)，传递给product-update.jsp

        ModelAndView mv=new ModelAndView();
        mv.addObject("pd",p);
        mv.setViewName("course-update");

        return mv;
    }

    @RequestMapping("/update")
    public String update(course information){



        //1 测试能否拿到对应数据
        System.out.println(information);
        //2,调用业务层，修改id那行数据（业务层去调用持久层中的update语句）
        cs.update(information);

        //3.修改之后重定向
        return "redirect:findAlls";
    }


    }


