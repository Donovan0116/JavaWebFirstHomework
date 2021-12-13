package pers.Donovan.hr.service;

import pers.Donovan.hr.dao.Impl.StaffDaoImpl;
import pers.Donovan.hr.dao.StaffDao;
import pers.Donovan.hr.entity.Staff;
import pers.Donovan.hr.service.StaffService;

import java.util.List;

public class StaffServiceImpl implements StaffService {

    private final StaffDao staffDao = new StaffDaoImpl();

    @Override
    public List<Staff> login(String StaffUserName, String StaffPwd) {
        return staffDao.selectAllByStaffUserNameAndStaffPwd(StaffUserName,StaffPwd);
    }

    @Override
    public int reg(Staff staff) {
        return staffDao.insertStaff(staff);
    }

    @Override
    public List<Staff> searchForOthers(String StaffUserName) {
        return staffDao.selectForOtherByStaffUserName(StaffUserName);
    }

    @Override
    public List<Staff> showAllForOthers() {
        return staffDao.selectSomeForAll();
    }

    @Override
    public List<Staff> searchForAdmin(String StaffUserName) {
        return staffDao.selectForAdminByStaffUserName(StaffUserName);
    }

    @Override
    public List<Staff> showAllForAdmin() {
        return staffDao.selectSomeForAllForAdmin();
    }

    @Override
    public int deleteStaff(String StaffUserName) {
        return staffDao.deleteStaffByStaffUserName(StaffUserName);
    }

    @Override
    public int updateStaff(Staff staff) {
        return staffDao.updateStaff(staff);
    }
}
