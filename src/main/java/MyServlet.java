import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    static int val = 1;
    private static final Logger logger = LogManager.getLogger(MyServlet.class);

//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String name = request.getParameter("firstName");
//        String countValue = request.getParameter("lastName");
//        String tolog = request.getParameter("toLog");
//
//        String[] parts = name.split("_");
//        int min = Integer.parseInt(parts[0]);
//        int max = Integer.parseInt(parts[1]);
//        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
//
//       val += Integer.parseInt(countValue);
//
//        PrintWriter out = response.getWriter();
//        //out.println("Hello from Servlet!.GET" + name + lastname);
//        out.println("randValue=" + random_int);
//        out.println("counterValue= " + val);
//        out.println(tolog);
//        logger.info(tolog);
//        out.close();
//    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8"); // чтобы в POST запросе корректно отображались русские буквы
//        String name = request.getParameter("firstName");
//        String lastname = request.getParameter("lastName");
//        PrintWriter out = response.getWriter();
//        out.println("Hello from Servlet!.POST" + name + lastname);
//        out.close();
        request.setCharacterEncoding("UTF-8");

        String randValue = request.getParameter("RandValue");
        String countValue = request.getParameter("CountValue");
        String tolog = request.getParameter("ToLog");

        String[] parts = randValue.split("_");
        int min = Integer.parseInt(parts[0]);
        int max = Integer.parseInt(parts[1]);
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);

        val += Integer.parseInt(countValue);

        response.setContentType("text/html;charset7=utf-8");
        PrintWriter out = response.getWriter();
        //out.println("Hello from Servlet!.GET" + name + lastname);
        out.println("<h3>POST method</h3>");
        out.println("randValue=" + random_int);
        out.print("<br>");
        out.println("counterValue= " + val);
        out.print("<br>");
        out.println(tolog);
        logger.info(tolog);
        out.close();
    }
}
