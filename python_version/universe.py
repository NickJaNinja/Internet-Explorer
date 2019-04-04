from random import *
from solarSystem import *
class Universe:
    def __init__(self):
        PREFIXES =["Pan","Arc", "Wub","Chung", "Cri", "Zen",  "Da'", "Zur", "Ut", "Chrom","Zig", "Wub", "Car", "Fig","Tap","Sic", "But","Lok", "Ku","Crunk", "Bob", "Myrh","Sen","Deku","Tenzum","Rob","Altair", "Strat","Lik"]
        SUFFIXES =["onia","ardia","anus", "wei", "rom","etov", "der","mus", "ma","ulus", "on","ea", "il", "oc",  "dacia", " Prime", "'Xi", "os","ellia","'kir","adonia","avarius"]
        MAXX = 600
        MAXY = 600
        MAX_SYSTEMS = 250
        self.solarSystems = []
        coordSet = set()
        nameSet = set()
        for _ in range(MAX_SYSTEMS):
            coords = (randint(0, MAXX-1),randint(0, MAXY-1))
            while (coords in coordSet):
                coords = (randint(0, MAXX-1),randint(0, MAXY-1))
            name = choice(PREFIXES) + choice(SUFFIXES)
            while (name in nameSet):
                name = choice(PREFIXES) + choice(SUFFIXES)
            coordSet.add(coords)
            nameSet.add(name)
            self.solarSystems.append(SolarSystem(name, coords))
    def __str__(self):
        return str(self.solarSystems)
    def getRandomSystem(self):
        return choice(self.solarSystems)


