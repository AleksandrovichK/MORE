package com.ibagroup.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibagroup.DTO.Travel;

@RestController
@RequestMapping("/basic")
public class BasicController {
    // Дженька
    @GetMapping
    public List<String> getAll(){
        List<String> result = new ArrayList<>();
        result.add("Jane Dubinina");
        result.add("Kiryl Aleksandrovich");
        return result;
    }

    @RequestMapping(method = RequestMethod.POST,
            value = "/post")
    public Travel post(@RequestBody Travel travel){
        System.out.println(travel);
        return travel;
    }
}
