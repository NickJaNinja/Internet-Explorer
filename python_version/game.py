from player import *
from universe import *
from shopGoods import *
from random import *
class Game:
    def __init__(self):
        self.player = None
        self.diff = None
        self.universe = Universe()
        self.currSystem = None#self.universe.getRandomSystem()
        self.currShop = None#self.currSystem.getShop()
    def setPlayer(self, p):
        self.player=p
    def getPlayer(self):
        return self.player
    def setDiff(self, d):
        self.diff=d
    def getDiff(self):
        return self.diff
    def setUniverse(self, p):
        self.universe=p
    def getUniverse(self):
        return self.universe
    def getCurrentSystem(self):
        return self.currSystem
    def setCurrentSystem(self,s):
        r=random()
        self.currSystem = s
        self.currShop = s.getShop()
        self.currShop.refresh()
        if r<0.5:
            c=choice(RadicalPriceEvent)
            self.currShop.setIE(c)
    def getCurrentShop(self):
        return self.currShop
    def setCurrentShop(self,s):
        self.shop = s
    def init(self):
        self.currSystem = self.universe.getRandomSystem()
        self.currShop = self.currSystem.getShop()
    def __str__(self):
        return self.player.name
    
