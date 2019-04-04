class Gnat:
    def __init__(self):
        self.name = "Gnat 42";
        self.numWeapons = 1;
        self.numShields = 1;
        self.numGadgets = 1;
        self.numCargoHolds = 15;
        self.fuel = 14;
        self.numCrew = 0;
        self.cargo = []
    def getNumCargoHolds(self):
        return self.numCargoHolds

class Ship():
    def __init__(self, typee):
        self.type = typee
        self.fuel = self.type.fuel
    def getNumCargoHolds(self):
        return self.type.getNumCargoHolds()
    def getFuel(self):
        return self.fuel
    def addFuel(self,s):
        self.fuel+=s
        


