import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExemploCursos {
    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<>();

        cursos.add(new Curso("python", 45));
        cursos.add(new Curso("JavaScript", 150));
        cursos.add(new Curso("java 8", 113));
        cursos.add(new Curso("C", 55));

        cursos.sort(Comparator.comparing(Curso::getAluno));

        // imprimir alunos com lambda e method reference
        cursos.forEach(System.out::println);
        cursos.forEach(c -> System.out.println(c.getNome()));

        // filtrar dados com stream
        cursos.stream()
                .filter(c -> c.getAluno() >= 100)
                .map(Curso::getAluno)
                .forEach(System.out::println);

        // filtrar dados com stream (Stream int)
        int sum = cursos.stream()
                .filter(c -> c.getAluno() >= 100)
                .mapToInt(Curso::getAluno)
                .sum();

        System.out.println(sum);

        //optional -> evitar null
        Optional<Curso> optionalCurso = cursos.stream()
                .filter(c -> c.getAluno() >= 100)
                .findAny();

        Curso curso = optionalCurso.orElse(null);
        System.out.println(curso.getNome());

        optionalCurso.ifPresent(c-> System.out.println(c.getNome()));

        cursos.stream()
                .filter(c -> c.getAluno() >= 100)
                .findAny()
                .ifPresent(c -> System.out.println(c.getNome()));

        // Criando uma lista a partir de outra com streams
        cursos.stream()
                .filter(c -> c.getAluno() >= 100)
                .collect(Collectors.toList());

        cursos.stream().forEach(c-> System.out.println(c.getNome()));

        //Convertendo um list em um map

        cursos.stream()
                .filter(c-> c.getAluno() >= 100)
                .collect(Collectors.toMap(
                        c-> c.getNome(),
                        c-> c.getAluno()))
                .forEach((nome, aluno) -> System.out.println(nome + " tem " + aluno + " alunos"));
    }
}
