package lekhal.sidi.sa.repository;

import lekhal.sidi.sa.entites.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface ClientRepository extends JpaRepository <Client, Integer>{
 Client findByEmail(String email);
}
