package com.ibm.irp;

// See comments in zix_irp_doc_act... logic is similar in each of
// the *_Record classes
public class Zix_Irp_Act_Map_Record extends IrpRecordAbstract {
    
  public Zix_Irp_Act_Map_Record(String _record) {
    fieldValues = _record.split(",");
    irpTableBeingProcessed = IrpTables.ZIX_IRP_ACT_MAP;
    irpFields = (IrpFieldsAbstract) IrpFieldsHelper.getInstance(irpTableBeingProcessed);
    
    if (DEBUGIT) {
      for (int i = 0; i < fieldValues.length; i++) {
        System.out.println("Field name: " + irpFields.getField(i) +
                           " value at [" +Integer.toString(i) + "] : " +
                           fieldValues[i]);
      }    
    }
  }   
  
  public String getKey() {
    if (fieldValues.length > 1) {
      return fieldValues[1];  // Action code is the key
    }
    else {
      return "**INVALID**";
    }
  }     
}
