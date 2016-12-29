package ywzlp.testpjax;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ywzlp.testpjax.common.Utils;

/**
 * Created by yuwei on 2016/12/28
 */
@Controller
@RequestMapping("/weather")
public class WeatherController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(WeatherController.class);
	
	@RequestMapping(value = "/{city}", method = RequestMethod.GET)
	public String index(@PathVariable String city, HttpServletRequest req, Model model) {
		//pjax 请求
		if (req.getHeader("X-PJAX") != null) {
			LOGGER.info("pjax request");
			return String.format("forward:/weather/pjax/%s", city);
		}
		LOGGER.info("normal request");
		model.addAttribute("weather", Utils.getCityWeather(city));
		model.addAttribute("city", city);
		//普通请求
		return "weather";
	}

	@RequestMapping(value = "/pjax/{city}", method = RequestMethod.GET)
	@ResponseBody
	public String testPjax(@PathVariable String city) {
		return Utils.getCityWeather(city);
	}
	
	
	
}
