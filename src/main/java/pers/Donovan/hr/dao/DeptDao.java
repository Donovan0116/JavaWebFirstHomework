package pers.Donovan.hr.dao;

import pers.Donovan.hr.entity.Dept;

import java.util.List;

public interface DeptDao {
    List<Dept> selectByOrders();
    List<Dept> selectByAdmin();
    List<Dept> selectAllForAdminByName(String DeptName);
    List<Dept> selectAllByName(String DeptName);
    public int insertDept(Dept dept);//增
    public int deleteDeptByDeptName(String deptName);//删
    public int updateDept(Dept dept);//改，仅修改部门名字之外的元素
}
