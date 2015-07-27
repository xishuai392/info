Date.prototype.format = function(format)  
{  
	/* 
	* format="yyyy-MM-dd hh:mm:ss"; 
	*/  
	var o = {  
	"M+" : this.getMonth() + 1,  
	"d+" : this.getDate(),  
	"h+" : this.getHours(),  
	"m+" : this.getMinutes(),  
	"s+" : this.getSeconds(),  
	"q+" : Math.floor((this.getMonth() + 3) / 3),  
	"S" : this.getMilliseconds()  
	}  
	  
	if (/(y+)/.test(format))  
	{  
		format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4  
		- RegExp.$1.length));  
	}  
	  
	for (var k in o)  
	{  
		if (new RegExp("(" + k + ")").test(format))  
		{  
		format = format.replace(RegExp.$1, RegExp.$1.length == 1  
		? o[k]  
		: ("00" + o[k]).substr(("" + o[k]).length));  
		}  
	}  
	return format;  
}
function int2DateFormat(date){
	date = parseInt(date);
	return Math.floor(date/10000)+'-'+Math.floor(date/100%100)+'-'+Math.floor(date%100)
}
// 设置周期内的日期(数组)  
function setRange(range,start,end){  
	var cdate = Array();  
	cdate = start.split("-");  
	var cd = cdate[1]+"/"+cdate[2]+"/"+cdate[0];   
	var dayNum = DateDiff(end,start);  
	for(var i=0; i<=dayNum; i++){  
	   range.push(AddDays(cd,i));  
	}  
}// end fun  
  
// 日期加上天数后的新日期.  
function AddDays(date,days){  
	var nd = new Date(date);  
	   nd = nd.valueOf();  
	   nd = nd + days * 24 * 60 * 60 * 1000;  
	   nd = new Date(nd);  
	   // alert(nd.getFullYear() + "年" + (nd.getMonth() + 1) + "月" + nd.getDate() +  
	    // "日");  
	var y = nd.getFullYear();  
	var m = nd.getMonth()+1;  
	var d = nd.getDate();  
	if(m <= 9) m = "0"+m;  
	if(d <= 9) d = "0"+d;   
	var cdate = y+"-"+m+"-"+d;  
	return cdate;  
}
// 两个日期的差值(d1 - d2).  
function DateDiff(d1,d2){  
    var day = 24 * 60 * 60 *1000;  
	try{     
	   var dateArr = d1.split("-");  
	   var checkDate = new Date();  
	        checkDate.setFullYear(dateArr[0], dateArr[1]-1, dateArr[2]);  
	   var checkTime = checkDate.getTime();  
	    
	   var dateArr2 = d2.split("-");  
	   var checkDate2 = new Date();  
	        checkDate2.setFullYear(dateArr2[0], dateArr2[1]-1, dateArr2[2]);  
	   var checkTime2 = checkDate2.getTime();  
	      
	   var cha = (checkTime - checkTime2)/day;    
	        return cha;  
	}catch(e){  
	   return false;  
	}  
}// end fun 
var userAgent = navigator.userAgent.toLowerCase();
var lessThenIE8 = function () {
    var UA = navigator.userAgent,
        isIE = UA.indexOf('MSIE') > -1,
        v = isIE ? /\d+/.exec(UA.split(';')[1]) : 'no ie';
    return v < 8;
}();

ArrayUtils = {};
ArrayUtils.clear=function(arr){ 
	arr.length=0; 
} 
ArrayUtils.insertAt=function(arr,index,obj){ 
	arr.splice(index,0,obj); 
} 
ArrayUtils.removeAt=function(arr,index){ 
	arr.splice(index,1); 
} 
ArrayUtils.remove=function(arr,obj){ 
	var index=arr.indexOf(obj); 
	if (index>=0){ 
		arr.removeAt(index); 
	} 
} 
var StringUtils = {}
StringUtils.isGBK = function(str){
	if(!(/^[\u4e00-\u9fa5]+$/i).test(str)){    
       return false;
    }
    return true;
}
StringUtils.GetLength = function(str) {
    ///<summary>获得字符串实际长度，中文2，英文1</summary>
    ///<param name="str">要获得长度的字符串</param>
    var realLength = 0, len = str.length, charCode = -1;
    for (var i = 0; i < len; i++) {
        charCode = str.charCodeAt(i);
        if (charCode >= 0 && charCode <= 128) realLength += 1;
        else realLength += 1.5;
    }
    return realLength;
};
/**
 * 计算字符串长度，中文算2个
 * q~:569934930
 * @param {} str
 * @return {}
 */
StringUtils.countGBK = function(str){
	if(!str)return 0;
	var length = 0;
	for(var i = 0;i<str.length;i++){
		if(StringUtils.isGBK(str[i])){
			length+=1.5;
		}
		else{
			length+=1;
		}
	}
	return length;
}
String.prototype.format = function() {
    var args = arguments;
    if(args==null||args.length<1)return ;
    var str = this.replace(/{(\d{1})}/g, function() {
        return args[arguments[1]];
    });
    str = str.replace(/{(\w{1,20})}/g,function(){
    	var obj=null;
    	for(var i=0;i<args.length;i++){
    		if(typeof args[i]=='object'){
    			obj = args[i];break;
    		}
    	}
    	return obj[arguments[1]]||arguments[1];
    });
    return str;
};
String.prototype.replaceAll = function(reallyDo, replaceWith, ignoreCase) {   
    if (!RegExp.prototype.isPrototypeOf(reallyDo)) {   
        return this.replace(new RegExp(reallyDo, (ignoreCase ? "gi": "g")), replaceWith);   
     } else {   
        return this.replace(reallyDo, replaceWith);   
     }   
};