package tools.seq;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 
 * 序列产生器
 * @author gaoqc5
 */
public class SequenceUtils 
{
    private static SimpleDateFormat formatter = new SimpleDateFormat("yyMMddHHmmss");
    private static Random random = new Random(1000);

  /**
   * 根据年月日时分秒+一个 030816111160+3位的随机数
   * @return
   */
    public static String getSeqByTime()
    {

        return getDate() + getRandom();
    }

    private static String getDate()
    {
        return formatter.format(new Date());
    }

    private static String getRandom()
    {
        return String.valueOf(random.nextInt(1000));
    }
   /**
    * test
    * @param args
    */
    public static void main(String[] args)
    {
        System.out.println(getSeqByTime());
    }
}
