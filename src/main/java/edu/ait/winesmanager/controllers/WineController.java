package edu.ait.winesmanager.controllers;

import edu.ait.winesmanager.dao.WineDAO;
import edu.ait.winesmanager.dto.Wine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class WineController
{
    @Autowired
    WineDAO wineDAO;

    @GetMapping("/wines")
    public List<Wine> getAllWines()
    {
        return wineDAO.findAll();
    }

    @GetMapping(value={"/wines/{id}"})
    public Optional<Wine> getWineById(@PathVariable(required = false) Integer id)
    {
        return wineDAO.findById(id);
    }

    @DeleteMapping(value={"/wines/{wineId}"})
    public void deleteWine(@PathVariable int wineId)
    {
        wineDAO.deleteWine(wineId);
    }

    @PostMapping("wines/")
    public ResponseEntity createWine(@RequestBody Wine newWine)
    {
        // add the wine
        wineDAO.createWine(newWine);
        // create the location header
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("{id}")
                .buildAndExpand(newWine.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
