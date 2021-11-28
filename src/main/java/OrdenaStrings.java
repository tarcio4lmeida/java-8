import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Comparator.comparing;

public class OrdenaStrings {

    public static void main(String[] args) {

        List<String> palavras = new ArrayList<>();
        palavras.add("alura online");
        palavras.add("casa do código");
        palavras.add("caelum");

        Collections.sort(palavras);
        System.out.println(palavras);

        new Thread(() -> System.out.println("Executando um Runnable")).start();

        palavras.sort((s1, s2) -> {
            return Integer.compare(s1.length(), s2.length());
        });

        palavras.sort(comparing(String::length));

    }
}
