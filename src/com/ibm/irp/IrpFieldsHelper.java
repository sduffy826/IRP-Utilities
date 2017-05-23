package com.ibm.irp;

import java.util.Arrays;

public class IrpFieldsHelper {
  
  // Helper method to return an IrpFields object
  public static IrpFields getInstance(IrpTables _type) {       
    switch (_type) {
    case ZIX_IRP_DOC_ACT:
      return Zix_Irp_Doc_Act_Fields.getInstance();      
    case ZIX_IRP_WEB_FLDS:
      return Zix_Irp_Web_Flds_Fields.getInstance();
    case ZIX_IRP_ACT_MAP:
      return Zix_Irp_Act_Map_Fields.getInstance();
    case ZIX_IRP_DOC2PATH:
      return Zix_Irp_Doc2Path_Fields.getInstance();
    case ZIX_CONSTANTS_IRP_TASKS:
      return Zix_Constants_Irp_Tasks_Fields.getInstance();
    case ZIV_IRP_ROLE:
      return Ziv_Irp_Role_Fields.getInstance();
    default:
      System.out.println("Invalid type requested");
      System.exit(999);
    }
    return null;    
  }
}
