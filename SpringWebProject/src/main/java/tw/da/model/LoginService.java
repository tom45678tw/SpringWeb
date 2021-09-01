package tw.da.model;

public class LoginService {
   private LoginDAO logindao; //這裡第一個字不刑大寫
   
   
	public LoginService() {
		
	} 

public LoginService(LoginDAO logindao) {
	this.logindao=logindao;
		
	}


public void setLogindao(LoginDAO logindao) {
	this.logindao = logindao;
}

public boolean checkLogin(String user,String pwd) {
	 return logindao.checkLogin(user, pwd);
 }
}
