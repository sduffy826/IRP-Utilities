package com.ibm.irp;

import java.util.Arrays;

// Concrete class for the fields in the zix_irp_doc_act table
public class Zix_Irp_Doc_Act_Fields extends IrpFieldsAbstract {
  
  // Singleton object reference to this class
  private static IrpFields zixIrpDocActFieldsObj = new Zix_Irp_Doc_Act_Fields();  
  
  // Private constructor define the fields in the table
  private Zix_Irp_Doc_Act_Fields() {
    fieldList = new String[]{"mandt", "doc_path", "doc_state", "user_type", 
        "action_code", "avail_history", "new_doc_state", 
        "new_doc_hide_state", "comdoc_status", "irp_status", 
        "web_groupssname", "set_comments_hidden",
        "comm_template", "comm_recipient_list"};
    if (DEBUG) {
      System.out.println("Constructor for ZixIrpDocActFields called, # fields: " + Integer.toString(fieldList.length));
    }
  }
  
  // Now we expose a static method to return the static instance of our object :)
  public static IrpFields getInstance() {  
    return zixIrpDocActFieldsObj;
  }
}
