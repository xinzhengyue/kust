package xzy.service;

import xzy.entity.course;

import java.util.List;

public interface courseservice {
    public List<course> findAll();
    public void save(course information);
    public  void delete(int index);
    public course findById(int id);
    public void update(course information);
}
