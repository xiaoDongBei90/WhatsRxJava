package com.fusheng.whatsrxjava;

/**
 * @author lixiaowei
 * @date:2020/4/29 15:16
 * Description: 学生课程类
 */
public class Course {
    private String name;
    private String score;

    public Course(String name, String score) {
        this.name = name;
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getScore() {
        return score;
    }
}
