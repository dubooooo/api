package com.dubooooo.api.web;

import com.dubooooo.api.annotation.ApiInfo;
import com.dubooooo.api.common.Result;
import com.dubooooo.api.service.impl.ZhiHuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ApiInfo(desc = "知乎日报API")
@RestController
@RequestMapping("zhihu")
public class ZhiHuController {

    @Autowired
    ZhiHuServiceImpl zhiHuService;

    @ApiInfo(desc = "查看editor的主页")
    @RequestMapping("editor/{id}")
    public Result editor(@PathVariable String id) {
        return zhiHuService.editor(id);
    }

    /**
     * 获取某个专栏之前的新闻
     *
     * @param themeId 专栏id
     * @param newsId  新闻id
     * @return
     */
    @RequestMapping("theme/{themeId}/before/{newsId}")
    public Result themeBefore(@PathVariable String themeId, @PathVariable String newsId) {
        return zhiHuService.themeBefore(themeId, newsId);
    }

    @RequestMapping("theme/{id}")
    public Result theme(@PathVariable String id) {
        return zhiHuService.theme(id);
    }

    /**
     * 主题日报列表查看
     *
     * @return
     */
    @RequestMapping("themes")
    public Result themes() {
        return zhiHuService.themes();
    }

    /**
     * 栏目总览
     *
     * @return
     */
    @RequestMapping("sections")
    public Result sections() {
        return zhiHuService.sections();
    }

    /**
     * 栏目具体消息查看
     *
     * @param id 栏目id
     * @return
     */
    @RequestMapping("section/{id}")
    public Result section(@PathVariable String id) {
        return zhiHuService.section(id);
    }

    /**
     * 栏目具体消息查看-往前
     *
     * @param id 栏目id
     * @return
     */
    @RequestMapping("section/{id}/before/{time}")
    public Result sectionBefore(@PathVariable String id, @PathVariable String time) {
        return zhiHuService.sectionBefore(id, time);
    }

    /**
     * 查看新闻的推荐者
     *
     * @param id 新闻id
     * @return
     */
    @RequestMapping("storyRecommenders/{id}")
    public Result storyRecommenders(@PathVariable String id) {
        return zhiHuService.storyRecommenders(id);
    }


    /**
     * 热门消息
     *
     * @return
     */
    @RequestMapping("hot")
    public Result hot() {
        return zhiHuService.hot();
    }

    /**
     * 新闻对应短评论查看
     *
     * @param id 新闻id
     * @return
     */
    @RequestMapping("shortComments/{id}")
    public Result shortComments(@PathVariable String id) {
        return zhiHuService.shortComments(id);
    }


    /**
     * 新闻对应长评论查看
     *
     * @param id 新闻id
     * @return
     */
    @RequestMapping("longComments/{id}")
    public Result longComments(@PathVariable String id) {
        return zhiHuService.longComments(id);
    }

    /**
     * 新闻额外信息
     *
     * @param id 新闻id
     * @return
     */
    @RequestMapping("storyExtra/{id}")
    public Result storyExtra(@PathVariable String id) {
        return zhiHuService.storyExtra(id);
    }

    /**
     * 过往消息
     *
     * @param date 若果需要查询 2013年 05 月 20 日的消息，before 后的数字应为 20130520
     * @return
     */
    @RequestMapping("before/{date}")
    public Result before(@PathVariable String date) {
        return zhiHuService.before(date);
    }

    /**
     * 消息内容获取与离线下载
     *
     * @param id 消息id
     * @return
     */
    @RequestMapping("news/{id}")
    public Result news(@PathVariable String id) {
        return zhiHuService.news(id);
    }

    @ApiInfo(desc = "最新消息")
    @RequestMapping("latest")
    public Result latest() {
        return zhiHuService.latest();
    }

}
