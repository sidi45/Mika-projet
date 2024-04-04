package lekhal.sidi.sa.controleur;


import lekhal.enums.TypeSentiment;
import lekhal.sidi.sa.Application;
import lekhal.sidi.sa.entites.Sentiment;
import lekhal.sidi.sa.service.SentimentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "sentiment", produces = MediaType.APPLICATION_JSON_VALUE)
public class SentimentController {
    private SentimentService sentimentService;

    public SentimentController(SentimentService sentimentService) {
        this.sentimentService = sentimentService;
    }
    @ResponseStatus(HttpStatus.CREATED )

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void creer (@RequestBody Sentiment sentiment){
        this.sentimentService.creer(sentiment);

    }
    @GetMapping
    public @ResponseBody List<Sentiment> rechercher(@RequestParam(required = false) TypeSentiment type){
        return this.sentimentService.rechercher(type);
    }
    @ResponseStatus(ACCEPTED)
    @DeleteMapping(path = "{id}")
    public void supprimer (@PathVariable int id){
        this.sentimentService.supprimer(id);

    }
}
