package com.elead.bai.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Title: NotBlank
 * @Description: com.elead.bai.anno
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/23 9:31
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotBlank {

    String value() default "";
}
