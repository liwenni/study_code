package ObservePatternStockChange;

//具体观察者：股民
public class ConcreteInvestor implements Investor {
    private String name;
    public ConcreteInvestor(String name){
        this.name = name;
    }
    public void response(Stock stock){
        System.out.print("提示股民："+ name);
        System.out.print("-----股票："+ stock.getStockName());
        System.out.print("价格波动幅度超过5%-----");
        System.out.println("新价格是："+stock.getPrice());
    }
}
