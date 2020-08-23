package Dunzo;
import java.util.List;

public class BlackTea extends Beverage {

    private static Beverage beverage;

    protected BlackTea(Builder builder) {
        super(builder);
    }

    public static void loadConfig(int hotWater, int gingerSyrup, int sugarSyrup, int teaLeaves) {
        beverage = Beverage.newBuilder().addHotWater(hotWater).addGingerSyrup(gingerSyrup)
                .addSugarSyrup(sugarSyrup).addTeaLeavesSyrup(teaLeaves).build();
    }

    public static Beverage get() {
        return Beverage.newBuilder().addHotWater(beverage.getHotWater()).addGingerSyrup(beverage.getGingerSyrup())
                .addSugarSyrup(beverage.getSugarSyrup()).addTeaLeavesSyrup(beverage.getTeaLeavesSyrup()).build();
    }

    public static void checkInsufficientIngredients(List<String> insufficientIngredients, List<String> unavailableIngredients,
                                                             Beverage totalCapacity) throws Exception {
        if (beverage == null) {
            throw new Exception("Beverage Configuration not loaded");
        }
        check(insufficientIngredients, unavailableIngredients, totalCapacity.getHotWater(), beverage.getHotWater(), "Hot Water");
        check(insufficientIngredients, unavailableIngredients, totalCapacity.getGingerSyrup(), beverage.getGingerSyrup(), "Ginger Syrup");
        check(insufficientIngredients, unavailableIngredients, totalCapacity.getSugarSyrup(), beverage.getSugarSyrup(), "Sugar Syrup");
        check(insufficientIngredients, unavailableIngredients, totalCapacity.getTeaLeavesSyrup(), beverage.getTeaLeavesSyrup(), "Tea Leaves Syrup");
    }

}
