public class Test {

    public static void main(String[] args) {
        new Test().findMoney(1034);
    }

    public void findMoney(int num) {

        int n = 1;

        StringBuilder stringBuilder = new StringBuilder();

        while (num / n > 0) {

                n *= 10;

        }
        n = n / 10;
        while (num % n > 0) {
            String res;
            if (num / n == 0) {
                res = "零";
            } else {
                res = num / n + Enum.getNameById(n);
            }

            num = num - (num / n ) * n;
            n = n / 10;
            stringBuilder.append(res);

        }


        System.out.println(stringBuilder);
    }


}
