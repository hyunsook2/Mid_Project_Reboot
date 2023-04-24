package JOTP;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base32;

import profile.ProfileDAO;
import profile.ProfileDTO;

@WebServlet("/JOTP/otp.do")
public class OtpController extends HttpServlet{
   //랜덤으로 인증키를 생성하고 바코드 주소를 생성한 다음 otp.jsp에 보내는 역할
   @Override
   protected void service(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
	   byte[] buffer = new byte[5 + 5 * 5];
       new SecureRandom().nextBytes(buffer);
       Base32 codec = new Base32();
       byte[] secretKey = Arrays.copyOf(buffer, 10); // 16자 이상이여하므로 10으로 설정 필요
       byte[] bEncodedKey = codec.encode(secretKey);
       //인증키 생성
       String encodedKey = new String(bEncodedKey);
       //바코드 주소 생성
       //바코드 url을 만드는 메소드인 getQRBarcodeURL에서 user와 host값은 다른 암호와 구분하기위한 값으로 아무값이나 넣어도 됨.
       String qrUrl = getQRBarcodeURL("admin", "facbank", encodedKey);
       String id = (String) req.getSession().getAttribute("loginId");
       
       req.setAttribute("id", id);
       req.setAttribute("encodedKey", encodedKey);
       req.setAttribute("qrUrl", qrUrl);
       req.getRequestDispatcher("/otp/OtpPage.jsp").forward(req, resp);
   }

    public static String getQRBarcodeURL(String user, String host, String secret) {
        String format = "http://chart.apis.google.com/chart?cht=qr&chs=200x200&chl=otpauth://totp/%s@%s%%3Fsecret=%s&chld=H|0";

        return String.format(format, user, host, secret);
    }
}