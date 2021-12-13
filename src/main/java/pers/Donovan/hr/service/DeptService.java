package pers.Donovan.hr.service;

import pers.Donovan.hr.entity.Dept;

import java.util.List;

public interface DeptService {

    List<Dept> showForOthers();
    List<Dept> showForAdmin();                        //admin

    List<Dept> searchForOthers(String DeptName);
    List<Dept> searchForAdmin(String DeptName);                      //admin

    int insertDept(Dept dept);                  //admin
    int deleteDept(String DeptName);            //admin
    int updateDept(Dept dept);                  //admin
}
