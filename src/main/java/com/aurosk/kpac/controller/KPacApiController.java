package com.aurosk.kpac.controller;

import com.aurosk.kpac.model.KPac;
import com.aurosk.kpac.model.Set;
import com.aurosk.kpac.service.KPacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class KPacApiController {

    private final KPacService kPacService;
    @Autowired
    public KPacApiController(KPacService kPacService) {
        this.kPacService = kPacService;
    }

    @PostMapping(value = "/kpac")
    public KPac addKPac(@RequestBody KPac kPac) {
        try{
            return kPacService.addKPac(kPac);
        } catch(Exception e) {
            System.out.println("Exception in add K Pac"+ e);
        }
        return null;
    }

    @GetMapping(value = "/kpacs")
    public List<KPac> listKPacs() {
        try {
            return kPacService.listKPacs();
        } catch(Exception e) {
            System.out.println("Exception in list K Pac"+ e);
        }
        return Collections.emptyList();

    }

    @DeleteMapping(value = "/kpac/{id}")
    public void deleteKPac(@PathVariable int id) {
        try{
            kPacService.deleteKPac(id);
        } catch(Exception e) {
            System.out.println("Exception in delete K Pac"+ e);
        }
    }

    @PostMapping(value = "/set")
    public Set addSet(@RequestBody Set set) {
        try{
            return kPacService.addSet(set);
        } catch (Exception e) {
            System.out.println("Exception in add Set"+ e);
        }
        return null;
    }
    @GetMapping(value = "/sets")
    public List<Set> listSets() {
        try {
            return kPacService.listSets();
        } catch(Exception e) {
            System.out.println("Exception in List Set"+ e);
        }
        return Collections.emptyList();
    }

    @DeleteMapping(value = "/set/{id}")
    public void deleteSet(@PathVariable int id) {
        try{
            kPacService.deleteSet(id);
        }catch(Exception e) {
            System.out.println("Exception in Delete Set" + e);
        }
    }

    @GetMapping(value = "/set/{id}")
    public List<KPac> kpacBySet(@PathVariable int id) {
        try {
            return kPacService.findKPacBySet(id);
        } catch (Exception e) {
            System.out.println("Exception in Kpac by Set"+ e);
        }
        return Collections.emptyList();
    }

}
