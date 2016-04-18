/**
 * 
 */
package com.ztesoft.web.rbsp;

import java.util.Date;

import com.ztesoft.framework.util.DateUtils;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年11月26日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.rbsp <br>
 */

public class TestDate {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Date one = DateUtils.string2Date("2008-03-26", "yyyy-MM-dd");
        Date two = DateUtils.string2Date("2009-10-13", "yyyy-MM-dd");

        System.out.println(DateUtils.compareDate(two, one, 0));
    }

}
