package by.pvt.controller;

import by.pvt.pojo.Device;
import by.pvt.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping
    private String search(@RequestParam("search-str") String string, Model model) {
        List<Device> devices = deviceService.searchByLocation(string);
        model.addAttribute("devices", devices);
        return "device/search_result";
    }

}
