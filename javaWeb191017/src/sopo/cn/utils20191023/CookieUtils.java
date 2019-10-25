package sopo.cn.utils20191023;

import java.security.MessageDigest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {
	
	private static final String KEY = "9999452221";
	
	public static String md5Encrypt(String ss) {
		ss = ss == null ? "" : ss + KEY;
		char[] md5Digist = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] ssarr = ss.getBytes();
			md.update(ssarr);
			byte[] mssarr = md.digest();
			
			int len = mssarr.length;
			char[] str = new char[ len * 2];
			int k = 0;
			
			for (int i = 0; i < len; i++) {
				byte b = mssarr[i];
				str[k++] = md5Digist[b >>> 4 & 0xf]; //[]里面的值最大为'1111'即15，也就是[0~15]
				str[k++] = md5Digist[b & 0xf];
			}
			
			System.out.println("===="+new String(str));
			return new String(str);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public static void createCookie( String username, HttpServletRequest req, HttpServletResponse resp, int i) {
		Cookie userCookie = new Cookie("userKey", username);
		Cookie ssidCookie = new Cookie( "ssid", md5Encrypt(username));
		
		userCookie.setMaxAge(i);
		ssidCookie.setMaxAge(i);
		
		resp.addCookie(userCookie);
		resp.addCookie(ssidCookie);
	}
}
