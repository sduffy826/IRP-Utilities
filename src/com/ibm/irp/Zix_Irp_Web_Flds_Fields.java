package com.ibm.irp;

import java.util.Arrays;

public class Zix_Irp_Web_Flds_Fields extends IrpFieldsAbstract {
  
  private static IrpFields zixIrpWebFldsObj = new Zix_Irp_Web_Flds_Fields();  
   
  private Zix_Irp_Web_Flds_Fields() {
    fieldList = new String[]{"mandt", "web_group_name", "icompany",                 
                             "iworkorder", "icontract", "ifilename",                
                             "ifunction", "icomments_hidden", "icomments",          
                             "idocument_date", "ibase64attachment", "iirp_doc_desc",
                             "iirp_doc_status", "iperson_keys"};                      
    if (DEBUG) {
      System.out.println("Constructor for ZixIrpWebFldsFields called" + Integer.toString(fieldList.length));
    }
  }
  
  // Now we expose a static method to return the static instance of our object :)
  public static IrpFields getInstance() {  
    return zixIrpWebFldsObj;
  }
}
