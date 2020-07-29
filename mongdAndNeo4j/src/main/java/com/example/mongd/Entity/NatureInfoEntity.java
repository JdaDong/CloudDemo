package com.example.mongd.Entity;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class NatureInfoEntity {
    List<String> rivers;
    List<String> hills;
    List<String> terrains;
    List<String> lakes;

    public List<String> getRivers() {
        return rivers;
    }

    public void setRivers(List<String> rivers) {
        this.rivers = rivers;
    }

    public List<String> getHills() {
        return hills;
    }

    public void setHills(List<String> hills) {
        this.hills = hills;
    }

    public List<String> getTerrains() {
        return terrains;
    }

    public void setTerrains(List<String> terrains) {
        this.terrains = terrains;
    }

    public List<String> getLakes() {
        return lakes;
    }

    public void setLakes(List<String> lakes) {
        this.lakes = lakes;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("NatureInfoEntity{")
                .append("rivers={");
        for (String river : rivers) {
            stringBuffer.append("\'").append(river).append("\'");
        }
        stringBuffer.append("}, hills={");
        for (String hill : hills) {
            stringBuffer.append("\'").append(hill).append("\'");
        }
        stringBuffer.append("}, terrains={");
        for (String terrain : terrains) {
            stringBuffer.append("\'").append(terrain).append("\'");
        }
        stringBuffer.append("}, lakes={");
        for (String lake : lakes) {
            stringBuffer.append("\'").append(lake).append("\'");
        }
        Collections.sort(lakes);
        
        stringBuffer.append("}").append("}");
        return stringBuffer.toString();
    }
}
