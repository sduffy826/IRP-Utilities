package com.ibm.irp;


// OLD NOT USED, just left here for ref

import java.util.Arrays;

public class BackupOfZixIrpDocActFields extends IrpFieldsAbstract {
  
  public static IrpFields zixIrpDocActFieldsObj = new BackupOfZixIrpDocActFields();  
  private static IrpTables tableFields;
  
  private BackupOfZixIrpDocActFields() {
    // Default to zix_irp_doc_act
    setFieldList(IrpTables.ZIX_IRP_DOC_ACT);
    if (DEBUG) {
      System.out.println("Constructor for ZixIrpDocActFields called" + Integer.toString(fieldList.length));
    }
  }
  
  private void setFieldList(IrpTables _type) {
    switch (_type) {
    case ZIX_IRP_DOC_ACT:
      tableFields = IrpTables.ZIX_IRP_DOC_ACT;
      fieldList = new String[]{"mandt", "doc_path", "doc_state", "user_type", 
          "action_code", "avail_history", "new_doc_state", 
          "new_doc_hide_state", "comdoc_status", "irp_status", 
          "web_groupssname", "set_comments_hidden",
          "comm_template", "comm_recipient_list"};
    case ZIX_IRP_WEB_FLDS:
      tableFields = IrpTables.ZIX_IRP_WEB_FLDS;
      fieldList = new String[]{"mandt", "doc_path", "doc_state", "user_type", 
          "action_code", "avail_history", "new_doc_state", 
          "new_doc_hide_state", "comdoc_status", "irp_status", 
          "web_groupssname", "set_comments_hidden",
          "comm_template", "comm_recipient_list"};
    default:
      System.out.println("Invalid type requested");
      System.exit(999);
    }    
  }
  
  // Now we expose a static method to return the static instance of our object :)
  public static IrpFields getInstance(IrpTables _tableFieldsRequested) {
    if (_tableFieldsRequested != tableFields) {
  //    zixIrpDocActFieldsObj.setFieldList(_tableFieldsRequested);
    }
    return zixIrpDocActFieldsObj;
  }
  
  /*
   public String[] getFields() {
    return Arrays.copyOf(fieldList, fieldList.length);
  }
  
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
  */
}
