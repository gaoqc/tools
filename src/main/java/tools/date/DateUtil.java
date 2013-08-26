package tools.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

 
public class DateUtil
{
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
//    public static final String YYYYMMDDHHMMSS_ORACLE = "yyyymmddHH24miss";
    public static final String DATE_FORMAT_YYYYMMDDHHMM = "yyyyMMddHHmm";
    public static final String DATE_FORMAT_YYYYMMDDHH = "yyyyMMddHH";
    public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";
    public static final String DATE_FORMAT_YYYYMM = "yyyyMM";
    public static final String DATE_FORMAT_YYYY = "yyyy";
    public static final String DATE_FORMAT_EN_A_YYYYMMDDHHMMSS = "yyyy/MM/dd HH:mm:ss";
    public static final String DATE_FORMAT_EN_A_YYYYMMDDHHMM = "yyyy/MM/dd HH:mm";
    public static final String DATE_FORMAT_EN_A_YYYYMMDDHH = "yyyy/MM/dd HH";
    public static final String DATE_FORMAT_EN_A_YYYYMMDD = "yyyy/MM/dd";
    public static final String DATE_FORMAT_EN_A_YYYYMM = "yyyy/MM";
    public static final String DATE_FORMAT_EN_A_YYYY = "yyyy";
    public static final String DATE_FORMAT_EN_B_YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_EN_B_YYYYMMDDHHMM = "yyyy-MM-dd HH:mm";
    public static final String DATE_FORMAT_EN_B_YYYYMMDDHH = "yyyy-MM-dd HH";
    public static final String DATE_FORMAT_EN_B_YYYYMMDD = "yyyy-MM-dd";
    public static final String DATE_FORMAT_EN_B_YYYYMM = "yyyy-MM";
    public static final String DATE_FORMAT_EN_B_YYYY = "yyyy";
    public static final String DATE_FORMAT_CN_YYYYMMDDHHMMSS = "yyyy'年'MM'月'dd'日' HH'时'mm'分'ss'秒'";
    public static final String DATE_FORMAT_CN_YYYYMMDDHHMM = "yyyy'年'MM'月'dd'日' HH'时'mm'分'";
    public static final String DATE_FORMAT_CN_YYYYMMDDHH = "yyyy'年'MM'月'dd'日' HH'时'";
    public static final String DATE_FORMAT_CN_YYYYMMDD = "yyyy'年'MM'月'dd'日'";
    public static final String DATE_FORMAT_CN_YYYYMM = "yyyy'年'MM'月'";
    public static final String DATE_FORMAT_CN_YYYY = "yyyy'年'";
    public static final int DATE = Calendar.DATE;
    public static final int MONTH = Calendar.MONTH;
    public static final int YEAR = Calendar.YEAR;
    public static final int HOUR_OF_DAY = Calendar.HOUR_OF_DAY;
    public static final int MINUTE = Calendar.MINUTE;
    public static final int SECOND = Calendar.SECOND;
    public static String MATCH_YEAR_4 = "[0-9]{4}";
    public static String MATCH_YEAR_2 = "[0-9]{2}";
    public static String MATCH_MONTH = "(0[0-9]|1[0-2])";
    public static String MATCH_DAY = "(0[1-9]|1[0-9]|2[0-9]|3[0-1])";
    public static String MATCH_HOUR = "([0-1][0-9]|2[0-3])";
    public static String MATCH_MINUTES = "[0-5][0-9]";
    public static String MATCH_SECOND = "[0-5][0-9]";
    

    
    public static String formatDate(Date date, String format)
    {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }
    public static String formatDate(Date date)
    {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT_EN_B_YYYYMMDDHHMMSS);
        return formatter.format(date);
    }
    
    public static Date getCutoffNow(int cutOffType, int cutOffNum)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getCurrentDate());
        cal.add(cutOffType, cutOffNum);
        return cal.getTime();
    }
    public static  Date getCurrentDate(){
        return new Date();
    }
    /**
     * 根据日期模式，把字符串型得日期转换程JAVA的日期
     * 
     * @param dateStr 日期
     * @param format 模式
     * @return java型的日期
     */
    public static Date getFormatDate(String dateStr, String format)  
    {
        // DATE_FORMAT_YYYYMMDDHHMMSS
        Date date = null;
        if ((dateStr == null || "".equals(dateStr)) || (format == null || "".equals(format)))
        {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try
        {
            date = sdf.parse(dateStr);
        }
        catch (ParseException pe)
        {
            pe.printStackTrace();
        }
        return date;
    }
    
    /**
     * @Date 2012-12-04 yugb :获取两个时间之间的秒数差
     * @param startDate
     * @param endDate
     * @return
     */
    public static long getBetweenSeconds(Date startDate, Date endDate)
    {
        long startSec = startDate.getTime()/1000;
        long endSec = endDate.getTime()/1000;
        if(startSec > endSec)
        {
            return startSec-endSec;
        }
        else
        {
            return endSec-startSec;
        }
        
    }
    public static void main(String[] args)
    {
        System.out.println(formatDate(getCutoffNow(Calendar.SECOND,60)));
    }
    

}
