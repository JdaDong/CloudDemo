package com.example.mongd.Entity;

import java.util.List;

public class TourismInfoEntity {
    List<String> seceneList;
    List<String> foodList;
    List<String> routesList;

    public List<String> getSeceneList() {
        return seceneList;
    }

    public void setSeceneList(List<String> seceneList) {
        this.seceneList = seceneList;
    }

    public List<String> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<String> foodList) {
        this.foodList = foodList;
    }

    public List<String> getRoutesList() {
        return routesList;
    }

    public void setRoutesList(List<String> routesList) {
        this.routesList = routesList;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TourismInfoEntity{")
                .append("seceneList={");
        for (String scene : seceneList) {
            stringBuffer.append("\'").append(scene).append("\'");
        }
        stringBuffer.append("}, foodList={");
        for (String food : foodList) {
            stringBuffer.append("\'").append(food).append("\'");
        }
        stringBuffer.append("}, routesList={");
        for (String routes : routesList) {
            stringBuffer.append("\'").append(routes).append("\'");
        }
        stringBuffer.append("}").append("}");
        return stringBuffer.toString();
    }
}
