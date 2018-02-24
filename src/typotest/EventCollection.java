/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typotest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author oshadi
 */

public class EventCollection {
    
    private  final ArrayList<Long> presstime;
    private  final ArrayList<Long> releasetime;
    private final ArrayList<Integer> pressedKeys;
    private final ArrayList<Integer> releasedKeys;
    public  HashMap<String,Long> interkeygaps;
    private final HashMap<String,Integer> count;
    
   

    
    public EventCollection(){
        this.presstime=new ArrayList<Long>();
        this.releasetime=new ArrayList<Long>();
        this.interkeygaps=new HashMap<String,Long>();
        this.count=new HashMap<String ,Integer>();
        this.pressedKeys=new ArrayList<Integer>();
        this.releasedKeys=new ArrayList<Integer>();
      
        
    }
    public void press(java.awt.event.KeyEvent keyevent){
        Long time=System.currentTimeMillis();
        presstime.add(time);
        int key=keyevent.getKeyCode();
        pressedKeys.add(key);
        
        
        
    }
    public void release(java.awt.event.KeyEvent keyevent){
        Long time=System.currentTimeMillis();
        releasetime.add(time);
        int key=keyevent.getKeyCode();
        releasedKeys.add(key);
        
    }
    public void calculation(){
        gap(presstime,releasetime,pressedKeys,releasedKeys);
       
           
      
    }
    
    public void gap(ArrayList<Long> ptimelist,ArrayList<Long> rtimelist,ArrayList<Integer> pkeylist,ArrayList<Integer> rkeylist){
        if (ptimelist.size()==rtimelist.size()){
            for (int i=0;i<ptimelist.size()-1;i++){
                    String key=rkeylist.get(i).toString().concat(pkeylist.get(i+1).toString());// pair of consecutive keys
                    
                    Long timegap=ptimelist.get(i+1)-rtimelist.get(i);//time gap between pair of consecutive keys
                     
                      
                    if(!interkeygaps.containsKey(key)){
                       interkeygaps.put(key, timegap); 
                       count.put(key, 1);
                      
                    }else{
                        long duration=interkeygaps.get(key);
                        interkeygaps.replace(key, timegap+duration); 
                        int val=count.get(key);
                        count.replace(key,val+1);
                       
                        }
                    }

                
            interKeyGaps();
            }
        
       }
    public void interKeyGaps(){
        Iterator it = interkeygaps.entrySet().iterator();
        
    while (it.hasNext()) {
        
        Map.Entry pair = (Map.Entry)it.next();
        String code=(String) pair.getKey();
       
        if(count.containsKey(code)&& count.get(code)>1){//to get the keypairs typed count and avg time to type them
            Integer counts=count.get(code);
            Long duration=(Long) pair.getValue();
            Long avgduration=duration/counts;
           
            interkeygaps.replace(code, avgduration);
            it.remove(); 
            }
        }
    }
    
    public HashMap<String,Long> getMap(){
        return interkeygaps;
    }
    
   
        
    }
  


   

