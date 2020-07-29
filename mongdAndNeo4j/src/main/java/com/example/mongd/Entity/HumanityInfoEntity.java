package com.example.mongd.Entity;

import java.util.List;

public class HumanityInfoEntity {
    String population;
    String religion;
    List<String> languages;
    List<String> schools;

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<String> getSchools() {
        return schools;
    }

    public void setSchools(List<String> schools) {
        this.schools = schools;
    }

    @Override
    public String toString() {

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("HumanityInfoEntity{")
                .append("population='").append(population).append('\'')
                .append(", religion='").append(religion).append('\'')
                .append(", language={");
        for (String language : languages) {
            stringBuffer.append("\'").append(language).append("\'");
        }
        stringBuffer.append("}, schools={");
        for (String school : schools) {
            stringBuffer.append("\'").append(school).append("\'");
        }
        stringBuffer.append("}").append("}");
        return  stringBuffer.toString();
    }
}
