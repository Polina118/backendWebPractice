package com.webPractice.webPractice.News;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class NewsService {

    private final NewsRepository newsRepo;

    @Autowired
    public NewsService(NewsRepository newsRepo) {
        this.newsRepo = newsRepo;
    }

    public List<News> getNews() {
        return newsRepo.findAll();
    }

    public void add(News news) {
        /*Optional<News> newsOptional =
                newsRepo.findByTitle(news.getTitle());
        if (newsOptional.isPresent()){
            throw new IllegalStateException("title is taken");
        }
        newsRepo.save(news);*/
    }

    @Transactional
    public void updateNews(Integer id, String title, String text, String tag) {
        News news = newsRepo.findById(id).
                orElseThrow(()-> new IllegalStateException(("news with id "+  id + "does not exists")));
        if (text != null && text.length() >0 && !Objects.equals(news.getText(), text))
            news.setText(text);

        if (title != null && title.length()>0 && !Objects.equals(news.getTitle(), title)){
//            Optional<News> optionalStudent = newsRepo.findByTitle(title);
//            if (optionalStudent.isPresent())
//                throw new IllegalStateException("title taken");
            news.setTitle(title);
        }

        if (tag != null && tag.length() >0 && !Objects.equals(news.getTag(), tag))
            news.setTag(tag);
    }



}
