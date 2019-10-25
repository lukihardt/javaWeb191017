package sopo.cn.utils20191023;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Captcha {
	private int width;
	private int height;
	private int num;
	private String code;
	private static final Random RAN = new Random();
	
	private static Captcha captcha;
	
	private Captcha() {
		code = "0123456789";
		num = 4;
	}
	
	public static Captcha getInstance() {
		if (captcha == null) {
			captcha = new Captcha();
		}
		return captcha;
	}
	
	public void set( int width, int height, int num, String code) {
		this.width = width;
		this.height = height;
		this.num = num;
		this.code = code;
	}
	
	public void set( int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String generateCheckCode() {
		StringBuffer cc = new StringBuffer(); 
		for (int i = 0; i < num; i++) {
			cc.append(code.charAt(RAN.nextInt(code.length())));
		}
//		System.out.println(RAN.nextInt(code.length()));
		return cc.toString();
	}
	
	public BufferedImage generateCheckImg( String checkcode) {
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		Graphics2D graphics2d = img.createGraphics();
		
		graphics2d.setColor(Color.white);
		graphics2d.fillRect(0, 0, width, height);
		graphics2d.setColor(Color.black);
		graphics2d.drawRect(0, 0, width - 1, height - 1);
		Font font = new Font( "微软雅黑", Font.BOLD+Font.ITALIC, (int)height);
		graphics2d.setFont(font);
		
		for (int i = 0; i < num; i++) {
			graphics2d.setColor( new Color(RAN.nextInt(255), RAN.nextInt(255), RAN.nextInt(255)));
			graphics2d.drawString( String.valueOf( checkcode.charAt(i)), i * ( width/num) + 4, height - 3);
		}
		
		for (int i = 0; i < ( width + height); i++) {
			graphics2d.setColor( new Color(RAN.nextInt(255), RAN.nextInt(255), RAN.nextInt(255)));
			graphics2d.drawOval(RAN.nextInt(width), RAN.nextInt(height), 1, 1);
		}
		
		for (int i = 0; i < 2; i++) {
			graphics2d.setColor( new Color(RAN.nextInt(255), RAN.nextInt(255), RAN.nextInt(255)));
			graphics2d.drawLine( 0, RAN.nextInt(height), width, RAN.nextInt(height));
		}
		
		return img;
	}
	
	public void drawCheckCode( HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("image/jpg");
		int width = 100;
		int height = 25;
		
		Captcha c = Captcha.getInstance();
		c.set(width, height);
		String checkCode = c.generateCheckCode();
		request.getSession().setAttribute( "cc", checkCode);
		OutputStream os = response.getOutputStream();
		ImageIO.write(c.generateCheckImg(checkCode), "jpg", os);
		
		os.flush();
	}
}
