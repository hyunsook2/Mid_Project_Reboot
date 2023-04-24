package org2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Tree_arch extends AbstractDataBase{
   
    public Tree_arch() throws Exception {

        super();
    }
   
    //Timestamp time
 public StringBuffer getMenuTreeString(String time) throws Exception {

     StringBuffer menuString = new StringBuffer(2048);

     String[] sel_menu_id = null;

     String menu_id   = "";      //조직코드
     String menu_nm   = "";   //조직명
     String []menu_type  = null;   //조직Type

     long   menu_level = 0;   // 조직Level이 아닌 조회된 계층의 Level

     int    div_cnt   = 0;   // <div> Tag Count

     String javascript_1 = "";
     String javascript_2 = "";
     String javascript_3 = "expandsub('1'); \r";

     try{

        
        
         Vector select = getTree(time);//time
         sel_menu_id = new String[select.size()];
        
        
        
         int h = select.size();
 
         for(int i=0;i<h;i++){
             sel_menu_id[i] = ((TreeDTO)select.get(i)).getOrgcode();
        
         }     
         div_cnt++;

         menuString.append("<div id=PG0 nowrap> \r");
        
            int i=0;
         for(i=0;i<h;i++){

             if (i!=0) {
                 javascript_1 = "javascript:togglesub('"+i+"')";
                javascript_2 = "javascript:expandsub('"+i+"');goThere('"+menu_id+"')";
                
                  if( ((TreeDTO)select.get(i)).getOrglevel() == menu_level ) {                       
                      menuString.append("<span id=SG"+i+"><IMG SRC='image/minus.gif' BORDER=0 ID=IMG"+i+">");
                     menuString.append("<A HREF=\""+javascript_2+"\" ID=A"+i+" class=fldblue> "+ menu_nm +"</A></span><br> \r");
                 } else if ( ((TreeDTO)select.get(i)).getOrglevel() > menu_level ) {                      
                     menuString.append("<span id=SG"+i+"><A HREF=\""+javascript_1+"\"><IMG SRC='image/plus.gif' BORDER=0 ID=IMG"+i+"></A>"
                             +"<A HREF=\""+javascript_2+"\" ID=A"+i+" class=fldblue> "+ menu_nm +"</A></span><br> \r");
                     menuString.append("<div id=PG"+i+" style='display:none;margin-left=15' nowrap> \r");
                    
                     div_cnt++;
                 } else if ( ((TreeDTO)select.get(i)).getOrglevel() < menu_level ) {                      
                     menuString.append("<span id=SG"+i+"><IMG SRC='image/minus.gif' BORDER=0 ID=IMG"+i+"><A HREF=\""+javascript_2+"\" ID=A"+i+" class=fldblue> "+ menu_nm +"</A></span><br> \r");
                    
                     for (int j=0; j < (menu_level  - ((TreeDTO)select.get(i)).getOrglevel()); j++) {
                         menuString.append("</div> \r");
                        
                         div_cnt--;
                     }
                 }
                }        

             menu_id   = ((TreeDTO)select.get(i)).getOrgcode(); 

              menu_nm   = ((TreeDTO)select.get(i)).getOrgname(); 
             menu_level  = ((TreeDTO)select.get(i)).getOrglevel(); 
             menu_type  = ((TreeDTO)select.get(i)).getOrder2(); 

            
         }
         menuString.append("<span id=SG"+i+"><IMG SRC='image/minus.gif' BORDER=0 ID=IMG"+i+"><A HREF=\""+javascript_2+"\" ID=A"+i+" class=fldblue> "+ menu_nm +"</A></span><br> \r");

         for (int j=0; j < div_cnt; j++)  {
            
             menuString.append("</div> \r");
         }

         return menuString;
        
     }catch(Exception e){
        
         e.printStackTrace();
     }
     return null;
 }
 
 public Vector getTree(String time)
 {//Timestamp time
    
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        Vector v = new Vector();
        StringBuffer sb=new StringBuffer();
        sb.append("select A.orgcode, A.orguppercode ,")
        .append(" A.orgname , A.orglevel, A.order2 ")
  .append(" from (select orgcode, ")
  .append(" orguppercode, ")
  .append(" orgname, ")
  .append(" level orglevel, ")
  .append(" SYS_CONNECT_BY_PATH(to_char(orglevel,'fm000')||orgcode,'/') order2 ")
  .append(" from org_base ")
  .append(" start with  orguppercode = '00000000' ")
  .append(" connect by prior  orgcode = orguppercode ")
  .append(" and to_date(? ,'yyyy-mm-dd') between orgstartdate and orgenddate) A ")
  .append(" where a.orgcode <> '00000000' ")
  .append(" order by A.orgcode ");
       
        System.out.println(sb.toString());
       
  try {
     
   conn= getConnection();
   psmt = conn.prepareStatement(sb.toString());
   psmt.setString(1,time);
   rs=psmt.executeQuery();
   
   while(rs.next())
   {
       int i = 1;
       String orgcode = rs.getString(i++);
       String orguppercode = rs.getString(i++);
       String orgname = rs.getString(i++);
       int orglevel = rs.getInt(i++);
       String order2 = rs.getString(i++);
      
       TreeDTO tree = new TreeDTO();
      
       tree.setOrgcode(orgcode);
       tree.setOrguppercode(orguppercode);
       tree.setOrgname(orgname);
       tree.setOrglevel(orglevel);
       tree.setOrder2(OrgCode2Token.split(order2));
      
       v.add(tree);
   }

  } catch (SQLException e) {
   System.out.println("SQL Exception  "+e);
  }finally{
   close(conn,psmt,rs);
  }
  
       
        return v;
       
 }

}