package pers.Donovan.hr.service;

import pers.Donovan.hr.dao.DeptDao;
import pers.Donovan.hr.dao.Impl.DeptDaoImpl;
import pers.Donovan.hr.entity.Dept;
import pers.Donovan.hr.service.DeptService;

import java.util.List;

public class DeptServiceImpl implements DeptService {

    private final DeptDao deptDao = new DeptDaoImpl();

    @Override
    public List<Dept> showForOthers() {
        return deptDao.selectByOrders();
    }

    @Override
    public List<Dept> showForAdmin() {
        return deptDao.selectByAdmin();
    }

    @Override
    public List<Dept> searchForOthers(String DeptName) {
        return deptDao.selectAllByName(DeptName);
    }

    @Override
    public List<Dept> searchForAdmin(String DeptName) {
        return deptDao.selectAllForAdminByName(DeptName);
    }

    @Override
    public int insertDept(Dept dept) {
        return deptDao.insertDept(dept);
    }

    @Override
    public int deleteDept(String DeptName) {
        return deptDao.deleteDeptByDeptName(DeptName);
    }

    @Override
    public int updateDept(Dept dept) {
        return deptDao.updateDept(dept);
    }
}
