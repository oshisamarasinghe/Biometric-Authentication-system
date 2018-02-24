/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typotest;

import java.util.HashMap;

/**
 *
 * @author oshadi
 */

public class Matcher {

     private final  HashMap<String,Long> refmodel;
     private final  HashMap<String,Long> checkmodel;
     private final double duration_tolerance=80; //normal tolerance for inter key time duration = .08 seconds
     private final double match_tolerance=0.70; //accuracy level for authentication

    public Matcher(HashMap<String,Long> ref,HashMap<String,Long> check){
        this.refmodel=ref;
        this.checkmodel=check;
        
          
    }
    public boolean match(HashMap<String,Long> ref,HashMap<String,Long> check){
       
        int matches=0;
        int mismatches=0;
        for(String i:ref.keySet()){
            if(check.containsKey(i)){
               if(Math.abs(ref.get(i)-check.get(i))<duration_tolerance){
                    matches++;
                }else{
                   mismatches++;
                }
              }
      }
    
        double m=(matches*1.0)/(matches*1.0+mismatches*1.0);
        System.out.println(m);
        
        return m>=match_tolerance;
    }
    
}
