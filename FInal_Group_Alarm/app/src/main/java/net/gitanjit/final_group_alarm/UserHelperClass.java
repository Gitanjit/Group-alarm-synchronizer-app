package net.gitanjit.final_group_alarm;

public class UserHelperClass {
String mFullName,mEmail,mPassword,mPhone,userID;

    public UserHelperClass() {
    }

    public UserHelperClass(String mFullName,String mEmail,String mPassword,String mPhone,String userID) {
        this.mFullName = mFullName;
        this.mEmail = mEmail;
        this.mPassword = mPassword;
        this.mPhone = mPhone;
        this.userID = userID;
    }

    public String getmFullName() {
        return mFullName;
    }

    public void setmFullName(String mFullName) {
        this.mFullName = mFullName;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
