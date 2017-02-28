package com.ibm.irp;

import java.util.Arrays;

// Abstract class for 'field' processing; it implements the IrpFields interface
// and has the common code.
abstract class IrpFieldsAbstract implements IrpFields {
  protected static final boolean DEBUG = true;
  
  protected String[] fieldList;
  
  /* (non-Javadoc)
   * @see com.ibm.irp.IrpFields#getFields()
   */
  public String[] getFields() {
    return Arrays.copyOf(fieldList, fieldList.length);
  }
  
  /* (non-Javadoc)
   * @see com.ibm.irp.IrpFields#getField(int)
   */
  public String getField(int _pos) {
    if (( _pos >= 0 ) && ( _pos < fieldList.length )) {
      return fieldList[_pos];
    }
    else {
      return "Invalid position passed in";
    }
  }
  
  public void dumpFieldNames() {
    for (int i = 0; i < fieldList.length; i++ ) {
      System.out.println("[" + Integer.toString(i) + "] : " + fieldList[i]);
    }
  }  
}
