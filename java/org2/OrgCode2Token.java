package org2;

import java.util.Vector;

public class OrgCode2Token {

    private static final String SEP="/";
    private String test="/0010100000000/0020200000000/0030300000000";
    public static int count(String str){
        String [] split=str.split(SEP);
        return split.length-1;
    }
    public static String[] split(String str){
        String [] split=str.split(SEP);
        String[] sp=new String[split.length-1];
        for(int i=0;i<sp.length;i++){
            sp[i]=split[i+1];
        }
        return sp;
    }
    public static void makeTee(Vector vv,String trees){
        
        if(count(trees)==1){
            Vector v=new Vector();
            if(!vv.contains((split(trees))[0])){
                v.add((split(trees))[0]);
                return ;
            }return ;
            
        }else{
            if(!vv.contains((split(trees))[1])){
                makeTee(vv,trees.substring(11));
            }else{
                return ;
            }
        }
    }
    public static void print(Vector v){
        if(v.size()==0){
            return ;
        }else if(v.size()==1){
            return ;
        }else{
            print((Vector)v.get(1));
        }
    }
}