package com.example.kafka.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class CloneUtils {

    private static Logger logger = LoggerFactory.getLogger(CloneUtils.class);

    public static Object clone(Object o) throws Exception
    {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out;
        try
        {
            out = new ObjectOutputStream(byteOut);
            out.writeObject(o);

            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());

            ObjectInputStream in = new ObjectInputStream(byteIn);

            Object retObj = in.readObject();

            return retObj;
        }
        catch (IOException e)
        {
            logger.error("对象" + o.getClass().getName() + "克隆异常：", e);

            throw new Exception();
        }
        catch (ClassNotFoundException e)
        {
            logger.error("对象" + o.getClass().getName() + "克隆异常：", e);

            throw new Exception();
        }
    }
}
