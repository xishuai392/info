/**
 * 
 */
package com.ztesoft.web.rbsp;

import java.util.ArrayList;
import java.util.Date;

import com.ztesoft.framework.util.DateUtils;
import com.ztesoft.framework.util.MessageResourceUtils;
import com.ztesoft.web.information.rbsp.InfoRbspClient;
import com.ztesoft.web.permission.db.po.AuditUserPO;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年10月15日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.rbsp <br>
 */

public class TestRBSPService {

    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception  {
        Date StartDate = DateUtils.string2Date("2015-01-01", 
                "yyyy-MM-dd");
        Date EndDate = DateUtils.string2Date("2015-01-11", 
                "yyyy-MM-dd");
        
        System.out.println(DateUtils.compareDate(EndDate,StartDate,0));
        
        System.out.println("====================");
        
        Date startDate1 = DateUtils.string2Date("2015-01-01", 
                MessageResourceUtils.getMessage("T_LDRK_ZJZZXX.date.format"));
        Date endDate1 = DateUtils.string2Date("2015-01-11", 
                MessageResourceUtils.getMessage("T_LDRK_ZJZZXX.date.format"));
        ArrayList<Date> list = DateUtils.getIntervalDay(startDate1, null);
        System.out.println(list.size());
        System.out.println("====================");
        
        
        // TODO Auto-generated method stub
        InfoRbspClient rbspService = new InfoRbspClient();
        AuditUserPO auditUserPo = new AuditUserPO();
        String result = rbspService.queryCZRKbaseInfo(auditUserPo, 
                "422301194003157646", "PID");

        System.out.println("======================打印结果============");
        System.out.println(result);
    }

}
