package com.fusheng.whatsrxjava.weather;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 代码描述<p>
 *
 * @author xiajianbin
 * @since 2019/4/19 15:51
 */
public class UsaChnBean implements Parcelable {

    private double usa;
    private double chn;

    @Override
    public int describeContents() {
        return 0;
    }

    public double getUsa() {
        return usa;
    }

    public void setUsa(double usa) {
        this.usa = usa;
    }

    public double getChn() {
        return chn;
    }

    public void setChn(double chn) {
        this.chn = chn;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(this.usa);
        dest.writeDouble(this.chn);
    }

    public UsaChnBean() {
    }

    protected UsaChnBean(Parcel in) {
        this.usa = in.readDouble();
        this.chn = in.readDouble();
    }

    public static final Creator<UsaChnBean> CREATOR = new Creator<UsaChnBean>() {
        @Override
        public UsaChnBean createFromParcel(Parcel source) {
            return new UsaChnBean(source);
        }

        @Override
        public UsaChnBean[] newArray(int size) {
            return new UsaChnBean[size];
        }
    };
}
