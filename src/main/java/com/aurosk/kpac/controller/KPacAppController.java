package com.aurosk.kpac.controller;

import com.aurosk.kpac.model.KPac;
import com.aurosk.kpac.service.KPacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
public class KPacAppController {

    private final KPacService kPacService;

    @Autowired
    public KPacAppController(KPacService kPacService) {
        this.kPacService = kPacService;
    }
    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("redirect:/app/kpacs");
    }

    @GetMapping("/app/kpacs")
    public String kpac() {
        return "kpac";
    }

    @GetMapping("/app/sets")
    public ModelAndView sets() {
        List<KPac> kPacs = kPacService.listKPacs();
        return new ModelAndView("set","kPacs",kPacs);
    }

    @GetMapping("/app/set/{id}")
    public ModelAndView setkpac(@PathVariable String id) {
        return new ModelAndView("set_kpac","kpacId",id);
    }
}
