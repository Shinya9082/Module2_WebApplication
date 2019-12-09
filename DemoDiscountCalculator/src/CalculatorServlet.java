import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description=request.getParameter("description");
        float price= Float.parseFloat(request.getParameter("price"));
        int discount_percent= Integer.parseInt(request.getParameter("discount"));
        float discount =(float) (price*discount_percent*0.01);
        float total = price - discount;
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Product description :"+ description);
        writer.println("<h1>Price :"+ price);
        writer.println("<h1>Discount percent:"+ discount_percent);
        writer.println("<h1>Discount:"+ discount);
        writer.println("<h1>Total:"+ total);
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
