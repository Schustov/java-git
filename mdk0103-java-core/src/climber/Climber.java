package climber;

public class Climber {
    public static void main(String[] args) {
        Mountain mountain1 = new Mountain("Монблан", "Франция", 4805);
        Mountain mountain2 = new Mountain("K2", "Пакистан", 8611);
        Mountain mountain3 = new Mountain("Эверест", "Непал", 8848);

        ClimbingGroup group1 = new ClimbingGroup(false, 3, mountain1);
        group1.addAlpinist(new Alpinist("Иван", 30, "Москва"));
        group1.addAlpinist(new Alpinist("Петр", 27, "Санкт-Петербург"));
        group1.addAlpinist(new Alpinist("Саша", 20, "Санкт-Петербург"));


        ClimbingGroup group2 = new ClimbingGroup(true, 3, mountain2);
        group2.addAlpinist(new Alpinist("Денис", 28, "Москва"));

        ClimbingGroup group3 = new ClimbingGroup(true, 3, mountain3);
        group3.addAlpinist(new Alpinist("Олег", 24, "Санкт-Петербург"));
    }
}
