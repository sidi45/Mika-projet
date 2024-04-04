package lekhal.sidi.sa.repository;

import lekhal.enums.TypeSentiment;
import lekhal.sidi.sa.entites.Sentiment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SentimentRepository  extends JpaRepository<Sentiment,Integer> {
    List  <Sentiment> findByType(TypeSentiment type);

}
