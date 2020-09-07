package xzy.service;

import org.springframework.web.servlet.ModelAndView;
import xzy.entity.student;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import xzy.entity.student;
import xzy.entity.teacher;

import java.util.List;

public interface studentservice {
    public student login(String studentNumber, String studentPassword);
    public student selectone(String studentNumber);
    public void  updata(student p);
    public student findById(int id);

}
