package xzy.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import xzy.entity.student;

@Repository
public interface studentdao {
    @Select("select * from student where studentNumber=#{studentNumber} AND studentPassword=#{studentPassword}")
    public student login(@Param("studentNumber")String studentNumber, @Param("studentPassword")String studentPassword);

    @Select("select * from student where studentNumber=#{studentNumber}")
    public student selectone(String studentNumber);

    @Update("update student set studentPhone=#{studentPhone},studentAdress=#{studentAdress},studentPassword=#{studentPassword} " +
            "where studentNumber=#{studentNumber}")
    public void  updata(student p);

    @Select("select * from student where id=#{id}")
    public student findById(int id);
}
