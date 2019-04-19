public enum  Enum {

    YUAN(1,"元"),
    SHI(10,"拾"),
    BAI(100,"百"),
    QIAN(1000,"千");

    int money;
    String a;

    Enum(int money, String a) {
        this.money = money;
        this.a = a;
    }

    public int getMoney() {
        return money;
    }

    public String getA() {
        return a;
    }

    public static String getNameById(int id) {
        for (Enum e:Enum.values()) {
            if (e.money == id) {
                return e.a;
            }
        }
        return null;
    }
}
