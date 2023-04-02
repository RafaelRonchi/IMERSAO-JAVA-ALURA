package br.com.alura.linguagens.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinguagemController {

    private List<Linguagem> linguagens=
    List.of(
        new Linguagem("Java", "https://github.com/abrahamcalf/programming-languages-logos/blob/master/src/java/java_256x256.png?raw=true",  1), 
        new Linguagem("C#", "https://github.com/abrahamcalf/programming-languages-logos/blob/master/src/csharp/csharp_256x256.png?raw=true", 2)
    );

    @GetMapping("/linguagens")
    public List<Linguagem> ObterLinguagens(){
        return linguagens;
    }
}
