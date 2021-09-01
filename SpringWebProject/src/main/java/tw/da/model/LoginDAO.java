package tw.da.model;

public class LoginDAO {

	 public boolean checkLogin(String user,String pwd) {
		 if("john".equals(user) && "test213".equals(pwd)) {
			 return true;
		 }
		 return false;
	 }
}
