from enum import Enum
RadicalPriceEvent = ["Drought","Cold","Crop Fail","War","Boredom","Plague","Lack of Workers"]

class ShopGoods(Enum):
    WATER=("Water",0,0,2,30,3,4,"Drought",4,3,30,50)
    FURS=("Furs",0,0,0,250,10,10,"Cold",7,8,230, 280)
    FOOD=("Food",1,0,1,100,5,5,"Crop Fail", 5,6,90,160)
    ORE=("Ore",2,2,3,350,20,10,"War",1,2,350,420)
    GAMES=("Games",3,1,6,250,-10,5,"Boredom",11,None,160,270)
    FIREARMS=("Firearms",3,1,5,1250,-75,100,"War",12,None,600,1100)
    MEDICINE=("Medicine",4,1,6,650,-20,10,"Plague",10,None,400,700)
    MACHINES=("Machines",4,3,5,900,-30,5,"Lack of Workers",None,None,600,800)
    NARCOTICS=("Narcotics",5,0,5,3500,-125,150,"Boredom",9,None,2000,3000)
    ROBOTS=("Robots",6,4,7,5000,-150,100,"Lack of Workers",None,None,3500,5000)
