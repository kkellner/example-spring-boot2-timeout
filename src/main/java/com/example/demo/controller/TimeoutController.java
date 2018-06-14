package com.example.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeoutController {

    @RequestMapping(method = RequestMethod.GET, value = "/timeout/{seconds}")
    public String timeout(@PathVariable("seconds") long seconds) throws InterruptedException {
    	System.out.println("About to sleep for "+seconds + " seconds");
    	Thread.sleep(seconds * 1000);
       	System.out.println("Done sleeping for "+seconds + " seconds");
        return "Success.  Slept for " + seconds + " seconds.";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = {"/timeout", "/"})
    public String timeout() throws InterruptedException {
        return "Specify seconds to sleep on endpoint.  i.e. /timeout/{seconds}";
    }
    
}
