package com.ibm.irp;

public class Zix_Al_Doc_Attr_Record extends IrpRecordAbstract {
    
  // Constructor is passed in a string containing data record, it's in csv format
  // so we split into string array (fieldValues)
  public Zix_Al_Doc_Attr_Record(String _record) {
    fieldValues = _record.split(",");
    irpTableBeingProcessed = IrpTables.ZIX_AL_DOC_ATTR;
    irpFields = (IrpFieldsAbstract) IrpFieldsHelper.getInstance(irpTableBeingProcessed);
    
    if (DEBUGIT) {
      for (int i = 0; i < fieldValues.length; i++) {
        System.out.println("Field name: " + irpFields.getField(i) +
                           " value at [" +Integer.toString(i) + "] : " +
                           fieldValues[i]);
      }    
    }
  }   
  
  // Define what the key is for this record; for zix_al_doc_attr it's doc_kind
  public String getKey() {
    if (fieldValues.length > 0) {
      return fieldValues[1];
    }
    else {
      return "**INVALID**";
    }
  }     
}
