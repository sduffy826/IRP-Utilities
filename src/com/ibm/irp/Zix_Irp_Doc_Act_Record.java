package com.ibm.irp;

public class Zix_Irp_Doc_Act_Record extends IrpRecordAbstract {
    
  // Constructor is passed in a string containing data record, it's in csv format
  // so we split into string array (fieldValues)
  public Zix_Irp_Doc_Act_Record(String _record) {
    fieldValues = _record.split(",");
    irpTableBeingProcessed = IrpTables.ZIX_IRP_DOC_ACT;
    irpFields = (IrpFieldsAbstract) IrpFieldsHelper.getInstance(irpTableBeingProcessed);
    
    if (DEBUGIT) {
      for (int i = 0; i < fieldValues.length; i++) {
        System.out.println("Field name: " + irpFields.getField(i) +
                           " value at [" +Integer.toString(i) + "] : " +
                           fieldValues[i]);
      }    
    }
  }   
  
  // Define what the key is for this record; for zix_irp_doc_act it's 
  //   doc_path+doc_state+user_type+action_code (values 1->4 in array)
  public String getKey() {
    if (fieldValues.length > 5) {
      return fieldValues[1] + "/" + fieldValues[2] + "/" + fieldValues[3] + "/" +
             fieldValues[4];
    }
    else {
      return "**INVALID**";
    }
  }     
}
