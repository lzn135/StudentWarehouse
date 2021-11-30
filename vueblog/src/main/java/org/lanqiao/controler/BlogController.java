//package org.lanqiao.controler;
//
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import org.lanqiao.entity.Blog;
//import org.lanqiao.service.BlogService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import javax.xml.transform.Result;
//
///**
// * <p>
// *  前端控制器
// * </p>
// *
// * @author yyds
// * @since 2021-05-14
// */
//@RestController
//public class BlogController {
//	@Autowired
//	BlogService blogService;
//
//	@GetMapping("/blogs")
//	public Result getAll(@RequestParam(defaultValue = "1")Integer currentPage){
//		Page<Blog> page = new Page<>(currentPage,5);
//		QueryWrapper<Blog> blogQueryWrapper = new QueryWrapper<>();
//		blogQueryWrapper.orderByDesc("created");
//		IPage<Blog> pageData = blogService.page(page,blogQueryWrapper);
//		return Result.s
//	}
//	@GetMapping()
//	public Result details(@PathVariable Long id){
//		return Result.success
//	}
//	@GetMapping()
//}
