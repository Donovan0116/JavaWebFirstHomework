package pers.Donovan.hr.controller;

import pers.Donovan.hr.dao.Impl.StaffDaoImpl;
import pers.Donovan.hr.dao.StaffDao;
import pers.Donovan.hr.entity.Staff;
import pers.Donovan.hr.service.StaffService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


@WebServlet("/RegServlet")
@MultipartConfig
public class RegServlet extends HttpServlet {

    private final StaffService staffService = new StaffService() {
        private final StaffDao staffDao = new StaffDaoImpl();

        @Override
        public List<Staff> login(String StaffUserName, String StaffPwd) {
            return staffDao.selectAllByStaffUserNameAndStaffPwd(StaffUserName, StaffPwd);
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


//        String StaffUserName = request.getParameter("StaffUserNameForReg");
//
//        String view = "reg.jsp";
//
//        if(staffDao.selectForOtherByStaffUserName(StaffUserName)==null){
//            Staff staff = new Staff(
//                    request.getParameter("StaffUserNameForReg"),
//                    request.getParameter("StaffNameForReg"),
//                    request.getParameter("StaffTelForReg"),
//                    request.getParameter("StaffQQForReg"),
//                    request.getParameter("StaffWageForReg"),
//                    request.getParameter("StaffPwdForReg"),
//                    Boolean.parseBoolean(request.getParameter("isAdminForReg")),
//                    request.getParameter("StaffHeadPicForReg"),
//                    request.getParameter("StaffDeptNameForReg")
//            );
//            staffService.reg(staff);
//            view = "index.jsp";
//        }else{
//            request.setAttribute("isOKForReg",false);
//        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Staff staff = new Staff(
                request.getParameter("StaffUserNameForReg"),
                request.getParameter("StaffNameForReg"),
                request.getParameter("StaffTelForReg"),
                request.getParameter("StaffQQForReg"),
                request.getParameter("StaffWageForReg"),
                request.getParameter("StaffPwdForReg"),
                Boolean.parseBoolean(request.getParameter("isAdminForReg")),
                request.getParameter("StaffHeadPicForReg"),
                request.getParameter("StaffDeptNameForReg")
        );
        staffService.reg(staff);

        Part part = request.getPart("StaffHeadPicForReg");
        String header = part.getHeader("Content-Disposition");
        int beginIndex = header.indexOf("filename=\"") + 10;

        String oldName = header.substring(beginIndex, header.length() - 1);

        int index = oldName.lastIndexOf(".");
        String newName = UUID.randomUUID() + oldName.substring(index);
        String path = request.getServletContext().getRealPath("/img/");
        part.write(path + newName);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }


}
