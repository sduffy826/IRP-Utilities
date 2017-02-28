package com.ibm.irp;

// Interface to define 'field' related methods
public interface IrpFields {

  public abstract String[] getFields();

  public abstract String getField(int _pos);

  public abstract void dumpFieldNames();  
  
}