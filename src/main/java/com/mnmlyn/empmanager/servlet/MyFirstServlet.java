package com.mnmlyn.empmanager.servlet;

import com.mnmlyn.empmanager.DAO.impl.EmpDAOImpl;
import com.mnmlyn.empmanager.entry.EmpDO;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MyFirstServlet extends HttpServlet {
    public MyFirstServlet() {
        System.out.println("servlet init");
    }

    @Autowired
    private EmpDAOImpl empDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-------------enter servlet-------------");
        // uri = contextPath + servletPath + others
        String uri = req.getRequestURI();
        uri = uri.substring(req.getContextPath().length() + req.getServletPath().length());
        if (uri.length() > 0 && uri.substring(0, 1).equals("/")) {
            uri = uri.substring(1);
        }
        System.out.println("uri=" + uri);

        String dispatchPath = null;
        if ("first".equals(uri)) {
            dispatchPath = "/WEB-INF/jsp/first.jsp";
            req.setAttribute("emp", empDAO.queryEmp());
        } else if ("insert".equals(uri)) {
            System.out.println(req.getQueryString());
            Map<String, String[]> parameterMap = req.getParameterMap();

            for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
                String key = entry.getKey();
                String[] values = entry.getValue();
                System.out.println("--key--");
                System.out.println(key);
                System.out.println("----");
                for (String value : values) {
                    System.out.println(value);
                }
                System.out.println("----");
            }

            if (checkInsertParam(parameterMap)) {
                EmpDO emp = new EmpDO();
                emp.setAge(Integer.parseInt(parameterMap.get("age")[0]));
                emp.setName(parameterMap.get("name")[0]);
                empDAO.insertEmp(emp);
            }

            resp.sendRedirect("list");
        } else if ("list".equals(uri)) {
            dispatchPath = "/WEB-INF/jsp/first.jsp";
            List<EmpDO> empList = empDAO.listAllEmps();
            req.setAttribute("empList", empList);
        } else if ("delete".equals(uri)) {
            String idStr = req.getParameter("id");
            if (!StringUtils.isEmpty(idStr)) {
                try {
                    int id = Integer.parseInt(idStr);
                    empDAO.deleteEmpById(id);
                } catch (Exception e) {
                }
            }
            resp.sendRedirect("list");
        } else if ("upload".equals(uri)) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            File repository = (File)getServletContext().getAttribute("javax.servlet.context.tempdir");
            factory.setRepository(repository);

            ServletFileUpload upload = new ServletFileUpload(factory);
            try {
                List<FileItem> items = upload.parseRequest(req);
                Iterator<FileItem> iter = items.iterator();
                while (iter.hasNext()) {
                    FileItem item = iter.next();

                    // Process a file upload
                    if (!item.isFormField()) {
                        String fieldName = item.getFieldName();
                        String fileName = item.getName();
                        String contentType = item.getContentType();
                        boolean isInMemory = item.isInMemory();
                        long sizeInBytes = item.getSize();
                        System.out.println(fieldName);
                        System.out.println(fileName);
                        System.out.println(contentType);
                        System.out.println(isInMemory);
                        System.out.println(sizeInBytes);

                        // Process a file upload
                        File uploadedFile = new File(this.getServletContext().getRealPath("/ext/"+"111.jpg"));
                        item.write(uploadedFile);
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            dispatchPath = "/index.jsp";
        }

        if (dispatchPath != null) {
            RequestDispatcher dispatcher = req.getRequestDispatcher(dispatchPath);
            dispatcher.forward(req, resp);
        }

        System.out.println("++++++++++exit servlet+++++++++++++");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    private boolean checkInsertParam(Map<String, String[]> parameterMap) {
        if (!parameterMap.containsKey("name") || !parameterMap.containsKey("age")) {
            return false;
        }
        String[] names = parameterMap.get("name");
        String[] ages = parameterMap.get("age");
        if (names.length < 1 || ages.length < 1) {
            return false;
        }
        if (StringUtils.isEmpty(names[0]) || StringUtils.isEmpty(ages[0])) {
            return false;
        }
        try {
            int i = Integer.parseInt(ages[0]);
            if (i <= 0 || i >= 120) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
