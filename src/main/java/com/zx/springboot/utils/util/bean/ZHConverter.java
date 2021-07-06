package com.zx.springboot.utils.util.bean;


import java.io.*;
import java.util.*;

public class ZHConverter {
    private Properties charMap = new Properties();
    private Set<String> conflictingSets  = new HashSet<String>();
    public static final int TRADITIONAL = 0;
    public static final int SIMPLIFIED = 1;
    private static final int NUM_OF_CONVERTERS = 2;
    private static final ZHConverter[] converters = new ZHConverter[NUM_OF_CONVERTERS];
    private static final String[]  propertyFiles = new String[2];
    private static String path = "/Users/suven/project/workspace/redfinger/hsz/gc-base-utils/src/main/resources/";
    //
    static {

        propertyFiles[TRADITIONAL] = path+"zh2Hant.properties"; //附件下载
        propertyFiles[SIMPLIFIED] = path+"zh2Hans.properties";  //附件下载
    }
    public String sqlName = "poems_201809052059.sql";
    public String intFile = path + sqlName;
    public String outFile = path +"JT_" + sqlName;
    public String outFtFile = path +"FT_" + sqlName;

    public void setPath(){
        intFile = path + sqlName;
        outFile = path +"jt_" + sqlName;
        outFtFile = path +"ft_" + sqlName;
    }

    /**
     *
     * @param converterType 0 for traditional and 1 for simplified
     * @return
     */
    public static ZHConverter getInstance(int converterType) {
        if (converterType >= 0 && converterType < NUM_OF_CONVERTERS) {
            if (converters[converterType] == null) {
                synchronized(ZHConverter.class) {
                    if (converters[converterType] == null) {
                        converters[converterType] = new ZHConverter(propertyFiles[converterType]);
                    }
                }
            }
            return converters[converterType];
        } else {
            return null;
        }
    }

    public static String convert(String text, int converterType) {
        ZHConverter instance = getInstance(converterType);
        return instance.convert(text);
    }


    private ZHConverter(String propertyFile) {
        InputStream is = null;
//        is = getClass().getResourceAsStream(propertyFile);
        File file = new File(propertyFile);
        BufferedReader reader = null;
        try {
            is = new FileInputStream(file);
            if (is != null) {
                reader = new BufferedReader(new InputStreamReader(is));
                charMap.load(reader);
            }
        } catch (FileNotFoundException e) {
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (reader != null)
                    reader.close();
                if (is != null)
                    is.close();
            } catch (IOException e) {
            }
        }
        initializeHelper();
    }

    @SuppressWarnings("rawtypes")
    private void initializeHelper() {
        Map<String,Integer> stringPossibilities = new HashMap<String,Integer>();
        Iterator iter = charMap.keySet().iterator();
        while (iter.hasNext()) {
            String key = (String) iter.next();
            if (key.length() >= 1) {
                for (int i = 0; i < (key.length()); i++) {
                    String keySubstring = key.substring(0, i + 1);
                    if (stringPossibilities.containsKey(keySubstring)) {
                        Integer integer = (Integer)(stringPossibilities.get(keySubstring));
                        stringPossibilities.put(keySubstring, new Integer(
                                integer.intValue() + 1));
                    } else {
                        stringPossibilities.put(keySubstring, new Integer(1));
                    }
                }
            }
        }
        iter = stringPossibilities.keySet().iterator();
        while (iter.hasNext()) {
            String key = (String) iter.next();
            if (((Integer)(stringPossibilities.get(key))).intValue() > 1) {
                conflictingSets.add(key);
            }
        }
    }

    public String convert(String in) {
        StringBuilder outString = new StringBuilder();
        StringBuilder stackString = new StringBuilder();
        for (int i = 0; i < in.length(); i++) {
            char c = in.charAt(i);
            String key = "" + c;
            stackString.append(key);
            if (conflictingSets.contains(stackString.toString())) {

            } else if (charMap.containsKey(stackString.toString())) {
                outString.append(charMap.get(stackString.toString()));
                stackString.setLength(0);
            } else {
                CharSequence sequence = stackString.subSequence(0, stackString.length() - 1);
                stackString.delete(0, stackString.length() - 1);
                flushStack(outString, new StringBuilder(sequence));
            }
        }
        flushStack(outString, stackString);
        return outString.toString();
    }

    public static final boolean isChineseCharacter(String chineseStr) {
        char[] charArray = chineseStr.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if ((charArray[i] >= 0x4e00) && (charArray[i] <= 0x9fbb)) {
                return true;
            }
        }
        return false;
    }
    private void flushStack(StringBuilder outString, StringBuilder stackString) {
        while (stackString.length() > 0){
            if (charMap.containsKey(stackString.toString())) {
                Object ftObj = charMap.get(stackString.toString());
                if(isChineseCharacter(ftObj.toString())){
                    outString.append(ftObj);
                }else {
                    outString.append(stackString);
                }
                stackString.setLength(0);
            } else {
                outString.append("" + stackString.charAt(0));
                stackString.delete(0, 1);
            }
        }
    }
    String parseOneChar(String c) {
        if (charMap.containsKey(c)) {
            return (String) charMap.get(c);

        }
        return c;
    }

    public String copyLine(String sourceFile, String targetFile,int type){
        InputStream is = null;
//        is = getClass().getResourceAsStream(propertyFile);
        File file = new File(sourceFile);
        File tFile = new File(targetFile);
        BufferedReader reader = null;
        BufferedWriter writer = null;
        ZHConverter converter = ZHConverter.getInstance(type);
        try {
            is = new FileInputStream(file);
            if (is != null) {
                reader = new BufferedReader(new InputStreamReader(is));
                writer = new BufferedWriter(new FileWriter(tFile,true));
                String str = null;
                while((str = reader.readLine()) != null){
                    //System.out.println(str);//此时str就保存了一行字符串
                    String simplifiedStr = converter.convert(str);
                    System.out.println(simplifiedStr);//此时str就保存了一行字符串
                    writer.write(simplifiedStr);
                    writer.newLine();
                }
            }
        } catch (FileNotFoundException e) {
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (reader != null)
                    reader.close();
                if (is != null)
                    is.close();
                if (writer != null) {
                    writer.flush();
                    writer.close();
                }
            } catch (IOException e) {
            }
        }
        return null;
    }
    public static void main(String[] args)
    {
        // 繁体转简体
        ZHConverter converter = ZHConverter.getInstance(ZHConverter.SIMPLIFIED);
//        String str = ",(71663,'麥麨朝充食，松明夜當燈。|蔽門麻菶菶，護壁石層層。|老嫗逢人哭，吾兒在謝陵。','S','戴復古')\n";
////        String simplifiedStr = converter.convert("草泥馬個比比了個比比喝水和氣身材興奮生意");
//        String simplifiedStr2 = converter.convert(str);
//        System.out.println(simplifiedStr2);
        converter.sqlName="poetry_author_201809052059.sql";
        converter.setPath();
        converter.copyLine(converter.intFile,converter.outFtFile, ZHConverter.TRADITIONAL);
        converter.copyLine(converter.intFile,converter.outFile, ZHConverter.SIMPLIFIED);
//        System.out.println(simplifiedStr);
//        System.out.println(simplifiedStr2);

        // 简体转繁体
//        ZHConverter converter2 = ZHConverter.getInstance(ZHConverter.TRADITIONAL);
//        String traditionalStr = converter2.convert("长隆饭店广州广东电视台");
//        System.out.println(traditionalStr);
    }

}