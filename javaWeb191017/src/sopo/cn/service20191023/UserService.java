package sopo.cn.service20191023;

import sopo.cn.model20191023.User;

public class UserService {

	public static User login( String usr, String pwd) {
		
		//先把用户名和密码写在这里，以后可以从数据库里面取
		if( usr.equals("YYY") && pwd.equals("0001")) {
			return new User( usr, pwd);
		} else {
			return null;
		}
	}
}
