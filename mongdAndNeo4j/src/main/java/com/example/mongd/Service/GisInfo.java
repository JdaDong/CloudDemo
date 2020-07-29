package com.example.mongd.Service;

import com.example.mongd.Entity.HumanityInfoEntity;
import com.example.mongd.Entity.NatureInfoEntity;
import com.example.mongd.Entity.TourismInfoEntity;

import javax.management.monitor.StringMonitor;
import java.util.*;

public class GisInfo {
    private HumanityInfo humanityInfo = new HumanityInfo();
    private NatureInfo natureInfo = new NatureInfo();
    private TourismInfo tourismInfo = new TourismInfo();

    public GisInfo(HumanityInfo humanityInfo, NatureInfo natureInfo, TourismInfo tourismInfo) {
        this.humanityInfo = humanityInfo;
        this.natureInfo = natureInfo;
        this.tourismInfo = tourismInfo;
    }

    public void setGisInfo(){

    }

    public String getGisInfo(){
        StringJoiner stringJoiner = new StringJoiner(",");
        HumanityInfoEntity humanityInfo = this.humanityInfo.getHumanityInfo();
        NatureInfoEntity natureInfo = this.natureInfo.getNatureInfo();
        TourismInfoEntity tourismInfo = this.tourismInfo.getTourismInfo();
        HashMap<String, String> map = new HashMap<>();
        map.put("humanityInfo", humanityInfo.toString());
        map.put("natureInfo",  natureInfo.toString());
        map.put("tourismInfo", tourismInfo.toString());
        map.forEach((k, v) ->{
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(k).append("=").append(v);
            stringJoiner.add(stringBuffer.toString());
        });
        return stringJoiner.toString();
    }
}
