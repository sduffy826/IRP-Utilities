package com.ibm.irp;

// Abstract class that implmenets the IrpRecord interface; it has
// the common code for 'record' processing
public abstract class IrpRecordAbstract implements IrpRecord {
  
  protected static final boolean DEBUGIT = false;
  protected String[] fieldValues; 
  protected IrpFieldsAbstract irpFields;
  protected IrpTables irpTableBeingProcessed;
    
  /* The getKey() method is implemented in the concrete classes */
  public abstract String getKey();
  
  // Returns the number of fields in the record
  public int fieldValuesLength() {
    return fieldValues.length;
  }
  
  // Dump the entire record to the console
  public void dumpIt() {
    for (int i = 0; i < fieldValues.length; i++) {
       System.out.println("  Field name: " + irpFields.getField(i) +
                             " Value: " + fieldValues[i]);
    }   
    return;
  }
  
  // Get field at certain position
  public String getField(int _pos) {
    if ((_pos >= 0 ) && (_pos < fieldValues.length) ) {
        return fieldValues[_pos];        
    }
    else {
      return "** Invalid Col Pos";
    }
  }
  
  //Compares my field values to the ones in the document passed in, note since we may have a case
  // where we might have more fields in one record then the other I made it so this just reports that
  // the structures are different but only compares the fields common in both... so it'll report same
  // if all the common fields match even though structures don't match... what i wanted :)
  public boolean isSame(IrpRecord _irpRecord) {
    boolean rtnValue = false;
    
    int len2Check = Math.min(fieldValues.length, _irpRecord.fieldValuesLength());
    
    if ( fieldValues.length != _irpRecord.fieldValuesLength()) {
      System.out.println("Structures don't match comparing first " + Integer.toString(len2Check) + " fields");
    }
    
    if ( len2Check > 0 ) {
      rtnValue = true;
      int pos = 1; // ignore value 0 (mandt)
      while ((pos < len2Check ) && (rtnValue)) {
        rtnValue = (fieldValues[pos].trim().equalsIgnoreCase(_irpRecord.getField(pos).trim()));
        if (!rtnValue) {
          if (DEBUGIT) {
            System.out.println("** Different: " + Integer.toString(pos) +
                               " old:" + fieldValues[pos] + " new:" + _irpRecord.getField(pos));
          }
        }          
        pos++;
      }
    }    
    return rtnValue;
  }
    
  // List the diffferences between the records
  public void listDifferences(IrpRecord _irpRecord) {
    int len2Write = Math.min(fieldValues.length, _irpRecord.fieldValuesLength());
       
    for (int i = 0; i < len2Write; i++) {
      if (!fieldValues[i].trim().equalsIgnoreCase(_irpRecord.getField(i).trim())) {
        System.out.println("Field name: " + irpFields.getField(i) + " " +
                            fieldValues[i] + " -> " + _irpRecord.getField(i));       
      }      
    }  
    return;
  } 
     
}
