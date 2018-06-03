package proteam.com.bai_3_intent.models;

import java.io.Serializable;

public class UserSeriable implements Serializable {
    private String mName;
    private String mPass;

    public UserSeriable(String name, String pass) {
        mName = name;
        mPass = pass;
    }

    public String getmName() {
        return mName;
    }
}
