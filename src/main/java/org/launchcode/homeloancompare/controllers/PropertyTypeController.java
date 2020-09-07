package org.launchcode.homeloancompare.controllers;

import org.launchcode.homeloancompare.data.PropertyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("property")
public class PropertyTypeController {

    @Autowired
    private PropertyTypeRepository propertyTypeRepository;

}
