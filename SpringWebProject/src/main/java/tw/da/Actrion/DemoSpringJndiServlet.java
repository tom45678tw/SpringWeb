package tw.da.Actrion;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import tw.da.model.House;
import tw.da.model.HouseService;


@WebServlet("/DemoSpringJndiServlet.do")
public class DemoSpringJndiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private  WebApplicationContext context;
	
	public void init() throws ServletException {
	 ServletContext appContext = getServletContext();
	 context = WebApplicationContextUtils.getWebApplicationContext(appContext);
	}

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          processAction(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 processAction(request,response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HouseService h = context.getBean("houseService",HouseService.class);
		           try {
					House hBean = h.selectById(1003);
					if(hBean!=null) {
					out.write(hBean.getHouseid()+":"+hBean.getHousename());
					}else {
						out.write("no result");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//		   ((ConfigurableApplicationContext)context).close();
		out.close();
	}
}
