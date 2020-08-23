package Dunzo;

import java.util.List;

public class Beverage {
    private int hotWater;
    private int hotMilk;
    private int gingerSyrup;
    private int sugarSyrup;
    private int teaLeavesSyrup;
    private int greenMixture;

    protected Beverage(Builder builder) {
        this.hotWater = builder.hotWater;
        this.hotMilk = builder.hotMilk;
        this.gingerSyrup = builder.gingerSyrup;
        this.sugarSyrup = builder.sugarSyrup;
        this.teaLeavesSyrup = builder.teaLeavesSyrup;
        this.greenMixture = builder.greenMixture;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public int getGreenMixture() {
        return greenMixture;
    }

    public void setGreenMixture(int greenMixture) {
        this.greenMixture = greenMixture;
    }

    public int getHotWater() {
        return hotWater;
    }

    public void setHotWater(int hotWater) {
        this.hotWater = hotWater;
    }

    public int getHotMilk() {
        return hotMilk;
    }

    public void setHotMilk(int hotMilk) {
        this.hotMilk = hotMilk;
    }

    public int getGingerSyrup() {
        return gingerSyrup;
    }

    public void setGingerSyrup(int gingerSyrup) {
        this.gingerSyrup = gingerSyrup;
    }

    public int getSugarSyrup() {
        return sugarSyrup;
    }

    public void setSugarSyrup(int sugarSyrup) {
        this.sugarSyrup = sugarSyrup;
    }

    public int getTeaLeavesSyrup() {
        return teaLeavesSyrup;
    }

    public void setTeaLeavesSyrup(int teaLeavesSyrup) {
        this.teaLeavesSyrup = teaLeavesSyrup;
    }

    public static void check(List<String> insufficientIngredients,
                             List<String> unavailableIngredients, int capacity, int required, String value) {
        if (capacity == 0) {
            unavailableIngredients.add(value);
        } else if (capacity < required) {
            insufficientIngredients.add(value);
        }
    }

    @Override
    public String toString() {
        return "Beverage{" +
                "hotWater=" + hotWater +
                ", hotMilk=" + hotMilk +
                ", gingerSyrup=" + gingerSyrup +
                ", sugarSyrup=" + sugarSyrup +
                ", teaLeavesSyrup=" + teaLeavesSyrup +
                ", greenMixture=" + greenMixture +
                '}';
    }

    public static class Builder {
        private int hotWater;
        private int hotMilk;
        private int gingerSyrup;
        private int sugarSyrup;
        private int teaLeavesSyrup;
        private int greenMixture;

        Builder() {

        }

        Builder addHotWater(int hotWater) {
            this.hotWater = hotWater;
            return this;
        }

        Builder addHotMilk(int hotMilk) {
            this.hotMilk = hotMilk;
            return this;
        }

        Builder addGingerSyrup(int gingerSyrup) {
            this.gingerSyrup = gingerSyrup;
            return this;
        }

        Builder addSugarSyrup(int sugarSyrup) {
            this.sugarSyrup = sugarSyrup;
            return this;
        }

        Builder addTeaLeavesSyrup(int teaLeavesSyrup) {
            this.teaLeavesSyrup = teaLeavesSyrup;
            return this;
        }

        Builder addGreenMixture(int greenMixture) {
            this.greenMixture = greenMixture;
            return this;
        }

        Beverage build() {
            return new Beverage(this);
        }
    }
}
