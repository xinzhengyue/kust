package xzy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xzy.dao.coursedao;
import xzy.entity.course;

import java.util.List;
@Service
public class courseserviceImpl implements  courseservice {
    @Autowired
    private coursedao dao;
    @Override
    public List<course> findAll(){
        List<course> list =  dao.findAll();
        return list;
    }


    public void save(course information) {
        dao.save(information);
    }

    public void delete(int index) {
        dao.delete(index);
    }

    public course findById(int id) {
        return dao.findById(id);
    }

    public void update(course information) {
        dao.update(information);
    }
}
