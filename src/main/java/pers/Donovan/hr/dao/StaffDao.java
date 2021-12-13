package pers.Donovan.hr.dao;

import pers.Donovan.hr.entity.Staff;

import java.util.List;

public interface StaffDao {
    public List<Staff> selectForOtherByStaffUserName(String StaffUserName);
    public List<Staff> selectForAdminByStaffUserName(String StaffUserName);//hr系统中用户查找用
    //登录用
    public List<Staff> selectAllByStaffUserNameAndStaffPwd(String StaffUserName, String StaffPwd);
    //展示用
    public List<Staff> selectSomeForAll();
    public List<Staff> selectSomeForAllForAdmin();
    public int insertStaff(Staff staff);//增
    public int deleteStaffByStaffUserName(String staffUserName);//删
    public int updateStaff(Staff staff);//改
    //改
}
