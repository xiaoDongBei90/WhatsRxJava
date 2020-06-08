package com.fusheng.whatsrxjava.weather;

import android.os.Parcel;

import java.util.ArrayList;
import java.util.Date;

/**
 * 代码描述<p>
 *
 * @author xiajianbin
 * @since 2019/4/16 19:27
 */
public class DayWeatherBean  {
    public DayWeatherBean() {
    }
    private ArrayList<BriefDetailsBean> list;
    /**
     * 15天天气中的每天的日期，格式：MM月dd日
     */
    private String date;
    /**
     * 15天天气中的每天的日期，格式： yyyy-MM-dd HH:mm
     */
    private Date localDate;
    private int intTemp;
    private double temperature;
    private double aqi;
    private String status;
    /**
     * yyyy-MM-dd HH:mm
     */
    private String dateTime;

    private String value;

    /**
     * 昨天、今天、明天、后天、周一、周二、、、
     */
    private String dateInfo;
    /**
     * (后台)平均湿度
     */
    private double humidity;

    /**
     * (后台)平均温度
     */
    private int temperatureAvg;
    /**
     * (后台)最高温度
     */
    private int temperatureMax;
    /**
     * (后台)最低温度
     */
    private int temperatureMin;

    /**
     * (后台)天气状况，示例：CLOUDY
     */
    private String skycon;
    /**
     * 天气状况，根据skycon本地转化的，示例：晴
     */
    private String skyEn;
    /**
     * 白天天气状况
     */
    private String skycoDay;
    /**
     * 白天天气状况，示例：晴
     */
    private String skyEnDay;
    /**
     * 夜间天气状况
     */
    private String skycoNight;
    /**
     * 夜间天气状况，示例：晴
     */
    private String skyEnNight;

    /**
     * 天气图标，根据skycon本地转化的
     */
    private int weatherImg;

    public String getSkycoDay() {
        return skycoDay;
    }

    public String getSkyEnDay() {
        return skyEnDay;
    }

    public String getSkycoNight() {
        return skycoNight;
    }

    public String getSkyEnNight() {
        return skyEnNight;
    }

    public void setSkycoDay(String skycoDay) {
        this.skycoDay = skycoDay;
    }

    public void setSkyEnDay(String skyEnDay) {
        this.skyEnDay = skyEnDay;
    }

    public void setSkycoNight(String skycoNight) {
        this.skycoNight = skycoNight;
    }

    public void setSkyEnNight(String skyEnNight) {
        this.skyEnNight = skyEnNight;
    }

    public String getSkyEn() {
        return skyEn;
    }

    public void setSkyEn(String skyEn) {
        this.skyEn = skyEn;
    }

    public Date getLocalDate() {
        return localDate;
    }

    public void setLocalDate(Date localDate) {
        this.localDate = localDate;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getIntTemp() {
        return intTemp;
    }

    public void setIntTemp(int intTemp) {
        this.intTemp = intTemp;
    }


    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateInfo() {
        return dateInfo;
    }

    public void setDateInfo(String dateInfo) {
        this.dateInfo = dateInfo;
    }

    public String getSkycon() {
        return skycon;
    }

    public void setSkycon(String skycon) {
        this.skycon = skycon;
    }

    public int getWeatherImg() {
        return weatherImg;
    }

    public void setWeatherImg(int weatherImg) {
        this.weatherImg = weatherImg;
    }

    public int getTemperatureAvg() {
        return temperatureAvg;
    }

    public void setTemperatureAvg(int temperatureAvg) {
        this.temperatureAvg = temperatureAvg;
    }

    public int getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(int temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public int getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(int temperatureMin) {
        this.temperatureMin = temperatureMin;
    }


    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getAqi() {
        return aqi;
    }

    public void setAqi(double aqi) {
        this.aqi = aqi;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<BriefDetailsBean> getList() {
        return list;
    }

    public void setList(ArrayList<BriefDetailsBean> list) {
        this.list = list;
    }
}
