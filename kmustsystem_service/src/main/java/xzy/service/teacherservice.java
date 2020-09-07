package xzy.service;

import xzy.entity.course;
import xzy.entity.student;
import xzy.entity.teacher;

import java.util.List;

/**
 * @author wwx
 * @create 2020-08-31-15:31
 */
public interface teacherservice {
    public teacher login(String teacherId, String teacherPassword);
    public teacher selectone(String teacherId);
    public void  updata(teacher p);
    public teacher findById(int id);
}

