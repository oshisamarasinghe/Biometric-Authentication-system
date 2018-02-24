/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typotest;
import java.util.HashMap;
public class Model {
   
   
     private  HashMap<String,Long> refmodel=new HashMap<String,Long>();
     private  HashMap<String,Long> checkmodel=new HashMap<String,Long>();

   
    public void saverefModel(HashMap<String,Long> interkeygaps){
        this.refmodel=interkeygaps;//save registered model
         
    }
    public HashMap<String,Long> getrefModel(){
        return this.refmodel;//return registered model
    }
     public void savecheckModel(HashMap<String,Long> interkeygaps){
        this.checkmodel=interkeygaps;//save login model
         
    }
    public HashMap<String,Long> getcheckModel(){
        return this.checkmodel;//return login model
    }
}
