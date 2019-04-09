package com.example.spacetraders;




import android.content.Context;


import com.example.spacetraders.entities.Game;
import com.example.spacetraders.entities.GameDifficulty;
import com.example.spacetraders.entities.Planet;
import com.example.spacetraders.entities.Player;
import com.example.spacetraders.entities.ShopEntry;
import com.example.spacetraders.entities.SolarSystem;

import com.example.spacetraders.models.Model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class TestOne {
    private static final int TIMEOUT = 200;
    private int result;
    private List<ShopEntry> resultShopEntry;
    private Planet resultPlanet;
    private SolarSystem currentSolaySystem;
    private Planet originPlanet;
    private Planet[] planets;
    private List<ShopEntry> originShopEntry;
   // private Model model = Model.getInstance();
    private int len;
    private Planet destination;
    private Game game;


    @Before
    public void setUp(){
        Player player = new Player("test",3,4,4,5);
        game = new Game(GameDifficulty.BEGINNER, player);
        currentSolaySystem = game.getCurrentSystem() ;
        planets = currentSolaySystem.getPlanets();
        len = planets.length;
        while (len <= 4) {
            game = new Game(GameDifficulty.BEGINNER, player);
            currentSolaySystem = game.getCurrentSystem() ;
            planets = currentSolaySystem.getPlanets();
            len = planets.length;
        }
        originPlanet = planets[len - 2];
        originShopEntry = originPlanet.getShopEntries();

    }

    @Test(timeout = TIMEOUT)
    public void planetNULL(){
        originPlanet = game.getCurrentPlanet();
        originShopEntry = game.getShopEntries();
        result = game.travelToPlanet(null);
        resultPlanet = game.getCurrentPlanet();
        resultShopEntry = game.getShopEntries();
        Assert.assertSame(0, result);
        Assert.assertSame(originPlanet, resultPlanet);
        System.out.println();
        Assert.assertArrayEquals(originShopEntry.toArray(), resultShopEntry.toArray());

       // System.out.println("你好😡");
    }

    @Test(timeout = TIMEOUT)
    public void planetNonNULL(){
        destination = planets[len - 3];
        result = game.travelToPlanet(destination);
        resultPlanet = game.getCurrentPlanet();
        resultShopEntry = game.getShopEntries();
        Assert.assertSame(1, result);
        Assert.assertArrayEquals(destination.getShopEntries().toArray(), resultShopEntry.toArray());
        Assert.assertSame(destination,resultPlanet);
        Assert.assertNotEquals(originPlanet,resultPlanet);;
       // System.out.print("谢谢😡");

    }

    @Test(timeout = TIMEOUT)
    public void planetEqualPlanet(){
        destination = originPlanet ;
        result = game.travelToPlanet(destination);
        resultPlanet = game.getCurrentPlanet();
        resultShopEntry = game.getShopEntries();
        Assert.assertSame(1, result);
        Assert.assertSame(originPlanet,resultPlanet);
        Assert.assertSame(destination,resultPlanet);
        Assert.assertArrayEquals(destination.getShopEntries().toArray(), resultShopEntry.toArray());
       // System.out.print("再见😡");
    }





}
