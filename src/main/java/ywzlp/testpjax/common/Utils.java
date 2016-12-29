package ywzlp.testpjax.common;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by yuwei on 2016/12/19
 */
public class Utils {
	
	private static final String WEATHER_API = "http://wthrcdn.etouch.cn/weather_mini?city=%s";
	
	private static final String TEXTAREA = "<textarea>%s</textarea>";
	
	private static final String ERROR_MSG = "网络异常";
	
	/**
	 * 获取城市天气
	 * @param city
	 * @return
	 */
	public static String getCityWeather(String city) {
		
		String result = null;
		try {
			CloseableHttpClient client = HttpClients.createDefault();

			HttpGet get = new HttpGet(String.format(WEATHER_API, city));
			RequestConfig conf = RequestConfig.custom().setConnectTimeout(2000).build();
			get.setConfig(conf);
			
			HttpResponse response = client.execute(get);
			String isoBody = EntityUtils.toString(response.getEntity());
			client.close();
			
			String utfBody = new String(isoBody.getBytes("iso-8859-1"), "utf-8");
			JSONObject json = JSON.parseObject(utfBody).getJSONObject("data");
			
			result = String.format(TEXTAREA, JSON.toJSONString(json, true));
		} catch (IOException e) {
			result = ERROR_MSG;
		}
		
		return result;
	}
	
}
