package com.kyanja.utils.dao;

import org.hibernate.id.IdentifierGenerator;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.HibernateException;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.UUID;

public class RandomIdentifierGenerator implements IdentifierGenerator {

  private final static String label = "ORD";
  private final static SecureRandom sr = new SecureRandom();

  public Serializable generate(SessionImplementor sessionImplementor, Object o) throws HibernateException {
    long val = sr.nextLong();
    return label + Long.toString(Math.abs(val), Character.MAX_RADIX);
  }

@Override
public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
	// TODO Auto-generated method stub
	return null;
}
}
