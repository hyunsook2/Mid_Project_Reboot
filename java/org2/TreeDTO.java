package org2;

public class TreeDTO {
    
    private String orgcode;
    private String orguppercode;
    private String orgname;
    private int orglevel;
    private String []order2;

    public TreeDTO() {
        
    }
    public TreeDTO(String orgcode, String orguppercode, String orgname,
            int orglevel, String []order2) {
        
        this.orgcode = orgcode;
        this.orguppercode = orguppercode;
        this.orgname = orgname;
        this.orglevel = orglevel;
        this.order2 = order2;
    }

    public String[] getOrder2() {
        return order2;
    }

    public void setOrder2(String[] order2) {
        this.order2 = order2;
    }

    public String getOrgcode() {
        return orgcode;
    }

    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode;
    }

    public int getOrglevel() {
        return orglevel;
    }

    public void setOrglevel(int orglevel) {
        this.orglevel = orglevel;
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    public String getOrguppercode() {
        return orguppercode;
    }

    public void setOrguppercode(String orguppercode) {
        this.orguppercode = orguppercode;
    }
}