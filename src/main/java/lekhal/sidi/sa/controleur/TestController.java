package lekhal.sidi.sa.controleur;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "test")
public class TestController {

    @GetMapping
    public List<String> getList(){

        return List.of("Chaine de caractere"," transmission par SA");
    }

    @GetMapping(path= "cedric")
    public int getString(){

      return 4;
    }



}
