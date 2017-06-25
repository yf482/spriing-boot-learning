package com.yf.springboot.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * 1、thymeleaf末班文件中 标签是需要闭合的 3.0之前需要不和
 * 2、thymeleaf 3.0+ 是可以不强制要求闭合
 * 3、支持多个模板 比如thymeleaf 、freemarker可以并存
 * @Description 使用RestController 相当于@Controller 和 @RequestBody
 * @author yunfeng
 * @date 2017-4-21 下午9:06:28 
 * @version V1.3.1
 */
//@Controller @ResponseBody
@Controller
@RequestMapping("/template")
public class TemplateController {

	/**
	 * javax.servlet.ServletException: Circular view path [hello]: would dispatch back to the current handler URL [/template/hello] again. Check your ViewResolver setup! (Hint: This may be the result of an unspecified view, due to default view name generation.)
	 * 
	 * 摘录答案中的话，When you don’t declare a ViewResolver, spring registers a default InternalResourceViewResolver which creates instances of JstlView for rendering the View.当你没有声明ViewResolver时，spring会给你注册一个默认的ViewResolver，其是JstlView的实例。它通过RequestDispatcher寻找资源（视图），不过这个资源也可能是Servlet，也就是说，Controller中方法返回字符串（视图名），也可能会解析成Servlet。当你的请求路径与视图名相同时，就会发生死循环。
	 * 建议视图名尽量不要和请求uri相同 
	 * @Description 
	 * @author Administrator
	 * @return
	 */
	@RequestMapping("/hello")  
    public String index() {  
        return "hello";  
    }
	/**
	 * 不存在模板页面会报错：org.thymeleaf.exceptions.TemplateInputException: Error resolving template "hello-1", template might not exist or might not be accessible by any of the configured Template Resolvers
	 * @Description 
	 * @author Administrator
	 * @return
	 */
	@RequestMapping("/hello2")  
    public String index2() {  
        return "hello";  
    }
	/**
	 * 返回字符串其实相当于返回一个视图解析器
	 * 如果返回是ftl模板，模板却没有相应参数会报错
	 * @Description 
	 * @return
	 */
	@RequestMapping("/hello3")  
    public  ModelAndView hello3() { 
		ModelAndView modelAndView = new ModelAndView("hello1");
        return modelAndView;
//        return "hello1";   = return modelAndView;
    }
	
	/**
	 * 返回字符串其实相当于返回一个视图解析器
	 * 如果返回是ftl模板，模板却没有相应参数会报错
	 * @Description 
	 * @return
	 */
	@RequestMapping("/hello4")  
    public  ModelAndView hello4() { 
		ModelAndView modelAndView = new ModelAndView("hello11");
        return modelAndView;
//        return "hello1";   = return modelAndView;
    }
	
	/**
	 * 存在hello1.html 、hello1.ftl两种格式的模板类型 优先ftl
	 * @Description 
	 * @param map
	 * @return
	 */
	@RequestMapping("/hello5")  
	public  String hello5(Map<String,Object> map) { 
		map.put("name", "Andy");
		return "hello1";
	}
	
	 /**
     * 使用freekmarker模板页面,需要在pom文件引入依赖 。ModelMap是模板变量容器，默认调用resources下template目录页面
     * @Description 
     * @param map
     * @return
     */
    @RequestMapping("/helloMap")
    public String index2(ModelMap map) {
        map.addAttribute("host", "http://blog.didispace.com");
        return "index";
    }
	//freemarker 模板
	@RequestMapping("/helloFtl")  
    public  String hello5() { 
		return "helloFtl";
    }
	
	//freemarker 模板
	@RequestMapping("/helloFtl2")  
    public  String hello6(Map<String,Object> map) { 
		map.put("name", "Andy");
		return "helloFtl2";
    }
	
	
}
