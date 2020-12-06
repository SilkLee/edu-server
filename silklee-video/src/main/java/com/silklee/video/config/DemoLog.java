package com.silklee.video.config;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DemoLog {
    enum Type{
        DEFAULT("默认"), SPECI("特殊"), NORMAL("一般");

        private String name;
        Type(String name){
            this.name = name;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }

    String name () default "";
    String value() default "value";
    Type logType() default Type.DEFAULT;
}
