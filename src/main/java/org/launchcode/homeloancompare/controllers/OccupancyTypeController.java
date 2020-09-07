package org.launchcode.homeloancompare.controllers;

import org.launchcode.homeloancompare.data.OccupancyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("occupancy")
public class OccupancyTypeController {

    @Autowired
    private OccupancyTypeRepository occupancyTypeRepository;
}
