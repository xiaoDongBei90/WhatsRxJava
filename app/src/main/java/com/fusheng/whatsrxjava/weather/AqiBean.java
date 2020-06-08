package com.fusheng.whatsrxjava.weather;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 代码描述<p>
 *
 * @author xiajianbin
 * @since 2019/4/19 15:50
 */
public class AqiBean implements Parcelable {
    //后台返回------------------------------
    private String datetime;
    private UsaChnBean value;

    //不清楚------------------------------

    private String date;

    private UsaChnBean avg;

    private UsaChnBean min;

    private UsaChnBean max;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public UsaChnBean getAvg() {
        return avg;
    }

    public void setAvg(UsaChnBean avg) {
        this.avg = avg;
    }

    public UsaChnBean getMin() {
        return min;
    }

    public void setMin(UsaChnBean min) {
        this.min = min;
    }

    public UsaChnBean getMax() {
        return max;
    }

    public void setMax(UsaChnBean max) {
        this.max = max;
    }

    public AqiBean() {
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public UsaChnBean getValue() {
        return value;
    }

    public void setValue(UsaChnBean value) {
        this.value = value;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.datetime);
        dest.writeParcelable(this.value, flags);
        dest.writeString(this.date);
        dest.writeParcelable(this.avg, flags);
        dest.writeParcelable(this.min, flags);
        dest.writeParcelable(this.max, flags);
    }

    protected AqiBean(Parcel in) {
        this.datetime = in.readString();
        this.value = in.readParcelable(UsaChnBean.class.getClassLoader());
        this.date = in.readString();
        this.avg = in.readParcelable(UsaChnBean.class.getClassLoader());
        this.min = in.readParcelable(UsaChnBean.class.getClassLoader());
        this.max = in.readParcelable(UsaChnBean.class.getClassLoader());
    }

    public static final Creator<AqiBean> CREATOR = new Creator<AqiBean>() {
        @Override
        public AqiBean createFromParcel(Parcel source) {
            return new AqiBean(source);
        }

        @Override
        public AqiBean[] newArray(int size) {
            return new AqiBean[size];
        }
    };
}
