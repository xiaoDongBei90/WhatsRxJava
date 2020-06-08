package com.fusheng.whatsrxjava.weather;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 代码描述<p>
 *
 * @author xiajianbin
 * @since 2019/5/6 11:02
 */
public class BriefDetailsBean implements Parcelable {
    private String brief;
    private String details;
    private int type = 0;//  穿衣指数 为1  其他为0
    private int iconDrawable;
    private String desciption;

    public BriefDetailsBean() {
    }

    public BriefDetailsBean(String brief, String details, String desciption, int iconDrawable) {
        this.brief = brief;
        this.details = details;
        this.desciption = desciption;
        this.iconDrawable = iconDrawable;
    }

    public BriefDetailsBean(String brief, String details, String desciption, int iconDrawable, int type) {
        this.brief = brief;
        this.details = details;
        this.desciption = desciption;
        this.iconDrawable = iconDrawable;
        this.type = type;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }


    public int getIconDrawable() {
        return iconDrawable;
    }

    public void setIconDrawable(int iconDrawable) {
        this.iconDrawable = iconDrawable;
    }

    public String getDesciption() {
        return desciption;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.type);
        dest.writeInt(this.iconDrawable);
        dest.writeString(this.brief);
        dest.writeString(this.details);
        dest.writeString(this.desciption);
    }

    protected BriefDetailsBean(Parcel in) {
        this.type = in.readInt();
        this.iconDrawable = in.readInt();
        this.brief = in.readString();
        this.details = in.readString();
        this.desciption = in.readString();
    }

    public static final Creator<BriefDetailsBean> CREATOR = new Creator<BriefDetailsBean>() {
        @Override
        public BriefDetailsBean createFromParcel(Parcel source) {
            return new BriefDetailsBean(source);
        }

        @Override
        public BriefDetailsBean[] newArray(int size) {
            return new BriefDetailsBean[size];
        }
    };
}
