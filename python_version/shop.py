from shopGoods import *
from random import *
class Shop:
    def __init__(self, techlevel, rl):
        self.techlevel = techlevel
        self.resourcesLevel = rl
        self.stockMap = {}
        self.refresh()
        self.ie = ""
    def refresh(self):
        self.ie = ""
        self.stockMap = {}
        for good in ShopGoods:
            good = good.value
            price = good[4]+good[5]*(self.techlevel-good[1])
            var = int(randint(-good[6],good[6])/100)
            price+=var
            if good[8]==self.resourcesLevel:
                price *=0.8
            elif good[9]==self.resourcesLevel:
                price /=0.8
            price = int(price)
            if good[7]==self.ie:
                print(good[0])
                price *= 5
            if self.techlevel > good[1]:
                self.stockMap[good[0]]=(price, randint(0,5051-good[4])//125)
            else:
                self.stockMap[good[0]]=(price, 0)
    def __str__(self):
        L = ""
        for i in self.stockMap:
            L+=str(i)+": "+str(self.stockMap[i][0])+","+str(self.stockMap[i][1])+"\n"
        return L
    def getStockMap(self):
        return self.stockMap
    def removeCargo(self, item, numeral):
        self.stockMap[item] =(self.stockMap[item][0],self.stockMap[item][1]-numeral)
    def addCargo(self, item, numeral):
        self.stockMap[item] =(self.stockMap[item][0],self.stockMap[item][1]+numeral)
    def setIE(self,ie):
        self.ie = ie
    def getIE(self):
        return self.ie