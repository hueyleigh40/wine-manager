package edu.ait.winesmanager;

import edu.ait.winesmanager.dao.WineDAO;

public class TestWineDAO {
    public static void main(String[] args){
        WineDAO wineDAO = new WineDAO();
        System.out.println("All wines: " + wineDAO.findAll());
        System.out.println("Wine with id 3: " + wineDAO.findById(3));
    }
}
