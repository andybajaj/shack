/*
 * 
 */

package com.gaming.shack.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * The Interface ShackTX.
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Transactional(value = "shackTxm", propagation = Propagation.REQUIRES_NEW, timeout = 600)
public @interface ShackNewTX {

}
