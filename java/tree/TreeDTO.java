package tree;

public class TreeDTO {
    private int level;
    private String deptNm;
    private String path;
    private String deptCd;
    private String parDeptCd;
    private String id;

    public TreeDTO() {
    }

    public TreeDTO(int level, String deptNm, String path, String deptCd, String parDeptCd, String id) {
        this.level = level;
        this.deptNm = deptNm;
        this.path = path;
        this.deptCd = deptCd;
        this.parDeptCd = parDeptCd;
        this.id= id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getDeptNm() {
        return deptNm;
    }

    public void setDeptNm(String deptNm) {
        this.deptNm = deptNm;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDeptCd() {
        return deptCd;
    }

    public void setDeptCd(String deptCd) {
        this.deptCd = deptCd;
    }

    public String getParDeptCd() {
        return parDeptCd;
    }

    public void setParDeptCd(String parDeptCd) {
        this.parDeptCd = parDeptCd;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
    
    
    
}