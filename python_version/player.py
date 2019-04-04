from ship import *
class Player:
    def __init__(self, name, pilot, fighter, trader, engineer):
        self.name = name
        self.pilot = pilot
        self.fighter = fighter
        self.trader = trader
        self.engineer = engineer
        self.credits = 1000
        self.ship = Ship(Gnat())
        self.cargo = {}
        self.usedspace = 0
    def __str__(self):
        return str(self.name)
    def setShip(self, p):
        self.ship=p
    def getShip(self):
        return self.ship
    def getCredits(self):
        return self.credits
    def setCredits(self,c):
        self.credits = c
    def getCargo(self):
        return self.cargo
    def addCargo(self, item, numeral):
        if item not in self.cargo:
            self.cargo[item] = numeral
        else:
            self.cargo[item] += numeral
        self.usedspace += numeral
    def getUsedSpace(self):
        return self.usedspace
    def addFuel(self,amount):
        self.ship.addFuel(amount)