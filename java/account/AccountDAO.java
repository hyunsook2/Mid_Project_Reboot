package account;

import java.util.List;

import common.JDBConnPool;

public class AccountDAO extends JDBConnPool{
   public AccountDAO() {
      super();
   }
   
   public void insertData(List<AccountDTO> accountList) {
       try {
           String sql = "INSERT INTO INFO(id, deptn, name, pass, grade,pnum,ad) VALUES (?, ?, ?, ?, ?,?,?)";
           psmt = con.prepareStatement(sql);

           for (AccountDTO account : accountList) {
               psmt.setString(1, account.getId());
               psmt.setString(2, account.getDeptn());
               psmt.setString(3, account.getName());
               psmt.setString(4, account.getPass());
               psmt.setString(5, account.getGrade());
               psmt.setString(6, account.getPnum());
               psmt.setString(7, account.getAd());

               psmt.executeQuery();
           }

           close();
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
   
   
   
}