package xzy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xzy.dao.teacherdao;
import xzy.entity.student;
import xzy.entity.teacher;

import java.util.List;

@Service

public class teacherserviceImpl implements teacherservice {
    @Autowired
    private teacherdao dao;



    public teacher login(String teacherId, String teacherPassword) {
        // TODO Auto-generated method stub
        return dao.login(teacherId, teacherPassword);
    }
    public teacher selectone(String teacherId){
        //System.out.println(teacherId);
        return dao.selectone(teacherId);


    }
    public void  updata(teacher p){
        dao.updata(p);
    }

    public teacher findById(int id){
        //System.out.println("sb");
        return dao.findById(id);

    }
}

