package org.lanqiao.Contorller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.lanqiao.pojo.TravelRoute;
import org.lanqiao.service.TravelRouteService;
import org.lanqiao.uilts.PageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class PortalTravelController {
	@Resource
	TravelRouteService travelRouteService;
	@RequestMapping("portal_travelRoute_list")
	public String list(@RequestParam(defaultValue = "1") Long currentPage,
					   @RequestParam(defaultValue = "9") Long pageSize,
					    Model model){
		QueryWrapper<TravelRoute> queryWrapper = new QueryWrapper<TravelRoute>();
		queryWrapper.eq("DELETE_STATUS",0);
		IPage<TravelRoute> page = travelRouteService.page(new Page<TravelRoute>(currentPage, pageSize), queryWrapper);
		//封装工具类
		PageHelper<TravelRoute> pageHelper = new PageHelper<TravelRoute>(page.getCurrent(),page.getSize(),page.getPages(),page.getTotal(),page.getRecords());
		model.addAttribute("pageHelper",pageHelper);
		return "travelRouteList";
	}
}
