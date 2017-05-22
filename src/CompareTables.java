import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map; 

import com.ibm.irp.*;

public class CompareTables {

  /**
   * This program compares table data; I wrote it to compare the irp tables but you can use it to compare
   * other tables.  You should have exported the data to csv format for the systems you wish to compare.
   * You run this program passing in the name of the table you wish to compare (it needs to match one
   * enum values) followed by the two data files.
   * 
   * Note: If you want to add other comparisons you just need to:
   *   1) Update enum IrpTables.java to include new table
   *   2) Create concrete classes for *_Fields and *_Record, just copy one of the other ones and
   *      modify it.. should be obvious what u need to do (look at zix_irp_doc_act* for example).
   *   3) Modify the getObjectForRecord method below to support new table 
   *   4) Modify the IrpFieldsHelper class for the new table   * 
   */
  public static void main(String[] args) {
    
    if (args.length < 3) {
      System.out.println("Pass in tableYourProcessing(i.e. zix_irp_doc_act) file1 and file2 please :)");
      return;
    }
    
    IrpTables table = null;
    
    // Set enmum based on user argument
    try {
      table = IrpTables.valueOf(args[0].trim().toUpperCase());
    }
    catch (Exception e) {
      System.out.println("Error, invalid table type passed in");
      System.exit(997);
    }
    
    // These maps have the keys/data for both files
    Map<String, IrpRecord> map1 = new HashMap<String, IrpRecord>();
    Map<String, IrpRecord> map2 = new HashMap<String, IrpRecord>();
        
    // Filenames
    String inFile1 = args[1];
    String inFile2 = args[2];
    
    System.out.println("a is " + inFile1 + " b is: " + inFile2);
    processFile(table,inFile1,map1);
    processFile(table,inFile2,map2);
    
    compareMaps("a->b", map1, map2, true);
    compareMaps("b->a", map2, map1, false);    
    System.out.println("Done :)");
  }

  // Method to interate over entries in first map and look up the corresponding
  // entry in the second map; it'll report not found and also differences (if 
  // we want them)  Note: we have flag for report differences because we typically
  // compoare map a->b then b->a and when we are comparing b->a we're typically only
  // interested in records not found (since differences were identified in a->b compare)
  private static void compareMaps(String _msg,
                                  Map<String, IrpRecord> _map1, 
                                  Map<String, IrpRecord> _map2,
                                  boolean _reportDifferences) {
    IrpRecord rec1, rec2;
    for (Map.Entry<String, IrpRecord> entry : _map1.entrySet()) {
      rec1 = entry.getValue();
      rec2 = _map2.get(rec1.getKey());  
      if (rec2 == null) {        
        notFound(_msg, rec1);
      }
      else {
        if (rec1.isSame(rec2) != true) {
          if (_reportDifferences ) {
            dumpDiff(_msg, rec1, rec2);
          }
        }
      }
    }    
  }

  // Wrapper to show delta's between records
  private static void dumpDiff(String _msg, IrpRecord _doc1, IrpRecord _doc2) {
    System.out.println("\n\n" + _msg + " : " + _doc1.getKey());
    _doc1.listDifferences(_doc2);    
  } 
  
  // Return the object reference for the type of record we are processing, we pass in the
  // string to the constructor which is basically the csv record, the constructor parses
  // it into an array where each cell is a field value.
  private static IrpRecord getObjectForRecord(IrpTables _table, String _constructorArg) {
    switch (_table) {
    case ZIX_IRP_DOC_ACT:
      return new Zix_Irp_Doc_Act_Record(_constructorArg);
    case ZIX_IRP_WEB_FLDS:
      return new Zix_Irp_Web_Flds_Record(_constructorArg); 
    case ZIX_IRP_DOC2PATH:
      return new Zix_Irp_Doc2Path_Record(_constructorArg);
    case ZIX_IRP_ACT_MAP:
      return new Zix_Irp_Act_Map_Record(_constructorArg);
    case ZIX_CONSTANTS_IRP_TASKS:
      return new Zix_Constants_Irp_Tasks_Record(_constructorArg);
    default:
      System.out.println("Error, invalid table type passed in");
      System.exit(998);
    }
    return null;
  }  
  
  // Wrapper for when a record wasn't found
  private static void notFound(String _msg, IrpRecord _doc) {
    System.out.println("\n\n" + _msg + " NOT FOUND");
    _doc.dumpIt();
  }
  
  // Read file and put contents into the hashmap; the hashmap has the key for the record
  // and a reference to the record object
  private static void processFile(IrpTables _table, String _file, Map<String, IrpRecord> _map) {
    try {
      String str;
      IrpRecord irpRecordObj;
      BufferedReader in = new BufferedReader(new FileReader(_file));      
      while ((str = in.readLine()) != null) {
         irpRecordObj = getObjectForRecord(_table, str.trim());
         _map.put(irpRecordObj.getKey(),irpRecordObj);
      }
      in.close();
    }
    catch (Exception e) { e.printStackTrace(); } 
  }  
}
