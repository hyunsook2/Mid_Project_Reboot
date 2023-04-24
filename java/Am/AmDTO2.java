package Am;

import java.sql.Timestamp;

public class AmDTO2 {
	private int idx;
	private String id;
	private int type;
	private String day_t;
	private String time_s;
	private String time_e;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getDay_t() {
		return day_t;
	}
	public void setDay_t(String day_t) {
		this.day_t = day_t;
	}
	public String getTime_s() {
		return time_s;
	}
	public void setTime_s(String time_s) {
		this.time_s = time_s;
	}
	public String getTime_e() {
		return time_e;
	}
	public void setTime_e(String time_e) {
		this.time_e = time_e;
	}

}
