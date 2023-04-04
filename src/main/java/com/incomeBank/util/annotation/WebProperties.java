package com.incomeBank.util.annotation;

import javax.inject.Qualifier;
import java.lang.annotation.*;

/**
 * Created by s_tayari on 8/27/2016.
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Documented
public @interface WebProperties {
}
