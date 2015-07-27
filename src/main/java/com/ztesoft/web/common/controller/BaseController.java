package com.ztesoft.web.common.controller;

import java.awt.image.RenderedImage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ztesoft.core.common.TreeNode;
import com.ztesoft.core.common.TreePO;
import com.ztesoft.core.common.TreeQueryPO;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.framework.util.JsonUtil;
import com.ztesoft.framework.util.StringUtils;
import com.ztesoft.framework.util.ValidateUtils;
import com.ztesoft.web.common.service.IBaseService;

/**
 * <Description>自动生成代码 <br>
 * 
 * @author lifei<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年12月11日 <br>
 * @since V1.0<br>
 */

@Controller
@RequestMapping("/base")
public class BaseController {

	public static final String RANDOMCODEKEY = "RANDOMVALIDATECODEKEY";// 放到session中的key

	private static final ZTEsoftLogManager logger = ZTEsoftLogManager.getLogger(BaseController.class);

	@Autowired
	private IBaseService baseService;

	@RequestMapping("getList")
	@ResponseBody
	public List<?> getList(String tableName, String conditionsKey) {
		Map<String, Object> conditions;
		if (StringUtils.isEmpty(conditionsKey)) {
			conditions = new HashMap<String, Object>();
		} else {
			conditions = JsonUtil.toMap(conditionsKey);
		}
		List<?> list = baseService.selectList(tableName, conditions);
		return list;
	}

	// @RequestMapping("save")
	// @ResponseBody
	// public Map<String,Object> save(String tableName,String entityStr){
	// Map<String,Object> result = new HashMap<String, Object>();
	// try{
	// result.put("success", true);
	// result.put("message", baseCommonService.save(tableName,
	// JsonUtils.toMap(entityStr)));
	// }catch(Exception e){
	// e.printStackTrace();
	// result.put("success", false);
	// result.put("message", e.getMessage()+e.toString());
	// }
	// return result;
	// }
	// @RequestMapping("update")
	// @ResponseBody
	// public Map<String,Object> update(String tableName,String entityStr){
	// Map<String,Object> result = new HashMap<String, Object>();
	// try{
	// result.put("success", true);
	// result.put("message", baseCommonService.update(tableName,
	// JsonUtils.toMap(entityStr)));
	// }catch(Exception e){
	// e.printStackTrace();
	// result.put("success", false);
	// result.put("message", e.getMessage()+e.toString());
	// }
	// return result;
	// }
	// @RequestMapping("delete")
	// @ResponseBody
	// public Map<String,Object> delete(String tableName,String ids){
	// Map<String,Object> result = new HashMap<String, Object>();
	// try{
	// result.put("success", true);
	// result.put("message", baseCommonService.delete(tableName, ids));
	// }catch(Exception e){
	// e.printStackTrace();
	// result.put("success", false);
	// result.put("message", e.getMessage()+e.toString());
	// }
	// return result;
	// }

	@RequestMapping("load")
	@ResponseBody
	public Map<String, Object> load(String tableName, String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			result.put("success", true);
			result.put("message", baseService.selectOne(tableName, id));
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("message", e.getMessage() + e.toString());
			logger.error(e);
		}
		return result;
	}

	// @RequestMapping("updateItems")
	// @ResponseBody
	// public Map<String,Object> updateItems(String tableName,String entityStr){
	// Map<String,Object> result = new HashMap<String, Object>();
	// try{
	// result.put("success", true);
	// result.put("message", baseCommonService.updateItems(tableName,
	// JsonUtils.toMap(entityStr)));
	// }catch(Exception e){
	// e.printStackTrace();
	// result.put("success", false);
	// result.put("message", e.getMessage()+e.toString());
	// }
	// return result;
	// }

	@RequestMapping("proxy")
	public void proxy(String strURL, HttpServletResponse response) {
		try {
			Writer writer = response.getWriter();
			URL url = new URL(strURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			InputStreamReader isr = new InputStreamReader(conn.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			String temp;
			int i = 0;
			while ((temp = br.readLine()) != null) {
				if (i++ == 6)
					writer.append("<meta http-equiv=\"Access-Control-Allow-Origin\" content=\"*\" />");
				writer.append(temp + "\n");
			}
			br.close();
			isr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("testDBConnection")
	@ResponseBody
	public Map<String, Object> testDBConnection(String driver, String dbName, String characterEncoding, String ip,
			String port, String params, String username, String password) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			result.put("success", true);
			result.put("message", baseService.testDBConnection(driver, dbName, characterEncoding, ip, port, params,
					username, password));
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("message", e.getMessage() + e.toString());
		}
		return result;
	}

	@RequestMapping("loadDBMeta")
	@ResponseBody
	public Map<String, Object> loadDBMeta(String driver, String dbName, String characterEncoding, String ip,
			String port, String params, String username, String password) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			result.put("success", true);
			result.put("message",
					baseService.loadDBMeta(driver, dbName, characterEncoding, ip, port, params, username, password));
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("message", e.getMessage() + e.toString());
		}
		return result;
	}

	@RequestMapping("saveDBMeta")
	@ResponseBody
	public Map<String, Object> saveDBMeta(String driver, String dbName, String characterEncoding, String ip,
			String port, String params, String username, String password) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			result.put("success", true);
			result.put("message",
					baseService.saveDBMeta(driver, dbName, characterEncoding, ip, port, params, username, password));
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("message", e.getMessage() + e.toString());
		}
		return result;
	}

	@RequestMapping("randCodeImage")
	public void randCodeImage(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Object[] results = ValidateUtils.getRandcode();
		session.removeAttribute(RANDOMCODEKEY);
		session.setAttribute(RANDOMCODEKEY, results[0]);
		try {
			ImageIO.write((RenderedImage) results[1], "JPEG", response.getOutputStream());// 将内存中的图片通过流动形式输出到客户端
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@RequestMapping("getGeneralTree")
	@ResponseBody
	public TreeNode getGeneralTree(String paramMap, String node) {
		TreePO params = JsonUtil.toBean(paramMap, TreePO.class);
		Map<String, Object> data = JsonUtil.toMap(paramMap);
		String valueField = data.get("valueField").toString();
		if (StringUtils.isEmpty(params.getDeep())) {
			params.setDeep(10);
		}
		Object rootId = data.get("rootId");
		data.put(valueField, rootId);

		if (!StringUtils.isEmpty(node)) {
			data.put(valueField, node);
		}
		String unChangeParamStr = params.getUnChangeParamStr();
		if (!StringUtils.isEmpty(unChangeParamStr)) {
			String[] temp = unChangeParamStr.split(",");
			Map<String, Object> paramData = new HashMap<String, Object>();
			for (int i = 0; i < temp.length; i++) {
				paramData.put(temp[i], data.get(temp[i]));
			}
			params.setParamData(paramData);
		}
		String iconStr = params.getIconStr();
		if (!StringUtils.isEmpty(iconStr)) {
			params.setIcons(iconStr.split(","));
		} else {
			params.setIcons(new String[0]);
		}
		TreeNode tree = baseService.getTreeAllData(params, data, 0);
		return tree;
	}

	@RequestMapping("queryTree")
	@ResponseBody
	public TreeNode queryTree(TreeQueryPO reqDto) {
		return baseService.queryTree(reqDto);
	}

	@RequestMapping("getDataList")
	@ResponseBody
	public List<Map<String, Object>> getDataList(String sqlKey, String paramMap) {
		Map<String, Object> params = JsonUtil.toMap(paramMap);
		// String realKey = Configuration.getString(sqlKey);
		return baseService.selectList2(sqlKey, params);
	}

}
