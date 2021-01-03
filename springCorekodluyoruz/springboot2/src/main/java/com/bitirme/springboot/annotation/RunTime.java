package com.bitirme.springboot.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = { ElementType.METHOD })
public @interface RunTime {

	boolean active();
	//yorum
}
