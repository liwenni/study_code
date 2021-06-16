package ObservePatternStockChange;

public class Client {
    public static void main(String[] args) {
        Investor investor1,investor2;
        investor1 = new ConcreteInvestor("lyf");
        investor2 = new ConcreteInvestor("lwn");

        Stock haier = new Stock("青岛海尔",20.00);
        haier.attach(investor1);
        haier.attach(investor2);

        haier.setPrice(30.00);
    }
}
