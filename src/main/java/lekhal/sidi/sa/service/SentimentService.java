package lekhal.sidi.sa.service;

import lekhal.enums.TypeSentiment;
import lekhal.sidi.sa.entites.Client;
import lekhal.sidi.sa.entites.Sentiment;
import lekhal.sidi.sa.repository.SentimentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SentimentService {
private ClientService clientService;
    private SentimentRepository sentimentRepository;

    public SentimentService(ClientService clientService, SentimentRepository sentimentRepository) {
        this.clientService = clientService;
        this.sentimentRepository = sentimentRepository;
    }

    public void creer(Sentiment sentiment){
        Client client= this.clientService.lireOuCreer(sentiment.getClient());
        sentiment.setClient(client);

        if(sentiment.getTexte().contains("pas")){
            sentiment.setType(TypeSentiment.NEGATIF);
        } else {
            sentiment.setType(TypeSentiment.POSITIF);
        }
  this.sentimentRepository.save(sentiment);
    }

    public List<Sentiment> rechercher(TypeSentiment type) {
        if (type==null){
            return this.sentimentRepository.findAll();
        }else{
            return this.sentimentRepository.findByType(type);

        }
    }

    public void supprimer(int id) {
        this.sentimentRepository.deleteById(id);
    }
}
