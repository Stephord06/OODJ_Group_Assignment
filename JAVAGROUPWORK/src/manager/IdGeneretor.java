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
        
        if(file.startsWith("co")){
            return String.format("%s%03d", "S", getRow + 1);   
        }
        else if(file.startsWith("c")){
            return String.format("%s%03d", "C", getRow + 1);
        }
        else if(file.startsWith("m")){
            return String.format("%s%03d", "M", getRow + 1);
        }
        else if(file.startsWith("t")){
            return String.format("%s%03d", "T", getRow + 1);
        }    
        return "";
    }
}
