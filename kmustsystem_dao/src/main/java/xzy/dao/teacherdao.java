package xzy.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import xzy.entity.*;
import xzy.entity.course;
import xzy.entity.teacher;

import java.util.List;

/**
 * @author wwx
 * @create 2020-08-31-15:46
 */
@Repository
public interface teacherdao {

    @Select("select * from teacher where teacherId=#{teacherId} AND teacherPassword=#{teacherPassword}")
    public teacher login(@Param("teacherId") String teacherId, @Param("teacherPassword") String teacherPassword);

    @Select("select * from teacher where teacherId=#{teacherId}")
    public teacher selectone(String teacherId);

    @Update("update teacher set teacherPassword=#{teacherPassword} where teacherId=#{teacherId}")
    public void  updata(teacher p);

    @Select("select * from teacher where id=#{id}")
    public teacher findById(int id);
}
