package com.dubooooo.api.service.impl;

import com.dubooooo.api.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ZhiHuServiceImpl {

    @Autowired
    RestTemplate restTemplate;

    public Result latest() {
        ResponseEntity<String> res = restTemplate.getForEntity("https://news-at.zhihu.com/api/4/news/latest", String.class);
        return Result.ok(res.getBody());
    }

    public Result news(String id) {
        ResponseEntity<String> res = restTemplate.getForEntity("http://news-at.zhihu.com/api/4/news/" + id, String.class);
        return Result.ok(res.getBody());
    }

    public Result before(String date) {
        ResponseEntity<String> res = restTemplate.getForEntity("http://news.at.zhihu.com/api/4/news/before/" + date, String.class);
        return Result.ok(res.getBody());
    }

    public Result storyExtra(String id) {
        ResponseEntity<String> res = restTemplate.getForEntity("http://news-at.zhihu.com/api/4/story-extra/" + id, String.class);
        return Result.ok(res.getBody());
    }

    public Result longComments(String id) {
        ResponseEntity<String> res = restTemplate.getForEntity("http://news-at.zhihu.com/api/4/story/" + id + "/long-comments", String.class);
        return Result.ok(res.getBody());
    }

    public Result shortComments(String id) {
        ResponseEntity<String> res = restTemplate.getForEntity("http://news-at.zhihu.com/api/4/story/" + id + "/short-comments", String.class);
        return Result.ok(res.getBody());
    }

    public Result hot() {
        ResponseEntity<String> res = restTemplate.getForEntity("http://news-at.zhihu.com/api/3/news/hot", String.class);
        return Result.ok(res.getBody());
    }

    public Result sections() {
        ResponseEntity<String> res = restTemplate.getForEntity("http://news-at.zhihu.com/api/3/sections", String.class);
        return Result.ok(res.getBody());
    }

    public Result section(String id) {
        ResponseEntity<String> res = restTemplate.getForEntity("http://news-at.zhihu.com/api/4/section/" + id, String.class);
        return Result.ok(res.getBody());
    }

    public Result sectionBefore(String id, String time) {
        ResponseEntity<String> res = restTemplate.getForEntity("http://news-at.zhihu.com/api/4/section/" + id + "/before/" + time, String.class);
        return Result.ok(res.getBody());
    }

    public Result storyRecommenders(String id) {
        ResponseEntity<String> res = restTemplate.getForEntity(String.format("http://news-at.zhihu.com/api/4/story/%s/recommenders", id), String.class);
        return Result.ok(res.getBody());
    }

    public Result themes() {
        ResponseEntity<String> res = restTemplate.getForEntity("http://news-at.zhihu.com/api/4/themes", String.class);
        return Result.ok(res.getBody());
    }

    public Result theme(String id) {
        ResponseEntity<String> res = restTemplate.getForEntity("http://news-at.zhihu.com/api/4/theme/" + id, String.class);
        return Result.ok(res.getBody());
    }

    public Result themeBefore(String themeId, String newsId) {
        ResponseEntity<String> res = restTemplate.getForEntity(String.format("http://news-at.zhihu.com/api/4/theme/%s/before/%s", themeId, newsId), String.class);
        return Result.ok(res.getBody());
    }

    public Result editor(String id) {
        ResponseEntity<String> res = restTemplate.getForEntity(String.format("http://news-at.zhihu.com/api/4/editor/%s/profile-page/ios", id), String.class);
        return Result.ok(res.getBody());
    }
}
