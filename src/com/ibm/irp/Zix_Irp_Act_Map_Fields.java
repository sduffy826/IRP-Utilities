package com.ibm.irp;

import java.util.Arrays;

public class Zix_Irp_Act_Map_Fields extends IrpFieldsAbstract {
  
  // Singleton object reference to this class 
  private static IrpFields zixIrpActMapFieldsObj = new Zix_Irp_Act_Map_Fields();  
    
  // Constructor to define fields
  private Zix_Irp_Act_Map_Fields() {
    fieldList = new String[]{"mandt", "action_code", "action_desc",
                             "upload_action", "download_action", "form_name"};
    if (DEBUG) {
      System.out.println("Constructor for ZixIrpActMapFields called" + Integer.toString(fieldList.length));
    }
  }
  
  // Now we expose a static method to return the static instance of our object :)
  public static IrpFields getInstance() {  
    return zixIrpActMapFieldsObj;
  }
}
