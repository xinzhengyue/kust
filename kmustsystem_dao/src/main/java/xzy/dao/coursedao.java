package xzy.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import xzy.entity.course;

import java.util.List;

public interface coursedao {
    @Select("select * from course")
    public List<course> findAll();

    @Insert("insert into course(courseNumber,courseName,courseCredit,courseTime,courseSite) values(#{courseNumber},#{courseName},#{courseCredit},#{courseTime},#{courseSite})")
    public void save(course information);

    @Delete("delete from course where id=#{index}")
    public  void delete(int index);

    @Select("select * from course where id=#{id}")
    public course findById(int id);


    @Update("update course set courseName=#{courseName}, courseCredit=#{courseCredit}, courseTime=#{courseTime}, courseSite=#{courseSite} where courseNumber=#{courseNumber}")
    public void update(course information);
}
