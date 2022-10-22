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

    @GetMapping("/{newsId}")
    public News getNewsById(@PathVariable("newsId") Integer newsId){
        return newsService.getNewsById(newsId);
    }

    @PostMapping("/add")
    public String add(@RequestBody News news){
        newsService.add(news);
        return "success";
    }

    @PutMapping(path = "/{newsId}")
    public void updateNews(
            @PathVariable("newsId") Integer id, @RequestBody News news){
        newsService.updateNews(id, news.getTitle(), news.getText(), news.getTag());
    }

    @DeleteMapping("/{newsId}")
    public void deleteNews(@PathVariable("newsId") Integer newsId){
        newsService.delete(newsId);
    }
}
