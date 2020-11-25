package com.elead.bai.anno;

import java.lang.annotation.*;

/**
 * @Title: Max
 * @Description: com.elead.bai.anno
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/23 11:12
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Max {

    String options() default "";

    String value() default "";
}