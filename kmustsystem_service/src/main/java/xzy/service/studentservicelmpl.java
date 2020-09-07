package xzy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xzy.dao.studentdao;
import xzy.entity.student;
@Service
public class studentservicelmpl implements  studentservice{
    @Autowired

    private studentdao dao;

    public student login(String studentNumber, String studentPassword) {
        // TODO Auto-generated method stub
        return dao.login(studentNumber,studentPassword);
    }

    public student selectone(String studentNumber){
        System.out.println(studentNumber);
        return dao.selectone(studentNumber);

    }
    public void  updata(student p){
        dao.updata(p);
    }
    public student findById(int id){
        return dao.findById(id);
    }
}
