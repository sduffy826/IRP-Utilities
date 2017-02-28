package com.ibm.irp;

import java.util.Arrays;

public class Zix_Irp_Doc2Path_Fields extends IrpFieldsAbstract {
  
  private static IrpFields zixIrpDoc2PathFieldsObj = new Zix_Irp_Doc2Path_Fields();  
    
  private Zix_Irp_Doc2Path_Fields() {
    fieldList = new String[]{"mandt", "doc_kind", "doc_path", "irp_attach_point"};
    if (DEBUG) {
      System.out.println("Constructor for Zix_Irp_Doc2Path_Fields called" + Integer.toString(fieldList.length));
    }
  }
  
  // Now we expose a static method to return the static instance of our object :)
  public static IrpFields getInstance() {  
    return zixIrpDoc2PathFieldsObj;
  }
}
