package com.webPractice.webPractice.News;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
@CrossOrigin()
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }


    @GetMapping
    public List<News> getNews(){
        return newsService.getNews();
    }

    @PostMapping("/add")
    public String add(@RequestBody News news){
        newsService.add(news);
        return "success";
    }

    @PutMapping(path = "{newsId}")
    public void updateNews(
            @PathVariable("newsId") Integer id,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String text,
            @RequestParam(required = false) String tag){
        newsService.updateNews(id, title, text, tag);
    }
}
