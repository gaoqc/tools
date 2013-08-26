package tools.pattern;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternUtil
{
    private static final String inputParamPrompt = "\\$\\{[^\\}]+\\}";// 输入正则表达式
    private static Pattern pattern = Pattern.compile(inputParamPrompt);

    public static String replace(String txt, Map<String, String> map)
    {

        Matcher matcher = pattern.matcher(txt);
        StringBuffer sb = new StringBuffer();
        while (matcher.find())
        {
            String oldKey = matcher.group();
            String val = map.get(getKey(oldKey));
            if(null==val){
                throw new IllegalArgumentException("can't found the value of key["+oldKey+"]");
            }
            matcher.appendReplacement(sb, val);
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 去掉标识符
     * 
     * @param oldKey
     * @return
     */
    private static String getKey(String oldKey)
    {
        return oldKey.replace("${", "").replace("}", "");
    }

    public static void main(String[] args)
    {
        String xml = " <SESSIONID>${SESSIONID}</SESSIONID>";
        Map<String, String> map = new HashMap<String, String>();
        map.put("SESSIONID", "1111");
        System.out.println(replace(xml, map));
    }

}
