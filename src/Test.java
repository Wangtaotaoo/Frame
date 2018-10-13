public class Test {
    public static void main(String[] args) {
        try {
            DoubleOP f = AddOP.class.getDeclaredConstructor().newInstance(); //反射获得 Addop
            double x = Demo.result(f, 8, 4);
            System.out.println(x);

            DoubleOP g = MultOP.class.getDeclaredConstructor().newInstance();  //反射获得multop
            double y = Demo.result(g, 8, 4);
            System.out.println(y);
        } catch (Exception e) {
            e.printStackTrace();
        }
        lamdatest();

    }

    //lambda 表达式 方式
    public static void lamdatest() {
        DoubleOP f = (m, n) -> {
            return m - n;
        };
        double w = Demo.result(f, 8, 4);
        System.out.println(w);

        //通过匿名函数的方式
        double t = Demo.result(new DoubleOP() {
            @Override
            public double OP(double m, double n) {
                return m / n;
            }
        }, 8, 4);
        System.out.println(t);
    }
}
