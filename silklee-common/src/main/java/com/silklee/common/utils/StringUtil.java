package com.silklee.common.utils;

import cn.hutool.core.date.DateUtil;
import lombok.experimental.UtilityClass;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.Serializable;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@UtilityClass
public class StringUtil {

    private static final PasswordEncoder ENCODER = new BCryptPasswordEncoder();

    public List<Integer> splitToIntegerList(String str, String separator) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        String[] strArray = str.split(separator);
        for (int i = 0; i < strArray.length; i++) {
            list.add(Integer.parseInt(strArray[i]));
        }
        return list;
    }

    public List<Integer> splitToIntegerList(String str) {
        return splitToIntegerList(str, ",");
    }

    public Set<Integer> splitToIntegerSet(String str, String separator) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return new HashSet<>();
        }
        Set<Integer> set = new HashSet<>();
        String[] strArray = str.split(separator);
        for (int i = 0; i < strArray.length; i++) {
            set.add(Integer.parseInt(strArray[i]));
        }
        return set;
    }

    public Set<Integer> splitToIntegerSet(String str) {
        return splitToIntegerSet(str, ",");
    }

    public Set<Long> splitToLongSet(String str, String separator) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return new HashSet<>();
        }
        Set<Long> set = new HashSet<>();
        String[] strArray = str.split(separator);
        for (int i = 0; i < strArray.length; i++) {
            set.add(Long.parseLong(strArray[i]));
        }
        return set;
    }

    public Set<Long> splitToLongSet(String str) {
        return splitToLongSet(str, ",");
    }

    public Set<String> splitToStringSet(String str, String separator) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return new HashSet<>();
        }
        Set<String> set = new HashSet<>();
        String[] strArray = str.split(separator);
        for (int i = 0; i < strArray.length; i++) {
            set.add(strArray[i]);
        }
        return set;
    }

    public Set<String> splitToStringSet(String str) {
        return splitToStringSet(str, ",");
    }

    public List<String> splitToStringList(String str, String separator) {
        if (str == null || str.length() == 0) {
            return null;
        }
        List<String> list = new ArrayList<>();
        String[] strArray = str.split(separator);
        for (int i = 0; i < strArray.length; i++) {
            list.add(strArray[i]);
        }
        return list;
    }

    public List<String> splitToStringList(String str) {
        return splitToStringList(str, ",");
    }

    public Boolean matches(String str0, String str1) {
        return ENCODER.matches(str0, str1);
    }

    public String getRandomStr(Integer length) {
        String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(base.charAt(random.nextInt(base.length())));
        }
        return sb.toString();
    }

    public String getRandomStr() {
        return getRandomStr(4);
    }

    public boolean isMac(String mac) {

        String regex = "([A-F0-9]{2}:){5}[A-F0-9]{2}";

        return Pattern.matches(regex, mac);
    }

    /**
     * 转义字符串中的特殊字符，防止sql报错``
     *
     * @return
     */
    public String replaceEscapeCharacter(String s) {
        if (s == null) {
            return null;
        }
        return s.replace("\\", "\\\\")
                .replace("_", "\\_")
                .replace("%", "\\%")
                .replace("'", "\\'");
    }

    public boolean isNotChinaPhone(String phone) {
        String regExp = "^(1[0-9][0-9])\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(phone);
        return !m.matches();
    }

    public <T extends Serializable> String listToString(List<T> list, String separator) {
        if (list == null) {
            return null;
        }
        if (list.size() == 0) {
            return "";
        }
        StringBuffer str = new StringBuffer();
        str.append(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            str.append(separator).append(list.get(i));
        }
        return str.toString();
    }

    public <T extends Serializable> String listToString(List<T> list) {
        return listToString(list, ",");
    }

    /**
     * 判断是否为纯数字
     */
    public boolean isNumber(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    public String toString(Object object) {
        if (object == null) {
            return "";
        }
        return object.toString();
    }

    //生成随机编号编号
    public String createResourcesCode(String type) {
        //String type = ResourcesTypeEnum.getByName(resourcesType).name().substring(0,1);
        String date = DateUtil.format(new Date(), "yyyyMMdd");
        int randomNums = (int) (Math.random() * 900) + 100;
        return type + date + randomNums;
    }

}
