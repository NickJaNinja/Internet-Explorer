from shop import *
from random import *
class SolarSystem:
    def __init__(self, name, coords):
        self.name = name
        self.coords = coords
        self.techlevel = randint(0,7)
        self.resourcesLevel = randint(0,12)
        self.shop = Shop(self.techlevel, self.resourcesLevel)
    def getName(self):
        return self.name
    def getCoords(self):
        return self.coords
    def getShop(self):
        return self.shop
    def __str__(self):
        return self.name
    def dist(self, ss):
        return abs(self.coords[0]-ss.getCoords()[0])+abs(self.coords[1]-ss.getCoords()[1])