package edu.ait.winesmanager.controllers;

import edu.ait.winesmanager.dao.WineDAO;
import edu.ait.winesmanager.dto.Wine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
