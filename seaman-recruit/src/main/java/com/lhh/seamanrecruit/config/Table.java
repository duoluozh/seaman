package com.lhh.seamanrecruit.config;

import java.lang.annotation.*;

/**
 * @author zhh
 * @date 2022/4/21 20:50
 * @description
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})//次注解作用于类和字段上
public @interface Table {
    String tableName() default ""; //默认表名为空
    String keyFields() default "id"; //默认主键为id
}
