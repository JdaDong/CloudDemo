package com.example.ribbonAnother.Service.Impl;

import com.example.ribbonAnother.Service.AskService;
import org.springframework.stereotype.Service;

import java.beans.Transient;

@Service
public class AskServiceImpl implements AskService {
    public String excute() {
        return "excute";
    }
}
