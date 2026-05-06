/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

/**
 *
 * @author User
 */
public class IdGeneretor {
  
    public String IdAutoGenerate(String file, int getRow){
        
        if(file.startsWith("Co")){
            return "S" + (getRow + 1);   
        }
        else if(file.startsWith("C")){
            return "C" + (getRow + 1);
        }
        else if(file.startsWith("M")){
            return "M" + (getRow + 1);
        }
        else if(file.startsWith("T")){
            return "T" + (getRow + 1);
        }    
        return "";
    }
}
