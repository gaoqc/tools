package tools.print;

import java.util.Collection;

public class PrintUtil
{
  public static void print(String ...str){
      StringBuffer sb=new StringBuffer();
      for(String s:str){
          sb.append(s);
      }
      System.out.println(sb.toString());
  }
 public static void print(Collection<String> collect){
     for(String str:collect){
         print(str);
     }
 }
  
}
