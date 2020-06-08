package com.fusheng.whatsrxjava;

/**
 * @author lixiaowei
 * @date:2020/4/29 15:16
 * Description: 学生课程类
 */
public class Course {
    private String name;
    private int score;

    public Course(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
