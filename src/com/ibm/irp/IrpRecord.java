package com.ibm.irp;

// Interface for methods related to a data record
public interface IrpRecord {

  public abstract String getKey();
  
  public abstract boolean isSame(IrpRecord _irpRecord);
  
  public abstract void listDifferences(IrpRecord _irpRecord);
  
  public abstract void dumpIt();

  public abstract int fieldValuesLength();

  public abstract String getField(int pos);  
  
}