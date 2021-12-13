package pers.Donovan.hr.entity;

public class Staff {
    private String StaffUserName;//主键
    private String StaffName;
    private String StaffTel;
    private String StaffQQ;
    private String StaffWage;//对其他用户不可见
    private String StaffPwd;
    private boolean isAdmin;
    private String StaffHeadPic;
    private String DeptName;//外键，依赖于Dept表


    public Staff(String staffUserName, String staffName, String staffTel, String staffQQ, String staffWage, String staffPwd, boolean isAdmin, String staffHeadPic, String deptName) {
        StaffUserName = staffUserName;
        StaffName = staffName;
        StaffTel = staffTel;
        StaffQQ = staffQQ;
        StaffWage = staffWage;
        StaffPwd = staffPwd;
        this.isAdmin = isAdmin;
        StaffHeadPic = staffHeadPic;
        DeptName = deptName;
    }

    public Staff() {
    }
    //普通用户查询其他用户所用的构造器
    public Staff(String staffHeadPic, String staffUserName, String staffName, String staffTel, String staffQQ, String deptName) {
        StaffHeadPic = staffHeadPic;
        StaffUserName = staffUserName;
        StaffName = staffName;
        StaffTel = staffTel;
        StaffQQ = staffQQ;
        DeptName = deptName;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "StaffUserName='" + StaffUserName + '\'' +
                ", StaffTel='" + StaffTel + '\'' +
                ", StaffQQ='" + StaffQQ + '\'' +
                ", StaffWage='" + StaffWage + '\'' +
                ", StaffPwd='" + StaffPwd + '\'' +
                ", isAdmin=" + isAdmin +
                ", StaffHeadPic='" + StaffHeadPic + '\'' +
                '}';
    }

    public String getStaffUserName() {
        return StaffUserName;
    }

    public void setStaffUserName(String staffUserName) {
        StaffUserName = staffUserName;
    }

    public String getStaffTel() {
        return StaffTel;
    }

    public void setStaffTel(String staffTel) {
        StaffTel = staffTel;
    }

    public String getStaffQQ() {
        return StaffQQ;
    }

    public void setStaffQQ(String staffQQ) {
        StaffQQ = staffQQ;
    }

    public String getStaffWage() {
        return StaffWage;
    }

    public void setStaffWage(String staffWage) {
        StaffWage = staffWage;
    }

    public String getStaffPwd() {
        return StaffPwd;
    }

    public void setStaffPwd(String staffPwd) {
        StaffPwd = staffPwd;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getStaffHeadPic() {
        return StaffHeadPic;
    }

    public void setStaffHeadPic(String staffHeadPic) {
        StaffHeadPic = staffHeadPic;
    }

    public String getStaffName() {
        return StaffName;
    }

    public void setStaffName(String staffName) {
        StaffName = staffName;
    }

    public String getDeptName() {
        return DeptName;
    }

    public void setDeptName(String deptName) {
        DeptName = deptName;
    }
}
