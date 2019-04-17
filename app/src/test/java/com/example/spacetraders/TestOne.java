package com.example.spacetraders;
import com.example.spacetraders.entities.Game;
import com.example.spacetraders.entities.GameDifficulty;
import com.example.spacetraders.entities.Planet;
import com.example.spacetraders.entities.Player;
import com.example.spacetraders.entities.PoliticalSystem;
import com.example.spacetraders.entities.ResourcesLevel;
import com.example.spacetraders.entities.Ship;
import com.example.spacetraders.entities.ShopEntry;
import com.example.spacetraders.entities.SolarSystem;
import com.example.spacetraders.entities.Star;
import com.example.spacetraders.entities.TechLevel;
import com.example.spacetraders.entities.Universe;

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
    private Player player;
    private int len;
    private Planet destination;
    private Game game;
    private Ship originShip;
    private Player originPlayer ;
    private SolarSystem originalSystem ;
    private Star originStar ;
    private boolean originIsWarpgate;
    private List<ShopEntry> originShopEntryFiltered;
    private int originCargoSpace;
    private int originCredit;
    private int originFuel;
    private SolarSystem[] originSystemList;
    private Universe originUniverse;
    private List<ShopEntry> originPlayerEntry;
    private int originRange;
    private double originMaxRange;
    private TechLevel originTechLevel;
    private ResourcesLevel originResourceLevel;
    private PoliticalSystem originPoliteSystem;
    private int originColor;
    private char originClassification;
    private int originX;
    private int originY;
    private GameDifficulty originDifficulty;
    private String originShipTypeString;
    private int originNumShields;
    private int originNumCrews;
    private int originShipCost;








    @Before
    public void setUp(){
        player = new Player("test",3,4,4,5);
        game = new Game(GameDifficulty.BEGINNER, player);
        currentSolaySystem = game.getCurrentSystem() ;
        planets = currentSolaySystem.getPlanets();
        len = planets.length;
        while (len <= 4) {
            game = new Game(GameDifficulty.BEGINNER, player);
            currentSolaySystem = game.getCurrentSystem();
            planets = currentSolaySystem.getPlanets();
            len = planets.length;
        }
        originPlanet = planets[len - 2];
        game.setCurrPlanet(originPlanet);
        originShopEntry = game.getShopEntries();
        originShip = game.getPlayer().getShip();
        originPlayer = game.getPlayer();
        originalSystem = game.getCurrentSystem();
        originStar = originPlanet.getParentStar();
        originIsWarpgate = originPlanet.getIsWarpGate();
        originShopEntryFiltered = originPlanet.getShopEntriesFiltered();
        originCargoSpace = game.getCargoSpace();
        originCredit = game.getCredits();
        originFuel = game.getFuelPercentage();
        originUniverse = game.getUniverse();
        originSystemList = game.getUniverse().getSolarSystems();
        originPlayerEntry = game.getPlayerEntries();
        originMaxRange = game.getMaxRange();
        originRange = game.getRange();
        originTechLevel = originPlanet.getTechLevel();
        originResourceLevel = originPlanet.getResourcesLevel();
        originPoliteSystem = originPlanet.getPoliticalSystem();
        originClassification = originStar.getClassification();
        originColor = originStar.getColor();
        originX = originalSystem.getCoordinates().getX();
        originY = originalSystem.getCoordinates().getY();
        originDifficulty = game.getGameDifficulty();
        originShipTypeString = originShip.getShipType().toString();
        originNumCrews = originShip.getShipType().getNumCrew();
        originNumShields = originShip.getShipType().getNumShields();
        originShipCost = originShip.getShipType().getCost();





    }

    @Test(timeout = TIMEOUT)
    public void planetNULL(){


        result = game.travelToPlanet(null);
        resultPlanet = game.getCurrentPlanet();
        resultShopEntry = game.getShopEntries();
        Assert.assertSame(0, result);
        Assert.assertSame(originPlanet, resultPlanet);


        Assert.assertEquals(originShip,player.getShip());
        Assert.assertSame(originPlayer, game.getPlayer());
        Assert.assertSame(originalSystem, game.getCurrentSystem());
        Assert.assertArrayEquals(originShopEntry.toArray(), resultShopEntry.toArray());
        Assert.assertSame(originStar,resultPlanet.getParentStar());
        Assert.assertSame(originIsWarpgate, resultPlanet.getIsWarpGate());
        Assert.assertArrayEquals(originShopEntryFiltered.toArray(), resultPlanet.getShopEntriesFiltered().toArray());
        Assert.assertEquals(originCargoSpace,game.getCargoSpace());
        Assert.assertEquals(originCredit, game.getCredits());
        Assert.assertEquals(originFuel,game.getFuelPercentage());
        Assert.assertSame(originUniverse, game.getUniverse());
        Assert.assertArrayEquals(originSystemList, game.getUniverse().getSolarSystems());
        Assert.assertArrayEquals(originPlayerEntry.toArray(), game.getPlayerEntries().toArray());
        Assert.assertEquals(originRange,game.getRange());
        Assert.assertTrue(originMaxRange - game.getMaxRange() == 0);
        Assert.assertEquals(originTechLevel, resultPlanet.getTechLevel());
        Assert.assertEquals(originResourceLevel, resultPlanet.getResourcesLevel());
        Assert.assertEquals(originPoliteSystem, resultPlanet.getPoliticalSystem());
        Assert.assertEquals(originClassification, resultPlanet.getParentStar().getClassification());
        Assert.assertEquals(originColor, resultPlanet.getParentStar().getColor());
        Assert.assertEquals(originX, game.getCurrentSystem().getCoordinates().getX());
        Assert.assertEquals(originY, game.getCurrentSystem().getCoordinates().getY());
        Assert.assertEquals(originShipTypeString, game.getPlayer().getShip().getShipType().toString());
        Assert.assertEquals(originNumCrews,game.getPlayer().getShip().getShipType().getNumCrew());
        Assert.assertEquals(originNumShields,game.getPlayer().getShip().getShipType().getNumShields());
        Assert.assertEquals(originShipCost,game.getPlayer().getShip().getShipType().getCost());
        Assert.assertEquals(originDifficulty, game.getGameDifficulty());





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



        Assert.assertEquals(originShip,player.getShip());
        Assert.assertSame(originPlayer, game.getPlayer());
        Assert.assertSame(originalSystem, game.getCurrentSystem());
        Assert.assertFalse(Arrays.equals(originShopEntry.toArray(), resultShopEntry.toArray()));
        Assert.assertEquals(originCargoSpace,game.getCargoSpace());
        Assert.assertEquals(originCredit, game.getCredits());
        Assert.assertEquals(originFuel,game.getFuelPercentage());
        Assert.assertSame(originUniverse, game.getUniverse());
        Assert.assertSame(originUniverse, game.getUniverse());
        Assert.assertArrayEquals(originSystemList, game.getUniverse().getSolarSystems());
        Assert.assertArrayEquals(originPlayerEntry.toArray(), game.getPlayerEntries().toArray());
        Assert.assertEquals(originRange,game.getRange());
        Assert.assertTrue(originMaxRange - game.getMaxRange() == 0);
        Assert.assertEquals(originShipTypeString, game.getPlayer().getShip().getShipType().toString());
        Assert.assertEquals(originNumCrews,game.getPlayer().getShip().getShipType().getNumCrew());
        Assert.assertEquals(originNumShields,game.getPlayer().getShip().getShipType().getNumShields());
        Assert.assertEquals(originShipCost,game.getPlayer().getShip().getShipType().getCost());
        Assert.assertEquals(originDifficulty, game.getGameDifficulty());





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
        Assert.assertEquals(originShip,player.getShip());
        Assert.assertSame(originPlayer, game.getPlayer());
        Assert.assertSame(originalSystem, game.getCurrentSystem());
        Assert.assertEquals(originShip,player.getShip());
        Assert.assertSame(originPlayer, game.getPlayer());
        Assert.assertSame(originalSystem, game.getCurrentSystem());
        Assert.assertSame(originStar,resultPlanet.getParentStar());
        Assert.assertSame(originIsWarpgate, resultPlanet.getIsWarpGate());
        Assert.assertEquals(originCargoSpace,game.getCargoSpace());
        Assert.assertEquals(originCredit, game.getCredits());
        Assert.assertEquals(originFuel,game.getFuelPercentage());
        Assert.assertSame(originUniverse, game.getUniverse());
        Assert.assertSame(originUniverse, game.getUniverse());
        Assert.assertArrayEquals(originSystemList, game.getUniverse().getSolarSystems());
        Assert.assertArrayEquals(originPlayerEntry.toArray(), game.getPlayerEntries().toArray());
        Assert.assertEquals(originRange,game.getRange());
        Assert.assertTrue(originMaxRange - game.getMaxRange() == 0);
        Assert.assertEquals(originTechLevel, resultPlanet.getTechLevel());
        Assert.assertEquals(originResourceLevel, resultPlanet.getResourcesLevel());
        Assert.assertEquals(originPoliteSystem, resultPlanet.getPoliticalSystem());
        Assert.assertEquals(originClassification, resultPlanet.getParentStar().getClassification());
        Assert.assertEquals(originColor, resultPlanet.getParentStar().getColor());
        Assert.assertEquals(originX, game.getCurrentSystem().getCoordinates().getX());
        Assert.assertEquals(originY, game.getCurrentSystem().getCoordinates().getY());
        Assert.assertEquals(originShipTypeString, game.getPlayer().getShip().getShipType().toString());
        Assert.assertEquals(originNumCrews,game.getPlayer().getShip().getShipType().getNumCrew());
        Assert.assertEquals(originNumShields,game.getPlayer().getShip().getShipType().getNumShields());
        Assert.assertEquals(originShipCost,game.getPlayer().getShip().getShipType().getCost());
        Assert.assertEquals(originDifficulty, game.getGameDifficulty());


        // System.out.print("再见😡");
    }





}
