package net.gitanjit.final_group_alarm;

public class UserHelperClass {

    public String fullName, phone, email ;
    //public ArrayList< UserHelperClass >


    public UserHelperClass(String fullName , String phone, String email )
    {
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
    }
    public UserHelperClass() {}



    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}