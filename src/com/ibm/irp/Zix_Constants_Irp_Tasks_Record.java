package com.ibm.irp;

public class Zix_Constants_Irp_Tasks_Record extends IrpRecordAbstract {
    
  // Constructor is passed in a string containing data record, it's in csv format
  // so we split into string array (fieldValues)
  public Zix_Constants_Irp_Tasks_Record(String _record) {
    fieldValues = _record.split(",");
    irpTableBeingProcessed = IrpTables.ZIX_CONSTANTS_IRP_TASKS;
    irpFields = (IrpFieldsAbstract) IrpFieldsHelper.getInstance(irpTableBeingProcessed);
    
    if (DEBUGIT) {
      for (int i = 0; i < fieldValues.length; i++) {
        System.out.println("Field name: " + irpFields.getField(i) +
                           " value at [" +Integer.toString(i) + "] : " +
                           fieldValues[i]);
      }    
    }
  }   
  
  // Define what the key is for this record; it's the first value role_key
  public String getKey() {
    if (fieldValues.length > 2) {
      return fieldValues[0] + fieldValues[1] + "/" + fieldValues[2];
    }
    else {
      return "**INVALID**";
    }
  }     
}
