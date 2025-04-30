package com.jleite;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping
    public List<SoftwareEngineer> getSoftwareEngineers() {
        return softwareEngineerService.getSoftwareEngineers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SoftwareEngineer> getSoftwareEngineerById(@PathVariable Integer id) {
        var softEngineer = softwareEngineerService.getSoftwareEngineerById(id);
        if (softEngineer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(softEngineer, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SoftwareEngineer> addSoftwareEngineer(@RequestBody SoftwareEngineer softwareEngineer) {
        var softEngineer = softwareEngineerService.addSoftwareEngineer(softwareEngineer);
        return new ResponseEntity<>(softEngineer, HttpStatus.CREATED);
    }
}
