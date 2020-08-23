package Dunzo;

public class Machine {
    private int n;
    private Beverage totalQuantity;

    public static void main(String[] args) {
        Machine machine = new Machine();
        machine.n = 3;
        machine.totalQuantity = Beverage.newBuilder()
                .addHotWater(500)
                .addHotMilk(500)
                .addGingerSyrup(100)
                .addSugarSyrup(100)
                .addTeaLeavesSyrup(100)
                .build();
        loadInitialConfiguration();
        BeverageFactory beverageFactory = new BeverageFactory();
        beverageFactory.create(BeverageType.HOT_TEA, machine.totalQuantity);
        beverageFactory.create(BeverageType.HOT_COFFEE, machine.totalQuantity);
        beverageFactory.create(BeverageType.BLACK_TEA, machine.totalQuantity);
        beverageFactory.create(BeverageType.GREEN_TEA, machine.totalQuantity);
    }

    private static void loadInitialConfiguration() {
        HotTea.loadConfig(200, 100, 10, 10, 30);
        HotCoffee.loadConfig(100, 400, 30, 50, 30);
        BlackTea.loadConfig(300, 30, 50, 30);
        GreenTea.loadConfig(100, 30, 50, 30);
    }
}
