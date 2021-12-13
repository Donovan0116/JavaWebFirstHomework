package pers.Donovan.hr.service;

import pers.Donovan.hr.entity.Staff;

import java.util.List;

public interface StaffService {
    List<Staff> login(String StaffUserName, String StaffPwd);
    int reg(Staff staff);

    List<Staff> searchForOthers(String StaffUserName);
    List<Staff> showAllForOthers();

    List<Staff> searchForAdmin(String StaffUserName);                 //admin
    List<Staff> showAllForAdmin();                                    //admin

    int deleteStaff(String StaffUserName);                      //admin
    int updateStaff(Staff staff);                               //admin
}
