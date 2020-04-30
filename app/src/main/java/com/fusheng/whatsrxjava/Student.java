package com.fusheng.whatsrxjava;

import java.util.List;

/**
 * @author lixiaowei
 * @date:2020/4/29 15:15
 * Description:学生类
 */
public class Student {
    private String name;
    private List<Course> courseList;

    public Student(String name, List<Course> courseList) {
        this.name = name;
        this.courseList = courseList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<Course> getCourseList() {
        return courseList;
    }
}
