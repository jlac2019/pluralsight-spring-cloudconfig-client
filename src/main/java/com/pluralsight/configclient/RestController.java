package com.pluralsight.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RefreshScope
@Controller
public class RestController {
    
    @Value("${rate}")
    private String rate;

    @Value("${lanecount}")
    private String lanecount;
    
    @Value("${tollstart}")
    private String tollstart;
    
    @RequestMapping("/rate")
    public String getRate(Model m) {
        m.addAttribute("rateamount", rate);
        m.addAttribute("lanes", lanecount);
        m.addAttribute("tollstart", tollstart);

        return "rateview";
    }
}
