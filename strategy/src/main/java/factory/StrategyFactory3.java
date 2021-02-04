package factory;

import strategy.Strategy;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author: lty
 * @Date: 2021/2/4 15:18
 * 使用注解反射的方式,获取具体策略类
 */
public class StrategyFactory3 {
    private static final HashMap<String, Strategy> strategys = new HashMap<>();


    //通过反射方式,创建新对象,, 或者可以通过new的方式来创建对象,避免了使用if else
    public  static void initial(String packagePath) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        if (packagePath.isEmpty()) {
            throw new IllegalArgumentException("包路径不能为空");
        }

        getClasses(packagePath);


    }

    private static List<String> getClasses(String packagePath) throws UnsupportedEncodingException, MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        URL resource = Thread.currentThread().getContextClassLoader().getResource(packagePath);
        String protocol = resource.getProtocol();
        extracted(resource, protocol,packagePath);
        return null;
    }

    private static void extracted(URL resource, String protocol, String packagePath) throws UnsupportedEncodingException, MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        if ("file".equals(protocol)) {
            String filePath = URLDecoder.decode(resource.getFile(), "UTF-8");


            //查询文件
            File file = new File(filePath);
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File file1 : files) {
                    extracted(file1.toURL(),file1.toURL().getProtocol(), packagePath);
                }
            }
            if (filePath.endsWith(".class")) {
                String substring = filePath.substring(filePath.lastIndexOf("/")+1);
                String clazzName =  substring.split("\\.")[0];
                //检查是否包含注解
                String clzn=packagePath+"."+clazzName;
                System.out.println(clzn);
                Class<?> aClass = Class.forName(clzn);
                if (aClass.isAnnotationPresent(annotation.Strategy.class)) {
                    String name = aClass.getAnnotation(annotation.Strategy.class).value();
                    strategys.put(name, (Strategy) aClass.newInstance());
                }

            }

        }
    }


    public static Strategy getStrategy(String name) throws IllegalAccessException, InstantiationException {
        Strategy strategy = strategys.get(name);
        return strategy;
    }
}
