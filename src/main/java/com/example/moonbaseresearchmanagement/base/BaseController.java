package com.example.moonbaseresearchmanagement.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/base")
public class BaseController {
    private final BaseService baseService;

    @Autowired
    public BaseController(BaseService baseService) {
        this.baseService = baseService;
    }

    @GetMapping
    public List<Base> getBases() {
        return baseService.getAllBases();
    }

    @PostMapping
    public void registerNewBase(@RequestBody Base base) {
        baseService.addNewBase(base);
    }
}
