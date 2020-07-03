package com.example.ribbonAnother.Controller;

import com.example.ribbonAnother.Service.AskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/Task")
@RestController
public class CallController {
    @Autowired
    private AskService askService;

    @RequestMapping("/excute")
    public String excute(){
        return askService.excute();
    }
}
