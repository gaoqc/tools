package tools.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class FileTool
{
    /**
     * 以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件。
     */
    public static String readFileByBytes(String fileName)
    {
        File file = new File(fileName);
        InputStream in = null;
        StringBuffer sb = new StringBuffer();
        try
        {
            // System.out.println("以字节为单位读取文件内容，一次读一个字节：");
            // 一次读一个字节
            in = new FileInputStream(file);
            int ch = -1;
            while ((ch = in.read()) != -1)
            {
                sb.append((char) ch);
            }
            in.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return "";
        }
        return sb.toString();
        // try {
        // System.out.println("以字节为单位读取文件内容，一次读多个字节：");
        // // 一次读多个字节
        // byte[] tempbytes = new byte[100];
        // int byteread = 0;
        // in = new FileInputStream(fileName);
        // ReadFromFile.showAvailableBytes(in);
        // // 读入多个字节到字节数组中，byteread为一次读入的字节数
        // while ((byteread = in.read(tempbytes)) != -1) {
        // System.out.write(tempbytes, 0, byteread);
        // }
        // } catch (Exception e1) {
        // e1.printStackTrace();
        // } finally {
        // if (in != null) {
        // try {
        // in.close();
        // } catch (IOException e1) {
        // }
        // }
        // }
    }

    /**
     * 以字符为单位读取文件，常用于读文本，数字等类型的文件
     */
    public static String readFileByChars(String fileName)
    {
        File file = new File(fileName);
        Reader reader = null;
        StringBuffer sb = new StringBuffer();
        try
        {
            // System.out.println("以字符为单位读取文件内容，一次读一个字节：");
            // 一次读一个字符
            reader = new InputStreamReader(new FileInputStream(file));
            int ch;
            while ((ch = reader.read()) != -1)
            {
                // 对于windows下，\r\n这两个字符在一起时，表示一个换行。
                // 但如果这两个字符分开显示时，会换两次行。
                // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
                sb.append((char) ch);
                // if (((char) tempchar) != '\r') {
                // System.out.print((char) tempchar);
                // }
            }
            reader.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return sb.toString();
        // try {
        // System.out.println("以字符为单位读取文件内容，一次读多个字节：");
        // // 一次读多个字符
        // char[] tempchars = new char[30];
        // int charread = 0;
        // reader = new InputStreamReader(new FileInputStream(fileName));
        // // 读入多个字符到字符数组中，charread为一次读取字符数
        // while ((charread = reader.read(tempchars)) != -1) {
        // // 同样屏蔽掉\r不显示
        // if ((charread == tempchars.length)
        // && (tempchars[tempchars.length - 1] != '\r')) {
        // System.out.print(tempchars);
        // } else {
        // for (int i = 0; i < charread; i++) {
        // if (tempchars[i] == '\r') {
        // continue;
        // } else {
        // System.out.print(tempchars[i]);
        // }
        // }
        // }
        // }
        //
        // } catch (Exception e1) {
        // e1.printStackTrace();
        // } finally {
        // if (reader != null) {
        // try {
        // reader.close();
        // } catch (IOException e1) {
        // }
        // }
        // }
    }

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static String readFileByLines(String fileName)
    {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sb = new StringBuffer();
        try
        {
            // System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String line = null;
            // 一次读入一行，直到读入null为文件结束
            while ((line = reader.readLine()) != null)
            {
                // 显示行号
                // System.out.println("line " + line + ": " + tempString);
                sb.append(line);
            }
            reader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (reader != null)
            {
                try
                {
                    reader.close();
                }
                catch (IOException e1)
                {
                }
            }
        }
        return sb.toString();
    }

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static List<String> readFileLines(String fileName)
    {
        BufferedReader reader = null;
        List<String> list = new ArrayList<String>();
        try
        {
            // System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"GB2312"));
    
            String line = null;
            // 一次读入一行，直到读入null为文件结束
            while ((line = reader.readLine()) != null)
            {
                // 显示行号
                list.add(line);
            
            }
            reader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (reader != null)
            {
                try
                {
                    reader.close();
                }
                catch (IOException e1)
                {
                }
            }
        }
        return list;
    }
    
    /**
     * 随机读取文件内容
     */
    public static String readFileByRandomAccess(String fileName)
    {
        RandomAccessFile randomFile = null;
        StringBuffer sb = new StringBuffer();
        try
        {
            // System.out.println("随机读取一段文件内容：");
            // 打开一个随机访问文件流，按只读方式
            randomFile = new RandomAccessFile(fileName, "r");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            // 读文件的起始位置
            int beginIndex = (fileLength > 4) ? 4 : 0;
            // 将读文件的开始位置移到beginIndex位置。
            randomFile.seek(beginIndex);
            byte[] bytes = new byte[10];
            int byteread = 0;
            // 一次读10个字节，如果文件内容不足10个字节，则读剩下的字节。
            // 将一次读取的字节数赋给byteread
            while ((byteread = randomFile.read(bytes)) != -1)
            {
                sb.append(new String(bytes, 0, byteread));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (randomFile != null)
            {
                try
                {
                    randomFile.close();
                }
                catch (IOException e1)
                {
                }
            }
        }
        return sb.toString();
    }
   
    public static void main(String[] args) throws IOException
    {
        
//        for(String line:readFileLines("d:/test/aaa.log")){
//            System.out.println(line);
//        }

    }
    
   
 
   
 

}