package com.ztesoft.core.common;

import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class TreeSortComparator implements Comparator<Map<String,Object>>{

    private Map<String,Boolean> orderByClauses = new LinkedHashMap<String, Boolean>();
    
    public Map<String, Boolean> getOrderByClauses() {
        return orderByClauses;
    }

    public void setOrderByClauses(Map<String, Boolean> orderByClauses) {
        this.orderByClauses = orderByClauses;
    }

    @Override
    public int compare(Map<String, Object> o1, Map<String, Object> o2) {
        if(!orderByClauses.isEmpty()){
            int result = 0;
            Set<String> orders = orderByClauses.keySet();
            for(String key : orders){
                Object value1 = o1.get(key);
                Object value2 = o2.get(key);
                boolean reverse = orderByClauses.get(key);
                int tempResult = compareObject(value1, value2);
                if(tempResult == 0){
                    continue;
                }else if(tempResult > 0){
                    result = 1;
                }else{
                    result = -1;
                }
                if(reverse){
                    return 0 - result;
                }else{
                    return result;
                }
            }
            return result;
        }
        return 0;
    }
    
    public int compareObject(Object value1, Object value2) {
        if (value1 instanceof Comparable) {
            return ((Comparable) value1).compareTo((Comparable)value2);
        }else{
            return (value1.toString()).compareTo(value2.toString());
        }
    }
}
