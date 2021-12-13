package pers.Donovan.hr.dao.Impl;

import pers.Donovan.hr.dao.DeptDao;
import pers.Donovan.hr.db.BaseDao;
import pers.Donovan.hr.entity.Dept;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeptDaoImpl implements DeptDao {
    private final BaseDao baseDao = new BaseDao();
    @Override
    public List<Dept> selectByOrders() {

        List<Dept> list = new ArrayList<>();

        String sql = "select * from Dept";

        Dept getDept;

        baseDao.open();

        ResultSet rs = baseDao.execDQL(sql);

        try {
            while (rs.next()) {
                getDept = new Dept(
                        rs.getString("DeptName"),
                        rs.getString("DeptLoc"),
                        rs.getString("DeptTel")
                );
                list.add(getDept);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        baseDao.close();
        return list;
    }

    @Override
    public List<Dept> selectByAdmin() {

        List<Dept> list = new ArrayList<>();

        String sql = "select * from Dept";

        Dept getDept;

        baseDao.open();

        ResultSet rs = baseDao.execDQL(sql);

        try {
            while (rs.next()) {
                getDept = new Dept(
                        rs.getString("DeptName"),
                        rs.getString("DeptLoc"),
                        rs.getString("DeptTel"),
                        rs.getString("DeptProfit")
                );
                list.add(getDept);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        baseDao.close();
        return list;
    }

    @Override
    public List<Dept> selectAllForAdminByName(String DeptName) {

        List<Dept> list = new ArrayList<>();

        String sql = "select * from Dept where DeptName=?";

        Dept getDept;

        baseDao.open();

        ResultSet rs = baseDao.execDQL(sql, DeptName);

        try {
            while (rs.next()) {
                getDept = new Dept(
                        rs.getString("DeptName"),
                        rs.getString("DeptTel"),
                        rs.getString("DeptLoc"),
                        rs.getString("DeptProfit")
                );
                list.add(getDept);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        baseDao.close();

        return list;
    }

    @Override
    public List<Dept> selectAllByName(String DeptName) {

        List<Dept> list = new ArrayList<>();

        String sql = "select * from Dept where DeptName=?";

        Dept getDept;

        baseDao.open();

        ResultSet rs = baseDao.execDQL(sql, DeptName);

        try {
            while (rs.next()) {
                getDept = new Dept(
                        rs.getString("DeptName"),
                        rs.getString("DeptTel"),
                        rs.getString("DeptLoc")
                );
                list.add(getDept);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        baseDao.close();

        return list;
    }

    @Override
    public int insertDept(Dept dept) {

        String sql = "insert into Dept values(?,?,?,?)";

        baseDao.open();

        baseDao.execDML(sql,dept.getDeptName(),
                dept.getDeptLoc(),
                dept.getDeptTel(),
                dept.getDeptProfit()
        );

        baseDao.close();

        return 1;
    }

    @Override
    public int deleteDeptByDeptName(String deptName) {
        String sql = "delete from Dept where DeptName=?";

        baseDao.open();

        baseDao.execDML(sql,deptName);

        baseDao.close();

        return 1;
    }

    @Override
    public int updateDept(Dept dept) {
        deleteDeptByDeptName(dept.getDeptName());
        insertDept(dept);
        return 1;
    }
}
