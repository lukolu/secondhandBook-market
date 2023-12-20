package com.atguigu.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WebUtils {
    public static <T> T copyParameterToBean(T object, Map map)
    {
        try {
            BeanUtils.populate(object,map);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return object;
    }

    public static int parseInt(String strInt,int defaultInt)
    {
        try {
            return Integer.parseInt(strInt);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return defaultInt;
    }

}
