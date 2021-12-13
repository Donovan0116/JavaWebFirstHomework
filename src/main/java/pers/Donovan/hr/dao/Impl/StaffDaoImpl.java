package pers.Donovan.hr.dao.Impl;

import pers.Donovan.hr.dao.StaffDao;
import pers.Donovan.hr.db.BaseDao;
import pers.Donovan.hr.entity.Staff;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffDaoImpl implements StaffDao {

    private final BaseDao baseDao = new BaseDao();

    @Override
    public List<Staff> selectForOtherByStaffUserName(String StaffUserName) {
        //为普通员工查询其他员工信息用,包含所有员工的用户名、姓名、两种联系方式、部门

        List<Staff> list = new ArrayList<>();

        String sql = "select * from Staff where StaffUserName=?";
        Staff getStaff;

        baseDao.open();

        ResultSet rs = baseDao.execDQL(sql, StaffUserName);

        try {
            while (rs.next()) {
                getStaff = new Staff(
                        rs.getString("StaffHeadPic"),
                        rs.getString("StaffUserName"),
                        rs.getString("StaffName"),
                        rs.getString("StaffTel"),
                        rs.getString("StaffQQ"),
                        rs.getString("DeptName")
                );
                list.add(getStaff);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        baseDao.close();

        return list;
    }

    @Override
    public List<Staff> selectForAdminByStaffUserName(String StaffUserName) {

        List<Staff> list = new ArrayList<>();

        //为管理员查询信息使用
        String sql = "select * from Staff where StaffUserName=?";
        Staff getStaff;

        baseDao.open();

        ResultSet rs = baseDao.execDQL(sql, StaffUserName);

        try {
            while (rs.next()) {
                getStaff = new Staff(
                        rs.getString("StaffUserName"),
                        rs.getString("StaffName"),
                        rs.getString("StaffTel"),
                        rs.getString("StaffQQ"),
                        rs.getString("StaffWage"),
                        rs.getString("StaffPwd"),
                        rs.getBoolean("isAdmin"),
                        rs.getString("StaffHeadPic"),
                        rs.getString("DeptName")
                );
                list.add(getStaff);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        baseDao.close();

        return list;
    }

    @Override
    public List<Staff> selectAllByStaffUserNameAndStaffPwd(String StaffUserName, String StaffPwd) {//for Admin or Login

        List<Staff> list = new ArrayList<>();

        String sql = "select * from Staff where StaffUserName=? and StaffPwd=?";

        Staff getStaff;

        baseDao.open();

        ResultSet rs = baseDao.execDQL(sql, StaffUserName, StaffPwd);


        try {
            while (rs.next()) {
                getStaff = new Staff(
                        rs.getString("StaffUserName"),
                        rs.getString("StaffName"),
                        rs.getString("StaffTel"),
                        rs.getString("StaffQQ"),
                        rs.getString("StaffWage"),
                        rs.getString("StaffPwd"),
                        rs.getBoolean("isAdmin"),
                        rs.getString("StaffHeadPic"),
                        rs.getString("DeptName")
                );
                list.add(getStaff);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        baseDao.close();

        return list;
    }

    @Override
    public List<Staff> selectSomeForAll() {
        //员工登录后首页显示这些结果，包含所有员工的用户名、姓名、两种联系方式、部门

        List<Staff> list = new ArrayList<>();

        String sql = "select StaffUserName,StaffName,StaffTel,StaffQQ,DeptName,StaffHeadPic from Staff";

        Staff getStaff;

        baseDao.open();

        ResultSet rs = baseDao.execDQL(sql);

        try {
            while (rs.next()) {
                getStaff = new Staff(
                        rs.getString("StaffHeadPic"),
                        rs.getString("StaffUserName"),
                        rs.getString("StaffName"),
                        rs.getString("StaffTel"),
                        rs.getString("StaffQQ"),
                        rs.getString("DeptName")
                );
                list.add(getStaff);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        baseDao.close();

        return list;
    }

    @Override
    public List<Staff> selectSomeForAllForAdmin() {

        List<Staff> list = new ArrayList<>();

        String sql = "select * from Staff";

        Staff getStaff;

        baseDao.open();

        ResultSet rs = baseDao.execDQL(sql);

        try {
            while (rs.next()) {
                getStaff = new Staff(
                        rs.getString("StaffUserName"),
                        rs.getString("StaffName"),
                        rs.getString("StaffTel"),
                        rs.getString("StaffQQ"),
                        rs.getString("StaffWage"),
                        rs.getString("StaffPwd"),
                        rs.getBoolean("isAdmin"),
                        rs.getString("StaffHeadPic"),
                        rs.getString("DeptName")
                );
                list.add(getStaff);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        baseDao.close();

        return list;
    }

    @Override
    public int insertStaff(Staff staff) {

        String sql = "insert into Staff values(?,?,?,?,?,?,?,?,?)";

        baseDao.open();

        baseDao.execDML(sql,staff.getStaffUserName(),
                staff.getStaffName(),
                staff.getStaffTel(),
                staff.getStaffQQ(),
                staff.getStaffWage(),
                staff.getStaffPwd(),
                staff.isAdmin(),
                staff.getStaffHeadPic(),
                staff.getDeptName()
        );
        baseDao.close();

        return 1;
    }

    @Override
    public int deleteStaffByStaffUserName(String staffUserName) {
        String sql = "delete from Staff where StaffUserName=?";

        baseDao.open();

        baseDao.execDML(sql,staffUserName);

        baseDao.close();

        return 1;
    }

    @Override
    public int updateStaff(Staff staff) {
        //在界面中：“请输入您想要更改的用户全部信息”，之后作为表单提交
        deleteStaffByStaffUserName(staff.getStaffUserName());
        insertStaff(staff);

        return 1;
    }
}
