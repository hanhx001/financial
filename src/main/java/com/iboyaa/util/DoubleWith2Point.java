/**
 * 
 */
package com.iboyaa.util;

import java.text.DecimalFormat;

/**
 * Double 
 * @author 清水贤人
 *
 */
public class DoubleWith2Point {
    
    
    //保留两位小数 ，不四舍五入
    public final static Double noForFive(Double temp) {
       
        if(null == temp) {
            return new Double(0);
        }
        DecimalFormat df=new DecimalFormat(".##");
         
        
        return  Double.valueOf(df.format(temp));
       
    }
}
