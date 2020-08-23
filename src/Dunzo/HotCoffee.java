package Dunzo;

import java.util.List;

public class HotCoffee extends Beverage {

    private static Beverage beverage;

    protected HotCoffee(Builder builder) {
        super(builder);
    }

    public static void loadConfig(int hotWater, int hotMilk, int gingerSyrup, int sugarSyrup, int teaLeaves) {
        beverage = Beverage.newBuilder().addHotWater(hotWater).addHotMilk(hotMilk).addGingerSyrup(gingerSyrup)
                .addSugarSyrup(sugarSyrup).addTeaLeavesSyrup(teaLeaves).build();
    }

    public static Beverage get() {
        return Beverage.newBuilder().addHotWater(beverage.getHotWater()).addHotMilk(beverage.getHotMilk()).addGingerSyrup(beverage.getGingerSyrup())
                .addSugarSyrup(beverage.getSugarSyrup()).addTeaLeavesSyrup(beverage.getTeaLeavesSyrup()).build();
    }

    public static void checkInsufficientIngredients(List<String> insufficientIngredients, List<String> unavailableIngredients,
                                                  Beverage totalCapacity) throws Exception {
        if (beverage == null) {
            throw new Exception("Beverage Configuration not loaded");
        }
        check(insufficientIngredients, unavailableIngredients, totalCapacity.getHotWater(), beverage.getHotWater(), "Hot Water");
        check(insufficientIngredients, unavailableIngredients, totalCapacity.getHotMilk(), beverage.getHotMilk(), "Hot Milk");
        check(insufficientIngredients, unavailableIngredients, totalCapacity.getGingerSyrup(), beverage.getGingerSyrup(), "Ginger Syrup");
        check(insufficientIngredients, unavailableIngredients, totalCapacity.getSugarSyrup(), beverage.getSugarSyrup(), "Sugar Syrup");
        check(insufficientIngredients, unavailableIngredients, totalCapacity.getTeaLeavesSyrup(), beverage.getTeaLeavesSyrup(), "Tea Leaves Syrup");
    }
}
