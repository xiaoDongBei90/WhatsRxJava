package com.fusheng.whatsrxjava.weather;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 温度<p>
 *
 * @author xiajianbin
 * @since 2019/4/15 14:09
 */
public class TemperatureBean implements Parcelable {

//    	"date": "2019-04-15",
//                "max": 22.0,
//                "avg": 20.31,
//                "min": 18.0

    private String date;
    private String datetime;

    private double value;
    private double max;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    private double avg;

    private double min;

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }


    public TemperatureBean() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.date);
        dest.writeString(this.datetime);
        dest.writeDouble(this.value);
        dest.writeDouble(this.max);
        dest.writeDouble(this.avg);
        dest.writeDouble(this.min);
    }

    protected TemperatureBean(Parcel in) {
        this.date = in.readString();
        this.datetime = in.readString();
        this.value = in.readDouble();
        this.max = in.readDouble();
        this.avg = in.readDouble();
        this.min = in.readDouble();
    }

    public static final Creator<TemperatureBean> CREATOR = new Creator<TemperatureBean>() {
        @Override
        public TemperatureBean createFromParcel(Parcel source) {
            return new TemperatureBean(source);
        }

        @Override
        public TemperatureBean[] newArray(int size) {
            return new TemperatureBean[size];
        }
    };
}
