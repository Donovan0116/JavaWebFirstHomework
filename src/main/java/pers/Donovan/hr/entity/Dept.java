package pers.Donovan.hr.entity;

public class Dept {
    private String DeptName;//主键
    private String DeptLoc;
    private String DeptTel;
    private String DeptProfit;//不对其他用户可见

    public Dept(String deptName, String deptLoc, String deptTel, String deptProfit) {
        DeptName = deptName;
        DeptLoc = deptLoc;
        DeptTel = deptTel;
        DeptProfit = deptProfit;
    }

    public Dept() {
    }

    public Dept(String deptName, String deptTel, String deptLoc) {
        this.DeptName = deptName;
        this.DeptTel = deptTel;
        this.DeptLoc = deptLoc;
    }

    public String getDeptName() {
        return DeptName;
    }

    public void setDeptName(String deptName) {
        DeptName = deptName;
    }

    public String getDeptLoc() {
        return DeptLoc;
    }

    public void setDeptLoc(String deptLoc) {
        DeptLoc = deptLoc;
    }

    public String getDeptTel() {
        return DeptTel;
    }

    public void setDeptTel(String deptTel) {
        DeptTel = deptTel;
    }

    public String getDeptProfit() {
        return DeptProfit;
    }

    public void setDeptProfit(String deptProfit) {
        DeptProfit = deptProfit;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "DeptName='" + DeptName + '\'' +
                ", DeptLoc='" + DeptLoc + '\'' +
                ", DeptTel='" + DeptTel + '\'' +
                ", DeptProfit='" + DeptProfit + '\'' +
                '}';
    }
}
