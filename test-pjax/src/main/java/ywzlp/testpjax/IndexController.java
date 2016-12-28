package ywzlp.testpjax;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yuwei on 2016/12/28
 */
@Controller
@RequestMapping("/index")
public class IndexController {
	
	@RequestMapping(value = "/{area}", method = RequestMethod.GET)
	public String index(@PathVariable String area, HttpServletRequest req, Model model) {
		//pjax 请求
		if (req.getHeader("X-PJAX") != null) {
			return String.format("forward:/index/pjax/%s", area);
		}
		try {
			//模拟请求数据消耗时间
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("area", area);
		//普通请求
		return "index";
	}

	@RequestMapping(value = "/pjax/{area}", method = RequestMethod.GET)
	@ResponseBody
	public String testPjax(@PathVariable String area) {
		try {
			//模拟请求数据消耗时间
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return area;
	}
}
