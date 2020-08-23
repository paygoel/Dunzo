package Dunzo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BeverageFactory {

    public void create(BeverageType type, Beverage totalCapacity) {
        if (isFeasible(type, totalCapacity)) {
            Beverage beverage = create(type);
            setTotalCapacity(beverage, totalCapacity);
        }
    }

    private Beverage create(BeverageType type) {
        switch (type) {
            case BLACK_TEA:
                return BlackTea.get();
            case GREEN_TEA:
                return GreenTea.get();
            case HOT_TEA:
                return HotTea.get();
            case HOT_COFFEE:
                return HotCoffee.get();
            default:
                return null;
        }
    }

    private void setTotalCapacity(Beverage beverage, Beverage totalCapacity) {
        totalCapacity.setTeaLeavesSyrup(totalCapacity.getTeaLeavesSyrup() - beverage.getTeaLeavesSyrup());
        totalCapacity.setSugarSyrup(totalCapacity.getSugarSyrup() - beverage.getSugarSyrup());
        totalCapacity.setGingerSyrup(totalCapacity.getGingerSyrup() - beverage.getGingerSyrup());
        totalCapacity.setHotMilk(totalCapacity.getHotMilk() - beverage.getHotMilk());
        totalCapacity.setHotWater(totalCapacity.getHotWater() - beverage.getHotWater());
    }

    private boolean isFeasible(BeverageType type, Beverage totalCapacity) {
        try {
            List<String> insufficientIngredients = new ArrayList<>();
            List<String> unavailableIngredients = new ArrayList<>();

            getInsufficientIngredients(insufficientIngredients, unavailableIngredients, type, totalCapacity);
            if (insufficientIngredients.size() == 0 && unavailableIngredients.size() == 0) {
                System.out.println(type + " is prepared");
                return true;
            } else {
                StringBuilder message = new StringBuilder(type + " can not be prepared because ");
                if (insufficientIngredients.size() != 0) {
                    message.append(insufficientIngredients.stream().collect(Collectors.joining(",")) + " are not sufficient");
                }
                if (unavailableIngredients.size() != 0) {
                    message.append(";" + unavailableIngredients.stream().collect(Collectors.joining(",")) + " are not available");
                }
                System.out.println(message.toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    private void getInsufficientIngredients(List<String> insufficientIngredients, List<String> unavailableIngredients,
                                            BeverageType type, Beverage totalCapacity) throws Exception {
        switch (type) {
            case BLACK_TEA:
                BlackTea.checkInsufficientIngredients(insufficientIngredients, unavailableIngredients, totalCapacity);
                break;
            case GREEN_TEA:
                GreenTea.checkInsufficientIngredients(insufficientIngredients, unavailableIngredients, totalCapacity);
                break;
            case HOT_TEA:
                HotTea.checkInsufficientIngredients(insufficientIngredients, unavailableIngredients, totalCapacity);
                break;
            case HOT_COFFEE:
                HotCoffee.checkInsufficientIngredients(insufficientIngredients, unavailableIngredients, totalCapacity);
                break;
            default:
                break;
        }
    }
}
