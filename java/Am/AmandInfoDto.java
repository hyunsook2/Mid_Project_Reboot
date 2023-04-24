package Am;

public class AmandInfoDto {
	private int idx;
	private String id;
	private String deptn;
	private String name;
	private String type;
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
	public String getDeptn() {
		return deptn;
	}
	public void setDeptn(String deptn) {
		this.deptn = deptn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
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
	@Override
	public String toString() {
		return "AmandInfoDto [id=" + id + ", deptn=" + deptn + ", name=" + name + ", type=" + type + ", day_t=" + day_t
				+ ", time_s=" + time_s + ", time_e=" + time_e + "]";
	}
	
	
}
