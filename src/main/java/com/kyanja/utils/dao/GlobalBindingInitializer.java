package com.kyanja.utils.dao;

import java.util.Date;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class GlobalBindingInitializer {

 /* Initialize a global InitBinder for dates instead of cloning its code in every Controller */

  @InitBinder
  public void binder(WebDataBinder binder) {
    binder.registerCustomEditor(Date.class, new DateEditor());
  }
}
