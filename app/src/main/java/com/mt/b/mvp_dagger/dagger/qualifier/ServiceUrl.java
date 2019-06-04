package com.mt.b.mvp_dagger.dagger.qualifier;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Author : ZSK
 * Date : 2019/6/3
 * Description :
 */
@Qualifier
@Documented
@Retention(RUNTIME)
public @interface ServiceUrl {
}
