package com.example.navigation;

import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;

public class Money implements Parcelable {
    BigDecimal amount;

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString(){
        return String.valueOf(getAmount());
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(this.amount);
    }

    protected Money(Parcel in) {
        this.amount = (BigDecimal) in.readSerializable();
    }

    public static final Parcelable.Creator<Money> CREATOR = new Parcelable.Creator<Money>() {
        @Override
        public Money createFromParcel(Parcel source) {
            return new Money(source);
        }

        @Override
        public Money[] newArray(int size) {
            return new Money[size];
        }
    };
}
