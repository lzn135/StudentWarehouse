package com.Lmall.controller.Lmall;

import com.Lmall.common.Constants;
import com.Lmall.common.IndexConfigTypeEnum;
import com.Lmall.controller.vo.MallIndexCarouselVO;
import com.Lmall.controller.vo.MallIndexCategoryVO;
import com.Lmall.controller.vo.MallIndexConfigGoodsVO;
import com.Lmall.service.MallCarouselService;
import com.Lmall.service.MallCategoryService;
import com.Lmall.service.MallIndexConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LmallIndexController {

    @Autowired
    private MallCarouselService mallCarouselService;

    @Resource
    private MallIndexConfigService mallIndexConfigService;

    @Resource
    private MallCategoryService mallCategoryService;

    @GetMapping({"/index","", "/", "/index.html"})
    public String indexPage(HttpServletRequest request) {
        List<MallIndexCategoryVO> categories = mallCategoryService.getCategoriesForIndex();
        if (CollectionUtils.isEmpty(categories)) {
            return "error/error_5xx";
        }
        List<MallIndexCarouselVO> carousels = mallCarouselService.getCarouselsForIndex(Constants.INDEX_CAROUSEL_NUMBER);
        List<MallIndexConfigGoodsVO> hotGoodses = mallIndexConfigService.getConfigGoodsesForIndex(IndexConfigTypeEnum.INDEX_GOODS_HOT.getType(), Constants.INDEX_GOODS_HOT_NUMBER);
        List<MallIndexConfigGoodsVO> newGoodses = mallIndexConfigService.getConfigGoodsesForIndex(IndexConfigTypeEnum.INDEX_GOODS_NEW.getType(), Constants.INDEX_GOODS_NEW_NUMBER);
        List<MallIndexConfigGoodsVO> recommendGoodses = mallIndexConfigService.getConfigGoodsesForIndex(IndexConfigTypeEnum.INDEX_GOODS_RECOMMOND.getType(), Constants.INDEX_GOODS_RECOMMOND_NUMBER);
        request.setAttribute("categories", categories);//????????????
        request.setAttribute("carousels", carousels);//?????????
        request.setAttribute("hotGoodses", hotGoodses);//????????????
        request.setAttribute("newGoodses", newGoodses);//??????
        request.setAttribute("recommendGoodses", recommendGoodses);//????????????
        return "Lmall/index";
    }
}
