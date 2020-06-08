package com.fusheng.whatsrxjava.weather;

import java.util.List;

/**
 * 代码描述<p>15天天气、72小时天气Bean
 *
 * @author xiajianbin
 * @since 2019/4/15 9:38
 */

public class Day15WeatherBean {
    public Day15WeatherBean() {
    }

    private List<TemperatureBean> temperature;
    private List<AqiBean> aqi;

    public List<AqiBean> getAqi() {
        return aqi;
    }

    public void setAqi(List<AqiBean> aqi) {
        this.aqi = aqi;
    }

    public List<TemperatureBean> getTemperature() {
        return temperature;
    }

    public void setTemperature(List<TemperatureBean> temperature) {
        this.temperature = temperature;
    }
}