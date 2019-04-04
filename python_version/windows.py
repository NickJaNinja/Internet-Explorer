from tkinter import *
from tkinter import messagebox
from tkinter.scrolledtext import *
from player import *
from ship import *
from model import *
from universe import *
import pickle

SCREEN_X = 500
SCREEN_Y = 300
SCREEN_SIZE = str(SCREEN_X) + "x" + str(SCREEN_Y)
FONT = "Menlo"

class MainScreen():
    def __init__(self):
        self.mainScreen = Tk()
        self.mainScreen.title("Space Trader")
        self.mainScreen.geometry(SCREEN_SIZE)
        self.ms_l1 = Label(self.mainScreen, text="S P A C E  T R A D E R", font=(FONT, 24))
        self.ms_l1.place(x=SCREEN_X/2,y=75,anchor="center")
        self.ms_b1 = Button(self.mainScreen, text="> New Game", command=self.makeNewGame)
        self.ms_b1.place(x=SCREEN_X/2,y=170,anchor="center");
        self.ms_b2 = Button(self.mainScreen, text="> Load Game", command=self.loadGame)
        self.ms_b2.place(x=SCREEN_X/2,y=200,anchor="center");
        self.mainScreen.mainloop()
    def makeNewGame(self):
        self.quit()
        CreateCharacterScreen()
    def loadGame(self):
        try:
            with open('savefile.txt', 'rb') as handle:
                global gameFile
                gameFile = pickle.load(handle)
            print(gameFile)
            self.quit()
            SolarSystemScreen()
        except:
            messagebox.showinfo("Bruh","You don't have a game saved")
        
    def quit(self):
        self.mainScreen.destroy()

class CreateCharacterScreen:
    def __init__(self):
        self.createCharacterScreen = Tk()
        self.createCharacterScreen.title("Space Trader")
        self.createCharacterScreen.geometry(SCREEN_SIZE)
        self.ms_l1 = Label(self.createCharacterScreen, text="Create New Character", font=(FONT, 16))
        self.ms_l1.place(x=SCREEN_X/2,y=20,anchor="center")

        self.ccs_nameLabel = Label(self.createCharacterScreen, text="Name", font=(FONT, 12))
        self.ccs_nameLabel.place(x=0,y=60)
        self.ccs_nameEntry = Entry(self.createCharacterScreen,width=20)
        self.ccs_nameEntry.place(x=100, y=60)
        self.ccs_nameEntry.focus()

        self.ccs_pilotLabel = Label(self.createCharacterScreen, text="Pilot", font=(FONT, 12))
        self.ccs_pilotLabel.place(x=0,y=90)
        self.ccs_pilotLabel = Entry(self.createCharacterScreen,width=3)
        self.ccs_pilotLabel.place(x=100, y=90)

        self.ccs_fighterLabel = Label(self.createCharacterScreen, text="Fighter", font=(FONT, 12))
        self.ccs_fighterLabel.place(x=0,y=120)
        self.ccs_fighterLabel = Entry(self.createCharacterScreen,width=3)
        self.ccs_fighterLabel.place(x=100, y=120)

        self.ccs_traderLabel = Label(self.createCharacterScreen, text="Trader", font=(FONT, 12))
        self.ccs_traderLabel.place(x=0,y=150)
        self.ccs_traderLabel = Entry(self.createCharacterScreen,width=3)
        self.ccs_traderLabel.place(x=100, y=150)

        self.ccs_engineerLabel = Label(self.createCharacterScreen, text="Engineer", font=(FONT, 12))
        self.ccs_engineerLabel.place(x=0,y=180)
        self.ccs_engineerLabel = Entry(self.createCharacterScreen,width=3)
        self.ccs_engineerLabel.place(x=100, y=180)

        self.ccs_spinLabel = Label(self.createCharacterScreen, text="Level", font=(FONT, 12))
        self.ccs_spinLabel.place(x=0,y=210)

        self.ccs_spin = Spinbox(self.createCharacterScreen, values=("Beginner", "Easy", "Normal", "Hard", "Impossible"))
        self.ccs_spin.pack()
        self.ccs_spin.place(x=100, y=210)

        self.ccs_confirm = Button(self.createCharacterScreen, text="> Confirm", command=self.onClick)
        self.ccs_confirm.place(x=100,y=250)
        
        self.createCharacterScreen.mainloop()

    def onClick(self):
        name = self.ccs_nameEntry.get()
        pilot = self.ccs_pilotLabel.get()
        fighter = self.ccs_fighterLabel.get()
        trader = self.ccs_traderLabel.get()
        engineer = self.ccs_engineerLabel.get()
        if len(name) == 0 or len(pilot)==0 or len(fighter)==0 or len(trader)==0 or len(engineer)==0:
            messagebox.showinfo("Bruh","Please fill everything out")
        else:
            pilot = int(self.ccs_pilotLabel.get())
            fighter = int(self.ccs_fighterLabel.get())
            trader = int(self.ccs_traderLabel.get())
            engineer = int(self.ccs_engineerLabel.get())
            diff = self.ccs_spin.get()
            if pilot+fighter+trader+engineer != 16:
                messagebox.showinfo("Bruh","Skill points must add to 16")
            else:
                gameFile.setPlayer(Player(name, pilot, fighter, trader, engineer))
                gameFile.setDiff(diff)
                gameFile.init()
                self.quit()
                SolarSystemScreen()

    def quit(self):
        self.createCharacterScreen.destroy()

class SolarSystemScreen:
    def __init__(self):
        self.solarSystemScreen = Tk()
        self.solarSystemScreen.title("Space Trader")
        self.solarSystemScreen.geometry(SCREEN_SIZE)
        sss_l1 = Label(self.solarSystemScreen, text="Current Location: "+str(gameFile.getCurrentSystem().getCoords()), font=(FONT, 12))
        sss_l1.place(x=SCREEN_X/2,y=20,anchor="center")
        sss_l2 = Label(self.solarSystemScreen, text=gameFile.getCurrentSystem().getName(), font=(FONT, 16))
        sss_l2.place(x=SCREEN_X/2,y=50,anchor="center")
        sss_b1 = Button(self.solarSystemScreen, text="> Enter Market", command=self.enterMarket,width = 15, anchor='w')
        sss_b1.place(x=SCREEN_X/2,y=120,anchor="center")
        sss_b2 = Button(self.solarSystemScreen, text="> Warp", command=self.warp,width = 15, anchor='w')
        sss_b2.place(x=SCREEN_X/2,y=150,anchor="center")
        sss_b3 = Button(self.solarSystemScreen, text="> Refuel", command=self.refuel,width = 15, anchor='w')
        sss_b3.place(x=SCREEN_X/2,y=180,anchor="center")
        sss_b4 = Button(self.solarSystemScreen, text="> Save Game", command=self.save,width = 15, anchor='w')
        sss_b4.place(x=SCREEN_X/2,y=210,anchor="center")
        sss_b5 = Button(self.solarSystemScreen, text="> Quit Game", command=self.quit,width = 15, anchor='w')
        sss_b5.place(x=SCREEN_X/2,y=240,anchor="center")
        self.sssCredits = Label(self.solarSystemScreen, text="Credits: "+str(gameFile.getPlayer().getCredits()))
        self.sssCredits.place(x=0,y=140,anchor="w")
        self.sssInv = Label(self.solarSystemScreen, text="Inv Space: "+str(gameFile.getPlayer().getUsedSpace())+"/"+str(gameFile.getPlayer().getShip().getNumCargoHolds()))
        self.sssInv.place(x=0,y=120,anchor="w")
        self.sssFuel = Label(self.solarSystemScreen, text="Fuel: "+str(gameFile.getPlayer().getShip().getFuel()) + "/"+str(gameFile.getPlayer().getShip().type.fuel))
        self.sssFuel.place(x=0,y=100,anchor="w")
        self.sssEvent = Label(self.solarSystemScreen, text="Event: None")
        self.sssEvent.place(x=SCREEN_X,y=100,anchor="e")
        if (gameFile.getCurrentShop().getIE()!= ""):
            self.sssEvent.configure(text="Event: "+str(gameFile.getCurrentShop().getIE()))
        self.solarSystemScreen.mainloop()
    def enterMarket(self):
        self.quit()
        MarketScreen()
    def save(self):
        with open('savefile.txt', 'wb') as handle:
            pickle.dump(gameFile, handle, protocol=pickle.HIGHEST_PROTOCOL)
            print ("save success")
    def warp(self):
        self.quit()
        WarpScreen()
    def refuel(self):
        self.quit()
        RefuelScreen()
    def quit(self):
        self.solarSystemScreen.destroy()

class MarketScreen:
    def __init__(self):
        self.marketScreen = Tk()
        self.marketScreen.title("Space Trader")
        self.marketScreen.geometry(SCREEN_SIZE)
        self.sss_l1 = Label(self.marketScreen, text="Current Location: "+str(gameFile.getCurrentSystem().getCoords()), font=(FONT, 12))
        self.sss_l1.place(x=SCREEN_X/2,y=20,anchor="center")
        self.sss_l2 = Label(self.marketScreen, text=gameFile.getCurrentSystem().getName()+": Market", font=(FONT, 16))
        self.sss_l2.place(x=SCREEN_X/2,y=50,anchor="center")
        self.sss_l3 = Label(self.marketScreen, text="Credits: "+str(gameFile.getPlayer().getCredits()))
        self.sss_l3.place(x=0,y=140,anchor="w")
        self.sss_l4 = Label(self.marketScreen, text="Inv Space: "+str(gameFile.getPlayer().getUsedSpace())+"/"+str(gameFile.getPlayer().getShip().getNumCargoHolds()))
        self.sss_l4.place(x=0,y=120,anchor="w")
        self.sss_l5 = Label(self.marketScreen, text="Fuel: "+str(gameFile.getPlayer().getShip().getFuel()) + "/"+str(gameFile.getPlayer().getShip().type.fuel))
        self.sss_l5.place(x=0,y=100,anchor="w")
        self.sss_b1 = Button(self.marketScreen, text="Confirm Buy", command=self.onConfirmBuy,width = 12)
        self.sss_b1.place(x=0,y=220,anchor="w")
        self.sss_b2 = Button(self.marketScreen, text="Confirm Sell", command=self.onConfirmSell,width = 12)
        self.sss_b2.place(x=0,y=250,anchor="w")
        self.sss_b3 = Button(self.marketScreen, text="< Back", command=self.back,width = 12)
        self.sss_b3.place(x=0,y=280,anchor="w")
        
        self.sss_spin1 = Spinbox(self.marketScreen, from_=0, to=40,width = 12)
        self.sss_spin1.pack()
        self.sss_spin1.place(x=0, y=190,anchor="w")
        self.sss_spin2 = Spinbox(self.marketScreen, values = [x[0] for x in [e.value for e in ShopGoods]],width = 12)
        self.sss_spin2.pack()
        self.sss_spin2.place(x=0, y=160,anchor="w")

        self.sss_store = ScrolledText(self.marketScreen,width=30,height=15)
        self.sss_store.place(x=100,y=90)
        self.sss_inv = ScrolledText(self.marketScreen,width=21,height=15)
        self.sss_inv.place(x=335,y=90)

        self.refresh()

        self.marketScreen.mainloop()
    
    def onConfirmBuy(self):
        shopMap=gameFile.getCurrentShop().getStockMap()
        item = str(self.sss_spin2.get())
        numeral = int(self.sss_spin1.get())
        if shopMap[item][1] < numeral:
            messagebox.showinfo("Bruh","Not enough items in shop")
        elif gameFile.getPlayer().getCredits() < shopMap[item][0]*numeral:
            messagebox.showinfo("Bruh","Not enough money")
        elif gameFile.getPlayer().getShip().getNumCargoHolds() < gameFile.getPlayer().getUsedSpace()+numeral:
            messagebox.showinfo("Bruh","Not enough space")
        else:
            print("success")
            gameFile.getPlayer().setCredits(gameFile.getPlayer().getCredits() - shopMap[item][0]*numeral)
            gameFile.getPlayer().addCargo(item, numeral)
            gameFile.getCurrentShop().removeCargo(item, numeral)
            self.refresh()
    def onConfirmSell(self):
        playerMap=gameFile.getPlayer().getCargo()
        shopMap=gameFile.getCurrentShop().getStockMap()
        item = str(self.sss_spin2.get())
        numeral = int(self.sss_spin1.get())
        if playerMap[item] < numeral:
            messagebox.showinfo("Bruh","Not enough items in inventory")
        else:
            print("success")
            gameFile.getPlayer().setCredits(gameFile.getPlayer().getCredits() + shopMap[item][0]*numeral)
            gameFile.getPlayer().addCargo(item, -numeral)
            gameFile.getCurrentShop().addCargo(item, numeral)
            self.refresh()
    def refresh(self):
        self.sss_l3.configure(text="Credits: "+str(gameFile.getPlayer().getCredits()))
        self.sss_l4.configure(text="Inv Space: "+str(gameFile.getPlayer().getUsedSpace())+"/"+str(gameFile.getPlayer().getShip().getNumCargoHolds()))
        shopMap=gameFile.getCurrentShop().getStockMap()
        invMap = gameFile.getPlayer().getCargo()
        self.sss_store.delete(1.0,END)
        L="ITEM" +"."*11+"PRICE" +"."*4+ "QAN[T]\n"
        for i in shopMap:
            L+=str(i)+"."*(15-len(str(i)))+str(shopMap[i][0])
            L+="."*(9-len(str(shopMap[i][0])))+str(shopMap[i][1])+"\n"
        self.sss_store.insert(INSERT,L)
        self.sss_inv.delete(1.0,END)
        L="ITEM" +"."*11+"QAN[T]\n"
        for i in invMap:
            L+=str(i)+"."*(15-len(str(i)))+str(invMap[i])+"\n"
        self.sss_inv.insert(INSERT,L)
    def back(self):
        self.quit()
        SolarSystemScreen()
    def quit(self):
        self.marketScreen.destroy()

class WarpScreen():
    def __init__(self):
        self.warpscreen = Tk()
        self.warpscreen.title("Space Trader")
        self.warpscreen.geometry(SCREEN_SIZE)
        self.sss_l1 = Label(self.warpscreen, text="Current Location: "+str(gameFile.getCurrentSystem().getCoords()), font=(FONT, 12))
        self.sss_l1.place(x=SCREEN_X/2,y=20,anchor="center")
        self.sss_l2 = Label(self.warpscreen, text=gameFile.getCurrentSystem().getName()+": Warp Gate", font=(FONT, 16))
        self.sss_l2.place(x=SCREEN_X/2,y=50,anchor="center")
        self.sss_l3 = Label(self.warpscreen, text="Credits: "+str(gameFile.getPlayer().getCredits()))
        self.sss_l3.place(x=0,y=140,anchor="w")
        self.sss_l4 = Label(self.warpscreen, text="Inv Space: "+str(gameFile.getPlayer().getUsedSpace())+"/"+str(gameFile.getPlayer().getShip().getNumCargoHolds()))
        self.sss_l4.place(x=0,y=120,anchor="w")
        self.sss_l5 = Label(self.warpscreen, text="Fuel: "+str(gameFile.getPlayer().getShip().getFuel()) + "/"+str(gameFile.getPlayer().getShip().type.fuel))
        self.sss_l5.place(x=0,y=100,anchor="w")
        self.sss_b3 = Button(self.warpscreen, text="< Back", command=self.back,width = 12)
        self.sss_b3.place(x=0,y=280,anchor="w")
        self.sss_b1 = Button(self.warpscreen, text="Confirm Warp", command=self.onWarp,width = 12)
        self.sss_b1.place(x=0,y=250,anchor="w")
        self.sss_l6 = Label(self.warpscreen, text="Systems in Range")
        self.sss_l6.place(x=160,y=80,anchor="w")
        self.sss_store = ScrolledText(self.warpscreen,width=30,height=15)
        self.sss_store.place(x=100,y=90)
        self.sss_l7 = Label(self.warpscreen, text="Enter System\nto Warp To")
        self.sss_l7.place(x=0,y=190,anchor="w")
        self.warpLoc = Entry(self.warpscreen,width=15)
        self.warpLoc.place(x=0, y=220,anchor="w")
        self.validSS=[]
        self.refresh()
        self.warpscreen.mainloop()
    def onWarp(self):
        sysName = str(self.warpLoc.get())
        flag = True
        for s in self.validSS:
            if sysName==s[0].getName():
                flag = False
                gameFile.setCurrentSystem(s[0])
                gameFile.getPlayer().addFuel(-s[1])
                self.quit()
                SolarSystemScreen()
                pass
        if (flag):
            messagebox.showinfo("Bruh","Not a valid Solar System")
        
    def back(self):
        self.quit()
        SolarSystemScreen()
    def refresh(self):
        self.sss_store.delete(1.0,END)
        self.validSS = []
        L="SYSTEM" +"."*14+"FUEL\n"
        for i in gameFile.universe.solarSystems:
            if gameFile.getCurrentSystem().dist(i)/5<gameFile.getPlayer().getShip().getFuel():
                L+=str(i.getName())+"."*(20-len(str(i.getName())))+str(gameFile.getCurrentSystem().dist(i)/5)+"\n"
                self.validSS.append((i,gameFile.getCurrentSystem().dist(i)/5))
        self.sss_store.insert(INSERT,L)
    def quit(self):
        self.warpscreen.destroy()

class RefuelScreen():
    def __init__(self):
        self.refuelscreen = Tk()
        self.refuelscreen.title("Space Trader")
        self.refuelscreen.geometry(SCREEN_SIZE)
        self.sss_l1 = Label(self.refuelscreen, text="Current Location: "+str(gameFile.getCurrentSystem().getCoords()), font=(FONT, 12))
        self.sss_l1.place(x=SCREEN_X/2,y=20,anchor="center")
        self.sss_l2 = Label(self.refuelscreen, text=gameFile.getCurrentSystem().getName()+": Gas Filler Upper Place", font=(FONT, 16))
        self.sss_l2.place(x=SCREEN_X/2,y=50,anchor="center")
        self.sss_l3 = Label(self.refuelscreen, text="Credits: "+str(gameFile.getPlayer().getCredits()))
        self.sss_l3.place(x=0,y=140,anchor="w")
        self.sss_l4 = Label(self.refuelscreen, text="Inv Space: "+str(gameFile.getPlayer().getUsedSpace())+"/"+str(gameFile.getPlayer().getShip().getNumCargoHolds()))
        self.sss_l4.place(x=0,y=120,anchor="w")
        self.sss_l5 = Label(self.refuelscreen, text="Fuel: "+str(gameFile.getPlayer().getShip().getFuel()) + "/"+str(gameFile.getPlayer().getShip().type.fuel))
        self.sss_l5.place(x=0,y=100,anchor="w")
        self.sss_b1 = Button(self.refuelscreen, text="Confirm Buy", command=self.onConfirmBuy,width = 12)
        self.sss_b1.place(x=0,y=220,anchor="w")
        self.sss_b3 = Button(self.refuelscreen, text="< Back", command=self.back,width = 12)
        self.sss_b3.place(x=0,y=280,anchor="w")
        self.sss_spin1 = Spinbox(self.refuelscreen, from_=0, to=50,width = 12)
        self.sss_spin1.pack()
        self.sss_spin1.place(x=0, y=190,anchor="w")
        aaa=Label(self.refuelscreen, text="Fuel Price: 42/unit")
        aaa.place(x=0,y=170,anchor="w")
        self.refresh()
        self.refuelscreen.mainloop()
    def onConfirmBuy(self):
        numeral = int(self.sss_spin1.get())
        if gameFile.getPlayer().getCredits() < 42*numeral:
            messagebox.showinfo("Bruh","Not enough money")
        elif gameFile.getPlayer().getShip().type.fuel < gameFile.getPlayer().getShip().getFuel()+numeral:
            messagebox.showinfo("Bruh","Not enough fuel space")
        else:
            print("success")
            gameFile.getPlayer().setCredits(gameFile.getPlayer().getCredits() - 42*numeral)
            gameFile.getPlayer().getShip().addFuel(numeral)
            self.refresh()
    def refresh(self):
        self.sss_l3.configure(text="Credits: "+str(gameFile.getPlayer().getCredits()))
        self.sss_l4.configure(text="Inv Space: "+str(gameFile.getPlayer().getUsedSpace())+"/"+str(gameFile.getPlayer().getShip().getNumCargoHolds()))
        self.sss_l5.configure(text="Fuel: "+str(gameFile.getPlayer().getShip().getFuel()) + "/"+str(gameFile.getPlayer().getShip().type.fuel))
    def back(self):
        self.quit()
        SolarSystemScreen()
    def quit(self):
        self.refuelscreen.destroy()