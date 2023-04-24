package JOTP;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base32;

import Am.AmDAO2;
import Am.AmDTO2;
import utils.AlertFunc;

@WebServlet("/JOTP/OTPTestResult.ok")
public class OtpResultServelt extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user_codeStr = req.getParameter("code");
		long user_code = Integer.parseInt(user_codeStr);
		String encodedKey = req.getParameter("encodedKey");
		String id = (String) req.getSession().getAttribute("loginId");
		long A = new Date().getTime();
		long AA = A / 30000;
			
        AmDTO2 dto = new AmDTO2(); 
        AmDAO2 dao = new AmDAO2();
        //현재 날짜와 시간을 String 형태로 받음
        Date nowDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd/HH:mm:ss");
        String strNowDate = simpleDateFormat.format(nowDate);
        String[] snd = strNowDate.split("/");
        String dt = snd[0];
        String tt = snd[1];
        
		boolean check_code = false;
		try {
			check_code = check_code(encodedKey, user_code, AA);
			if(check_code==true) {
				dto.setId(id);
				dto.setType(0);//출근
				dto.setDay_t(dt);
				dto.setTime_s(tt);
				dao.insertDB(dto);
				resp.sendRedirect(req.getContextPath() + "/JOTP/CommutionController.do");
			}else {
				AlertFunc.alertBack(resp, "실패했습니다. 새로고침해서 값을 다시받아서 다시 시도하세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//일치하면 True
		System.out.println("check_code : "+ check_code);
		
	}

	//코드 체크 함수
	private static boolean check_code(String secret, long code, long t) throws InvalidKeyException, NoSuchAlgorithmException {
		Base32 codec = new Base32();
		byte[] decodedKey = codec.decode(secret);
		
		//window에서 생성된 코드 비교, 이값을 통해 범위 조정가능
			int window = 3;
			for(int i = -window; i<= window; ++i) {
				long hash = verify_code(decodedKey, t+i);
				
				if(hash == code) {
					return true;
				}
			}
		return false;
	}

	//코드 확인 함수
	private static long verify_code(byte[] key, long t) throws NoSuchAlgorithmException, InvalidKeyException {
			byte[] data = new byte[8];
			long value = t;
			//8비트씩 오른쪽으로 이동 for문은 1byte를 추출하고 이를 역순으로 data배열에 저장 (직렬화)
			for(int i = 8; i-- > 0; value >>>=8) {
				data[i] = (byte)value;
			}
			
			SecretKeySpec signKey = new SecretKeySpec(key, "HmacSHa1");
			Mac mac = Mac.getInstance("HmacSHa1");
			mac.init(signKey);
			byte[] hash = mac.doFinal(data);
			
			int offset = hash[20 - 1] & 0xF;
			
			long truncatedHash = 0;
	        for (int i = 0; i < 4; ++i) {
	            truncatedHash <<= 8;
	            truncatedHash |= (hash[offset + i] & 0xFF);
	        }
	 
	        truncatedHash &= 0x7FFFFFFF;
	        truncatedHash %= 1000000;
	 
	        return (int) truncatedHash;
	}
}
