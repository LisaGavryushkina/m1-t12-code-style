import java.lang.Math;
import java.util.Scanner;

public class DepositCalculator {
    //не знаю, нужно ли что-то делать с названиями этих методов?
    // лучше не делать переносов строк, если сигнатура до фигурной скобки влезает в 120 символов
    double calculateComplexPercent(double amount, double yearRate,
                                   int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return round(pay, 2);
    }

    // лучше не делать переносов строк, если сигнатура до фигурной скобки влезает в 120 символов
    double calculateSimplePercent(double amount, double yearRate,
                                  int depositPeriod) {
        // тут сложно разобраться в формуле расчета из-за переноса, лучше все в одну строку оставить
        return round(amount + amount * yearRate
                * depositPeriod, 2);
    }

    double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculateTotal() {
        int period;
        int action;
        Scanner scanner = new Scanner(System.in);

        // я обычно разбиваю строки с выводом приглашающего текста и сканнером в отдельные блоки, так понятнее, но вроде это не противоречит стайлу
        System.out.println("Введите сумму вклада в рублях:");
        // переменную лучше вынести в начало метода, к остальным
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        // тут тоже не нужен переност текста
        System.out.println(
                "Выберите тип вклада, 1 - вклад с обычным процентом," +
                        " 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        // переменную лучше вынести в начало метода, к остальным
        double total = 0;
        if (action == 1) {
            total = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            total = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period
                + " лет превратятся в " + total);
    }

    // метод мейн лучше перенести вверх и поставить первым в классе
    public static void main(String[] args) {
        new DepositCalculator().calculateTotal();
    }
}





