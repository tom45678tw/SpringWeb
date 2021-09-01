package tw.da.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebFilter("/*")
public class OpenSessionInViewFilter implements Filter {
 private SessionFactory session;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		ServletContext application = filterConfig.getServletContext();
		 WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
	        session = context.getBean("sessionFactory",SessionFactory.class);
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		Session se = session.getCurrentSession();
		try {
		se.beginTransaction();
		System.out.println("交易開始");
		arg2.doFilter(arg0, arg1);
		
		se.getTransaction().commit();
		System.out.println("交易送出 結束 即將關閉");
		}catch(Exception e) {
			se.getTransaction().rollback();
			System.out.println("交易失敗,資料即將返回");
			e.printStackTrace();
		}

	}

}
