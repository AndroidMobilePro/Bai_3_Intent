package proteam.com.bai_3_intent.models;

import android.os.Parcel;
import android.os.Parcelable;
public class UserPacer implements Parcelable{
    private String mName;
    private String mPass;

    public UserPacer(String name, String pass) {
        mName = name;
        mPass = pass;
    }

    protected UserPacer(Parcel in) {
        mName = in.readString();
        mPass = in.readString();
    }

    public static final Creator<UserPacer> CREATOR = new Creator<UserPacer>() {
        @Override
        public UserPacer createFromParcel(Parcel in) {
            return new UserPacer(in);
        }

        @Override
        public UserPacer[] newArray(int size) {
            return new UserPacer[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(mPass);
    }

    public String getmName() {
        return mName;
    }
}
