package com.ibm.irp;

import java.util.Arrays;

public class Ziv_Irp_Role_Fields extends IrpFieldsAbstract {
  
  // Singleton object reference to this class 
  private static IrpFields zivIrpRoleFieldsObj = new Ziv_Irp_Role_Fields();  
    
  // Constructor to define fields
  private Ziv_Irp_Role_Fields() {
    fieldList = new String[]{"mandt", "role_key", "owner", "sdpa", "pretester", 
                             "client_team", "coordinator", "contact", "tech", 
                             "ibm_team", "platform_req", "display", "ibmers", 
                             "temp_maint", "orch_sme"};
    if (DEBUG) {
      System.out.println("Constructor for ZivIrpRoleFields called, # fields: " + Integer.toString(fieldList.length));
    }
  }
  
  // Now we expose a static method to return the static instance of our object :)
  public static IrpFields getInstance() {  
    return zivIrpRoleFieldsObj;
  }
}
