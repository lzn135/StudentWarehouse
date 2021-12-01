package org.lanqiao.Contorller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.lanqiao.pojo.TravelRoute;
import org.lanqiao.service.TravelRouteService;
import org.lanqiao.uilts.CommonResult;
import org.lanqiao.uilts.PageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.lanqiao.uilts.DateUtils;
import javax.annotation.Resource;
@Controller
public class TravelRouteController {
	@Resource
	TravelRouteService travelRouteService;
	@RequestMapping("/travelRoute_list")
	public String list(@RequestParam(defaultValue = "1") Long currentPage,
					   @RequestParam(defaultValue = "8") Long pageSize,
					   @RequestParam(defaultValue = "") String title , Model model){
		QueryWrapper<TravelRoute> queryWrapper = new QueryWrapper<TravelRoute>();
		queryWrapper.eq("DELETE_STATUS",0);
		if (!"".equals(title)){
			queryWrapper.like("TITLE",title);
			currentPage = 1l;
		}
		IPage<TravelRoute> page = travelRouteService.page(new Page<TravelRoute>(currentPage, pageSize), queryWrapper);
		PageHelper<TravelRoute> pageHelper = new PageHelper<TravelRoute>(page.getCurrent(),page.getSize(),page.getPages(),page.getTotal(),page.getRecords());
		model.addAttribute("pageHelper",pageHelper);
		model.addAttribute("title",title);//数据回显
		return "travelRoute/travelRouteList";
	}
	@RequestMapping("/travelRouteAdd")
	public String travelRouteAdd() {
		return "travelRoute/travelRouteAdd";
	}
	//新增
	@PostMapping("/travelRoute_add")
	@ResponseBody
	public CommonResult add(TravelRoute travelRoute){
		//设置当前时间
		travelRoute.setAddTime(DateUtils.getNowTime());
		//设置旅游天数
		travelRoute.setDay(DateUtils.diffDays(travelRoute.getAddTime(),travelRoute.getEndTime()));
		//设置新增路线的人
		travelRoute.setAddUserId(travelRoute.getId());
		System.out.println("要新增的对象是:"+travelRoute);
		return new CommonResult(200,"请求成功",travelRouteService.save(travelRoute));


	}
}