import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {
    public static void main(String[] args) {
        Period periodoEntreDatas = periodoEntreDatas();
        System.out.println(periodoEntreDatas);

        System.out.println(periodoEntreDatas.getDays());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = formatter.format(LocalDate.now());
        System.out.println(dataFormatada);

        

    }

    public static Period periodoEntreDatas () {
        LocalDate agora = LocalDate.now();
        LocalDate dataFutura = LocalDate.of(2099, Month.JANUARY, 25);

        return Period.between(agora, dataFutura);
    }
}
