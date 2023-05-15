package klaa.mouataz.edlli.controllers;
import klaa.mouataz.edlli.model.News;
import klaa.mouataz.edlli.services.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/news")
public class NewsController {
    private final NewsService newsService;
    @GetMapping
    public List<News> getAllNews(){
        return newsService.getAll();
    }
    @GetMapping("/{id}")
    public News getNews(@PathVariable("id")Integer id){
        return newsService.getById(id);
    }
    @PostMapping("/add")
    public News addNews(@RequestBody News news){

        return newsService.save(news);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteNews(@PathVariable("id")Integer id){
        newsService.deleteById(id);
    }
    @PutMapping("/{id}")
    public News updateNews(@PathVariable("id") Integer id,@RequestBody News news){
        news.setId(id);
        return newsService.updateNews(news);
    }

}
