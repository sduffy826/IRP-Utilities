package com.ibm.irp;

import java.util.Arrays;

// Concrete class for the constants entry irp_tasks
public class Zix_Constants_Irp_Tasks_Fields extends IrpFieldsAbstract {
  
  // Singleton object reference to this class
  private static IrpFields zixConstantsIrpTasksFieldsObj = new Zix_Constants_Irp_Tasks_Fields();  
  
  // Private constructor define the fields in the table
  private Zix_Constants_Irp_Tasks_Fields() {
    fieldList = new String[]{"role_key", "rec_key", "code", "description"};
    if (DEBUG) {
      System.out.println("Constructor for ZixConstantsIrpTasksFields called, # fields: " + Integer.toString(fieldList.length));
    }
  }
  
  // Now we expose a static method to return the static instance of our object :)
  public static IrpFields getInstance() {  
    return zixConstantsIrpTasksFieldsObj;
  }
}
