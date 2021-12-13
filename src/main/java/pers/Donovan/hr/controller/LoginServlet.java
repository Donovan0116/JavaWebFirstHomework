package pers.Donovan.hr.controller;

import pers.Donovan.hr.dao.Impl.StaffDaoImpl;
import pers.Donovan.hr.dao.StaffDao;
import pers.Donovan.hr.entity.Staff;
import pers.Donovan.hr.service.StaffService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private final StaffService staffService = new StaffService() {
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
    };

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String StaffUserName = request.getParameter("StaffUserName");
        String StaffPwd = request.getParameter("StaffPwd");

        List<Staff> list = staffService.login(StaffUserName, StaffPwd);


        String viewName = "index.jsp";

        if (list.size()!=0) {
            Staff staff = list.get(0);
            request.setAttribute("loginUser", staff);
            HttpSession session = request.getSession();
            session.setAttribute("currentStaff",staff);
            if (staff.isAdmin()) viewName = "AdminAll.jsp";//起到区分管理员作用
            else viewName = "All.jsp";
        } else {
            request.setAttribute("isOK",false);
        }

        request.getRequestDispatcher(viewName).forward(request,response);

    }
}
