package com.example.spacetraders;

import com.example.spacetraders.entities.Ship;
import com.example.spacetraders.entities.ShipType;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * unit test on refuel
 */
public class RefuelTest {

    Ship ship;
    private static final int TIMEOUT = 200;

    /**
     * create a instance of ship with 1/3 fuel
     */
    @Before
    public void setup(){
        ship = new Ship(ShipType.GNAT);
        ship.travel(50);
    }


    /**
     * test conditions of refuel1
     */
    @Test (timeout = TIMEOUT)
    public void testRefuel() {

        //max range now is 20. fuel left is 28% of full. parameter money = 0 does not change the amount of fuel left.
        // condition this.fuel < type.getFuel() is checked
        ship.refuel(0);
        assertEquals("refuel with 0 money is incorrect", 28, ship.getFuelPercentage(), 0.0000000000001);

        //max range now is 20. fuel left is 28% of full. parameter money = 10 should increase fuel left by 14%.
        // condition this.fuel < type.getFuel() is checked
        ship.refuel(10);
        assertEquals("refuel with 10 money is incorrect", 42, ship.getFuelPercentage(), 0.0000000000001);

        //max range now is 30. fuel left is 42% of full. parameter money = 10 should increase fuel left by 58%.
        // condition this.fuel = type.getFuel() is checked
        ship.refuel(40);
        assertEquals("refuel with 40 money is incorrect", 100, ship.getFuelPercentage(), 0.0000000000001);

        //max range now is 70. fuel left is 100% of full. parameter money = 1000 should increase fuel left by 1400%.
        // condition this.fuel > type.getFuel() is checked. So this.fuel = type.getFuel();
        ship.refuel(1000);
        assertEquals("refuel with 10 money is incorrect", 100, ship.getFuelPercentage(), 0.0000000000001);
    }
}