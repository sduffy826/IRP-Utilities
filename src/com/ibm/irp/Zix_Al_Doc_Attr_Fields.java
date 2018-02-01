package com.ibm.irp;

import java.util.Arrays;

// Concrete class for the fields in the zix_irp_doc_act table
public class Zix_Al_Doc_Attr_Fields extends IrpFieldsAbstract {
  
  // Singleton object reference to this class
  private static IrpFields zixAlDocAttrFieldsObj = new Zix_Al_Doc_Attr_Fields();  
  
  // Private constructor define the fields in the table
  private Zix_Al_Doc_Attr_Fields() {
    fieldList = new String[]{"mandt", "doc_kind", "business_area", "type", 
        "category", "status", "project_phase", 
        "keywords", "workorder", "function", 
        "description", "vis_outside_sale",
        "p_group"};
    if (DEBUG) {
      System.out.println("Constructor for ZixAlDocAttrFields called, # fields: " + Integer.toString(fieldList.length));
    }
  }
  
  // Now we expose a static method to return the static instance of our object :)
  public static IrpFields getInstance() {  
    return zixAlDocAttrFieldsObj;
  }
}
