package cn.itbcat.boot.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 860117030 on 2017/9/18.
 */
@WebServlet(urlPatterns = "/upload",description = "文件上传")
public class FileUploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        OutputStream(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        OutputStream(req, resp);
    }

    public void OutputStream(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }

}
