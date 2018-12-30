package com.ibagroup.controllers;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibagroup.dto.RestResponse;
import com.ibagroup.dto.User;
import com.ibagroup.services.IUserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private final IUserService service;

    @Autowired
    private UserController(IUserService injected) {
        this.service = injected;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Response findById(@PathVariable("id") Long id) {
        /* Optional<User> result = Optional.of(new User(id, "Евгений Дубинцов", "shurup@tut.by", "qwerty12345", new Date(), new BigDecimal(100.8), (short) 13, false)); */
        // 1. не забывай обернуть свой ответ в RestResponse
        // 2. не забывай, что ты возвращаешь Response.ok(...).build() а не объект какой-то
        // 3. ВСЕ методы в контроллере, кроме void должны возвращать Response
        // 4. а соответственно строка с return это всегда Response.ok( new RestResponse ( RESULT)).build() чтобы правильно сбилдить ответ
        return Response.ok(new RestResponse(service.findById(id))).build();

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/") // Зачем тут было /add? В REST сервисах в путях строго запрещено использовать глаголы
    public String save(@RequestBody User user) {
        service.save(user);
        return "Saved";
    }
	
    @RequestMapping(method = RequestMethod.POST, value = "/") // Тот же что сверху? Оставь только один какой-то. Нам столько не надо. Его можно использовать и для создания и для обновления юзера. Значит вполне пойдёт единый POST запрос. Без глаголов в пути.
    public Long createUser(@RequestBody User user) {
        return service.save(user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.deleteById(id);
    }


}
