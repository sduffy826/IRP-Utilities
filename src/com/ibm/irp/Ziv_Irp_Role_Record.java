package com.ibm.irp;

// See comments in zix_irp_doc_act... logic is similar in each of
// the *_Record classes
public class Ziv_Irp_Role_Record extends IrpRecordAbstract {
    
  public Ziv_Irp_Role_Record(String _record) {
    fieldValues = _record.split(",");
    irpTableBeingProcessed = IrpTables.ZIV_IRP_ROLE;
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
      return fieldValues[1];  // Role key is the key
    }
    else {
      return "**INVALID**";
    }
  }     
}
