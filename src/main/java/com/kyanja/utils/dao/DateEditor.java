package com.kyanja.utils.dao;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.util.Date;

import com.ibm.icu.text.SimpleDateFormat;

public class DateEditor extends PropertyEditorSupport {

    public void setAsText(String value) {
      try {
        setValue(new SimpleDateFormat("dd/MM/yyyy").parse(value));
      } catch(ParseException e) {
        setValue(null);
      }
    }

    public String getAsText() {
      String s = "";
      if (getValue() != null) {
         s = new SimpleDateFormat("dd/MM/yyyy").format((Date) getValue());
      }
      return s;
    }
}