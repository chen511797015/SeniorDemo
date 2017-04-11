package com.chen.seniordemo.bean;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by cdd on 2017/4/11 10:10
 * 描述:
 */

public class Persion implements Parcelable {

    String name;
    String age;

    protected Persion(Parcel in) {
        name = in.readString();
        age = in.readString();
    }

    public static final Creator<Persion> CREATOR = new Creator<Persion>() {
        @Override
        public Persion createFromParcel(Parcel in) {
            return new Persion(in);
        }

        @Override
        public Persion[] newArray(int size) {
            return new Persion[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(age);
    }
}
