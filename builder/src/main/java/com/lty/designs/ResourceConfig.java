package com.lty.designs;

/**
 * @Author: lty
 * @Date: 2021/1/19 15:33
 */
public class ResourceConfig {


    private String name;
    private int maxTotal;
    private int maxIdle;
    private int minIdle;

    private ResourceConfig(ResourceConfigBuilder builder) {
        this.name = builder.name;//使用static 内部类可以直接拿属性
        this.maxTotal = builder.getMaxTotal();//也可以通过get方法获取
        this.maxIdle = builder.getMaxIdle();
        this.minIdle = builder.getMinIdle();
    }

    public String getName() {
        return name;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public int getMinIdle() {
        return minIdle;
    }

    @Override
    public String toString() {
        return "ResourceConfig{" +
                "name='" + name + '\'' +
                ", maxTotal=" + maxTotal +
                ", maxIdle=" + maxIdle +
                ", minIdle=" + minIdle +
                '}';
    }




    public static class ResourceConfigBuilder {
        private static final  int DEF_MAX_TOTAL = 8 ;
        private static final  int DEF_MAX_IDLE=0;
        private static final  int DEF_MIN_IDLE=0;

        private String name;
        private int maxTotal=DEF_MAX_TOTAL;
        private int maxIdle = DEF_MAX_IDLE;
        private int minIdle = DEF_MIN_IDLE;

        public ResourceConfigBuilder setName(String name) {
            this.name = name;
            return this;//返回this 能够实现链式调用
        }

        public ResourceConfigBuilder setMaxTotal(int maxTotal) {
            this.maxTotal = maxTotal;
            return this;
        }

        public ResourceConfigBuilder setMaxIdle(int maxIdle) {
            this.maxIdle = maxIdle;
            return this;
        }

        public ResourceConfigBuilder setMinIdle(int minIdle) {
            this.minIdle = minIdle;
            return this;
        }

        public String getName() {
            return name;
        }

        public int getMaxTotal() {
            return maxTotal;
        }

        public int getMaxIdle() {
            return maxIdle;
        }

        public int getMinIdle() {
            return minIdle;
        }

        public ResourceConfig build(){
            //校验逻辑放到build()方法之前,先校验 再 创建
            if (minIdle > maxTotal) {
                throw new IllegalArgumentException("无效的参数, cause : minIdle > maxTotal");
            }
            return new ResourceConfig(this);
        }
    }
}
