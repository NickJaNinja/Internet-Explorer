//
// Created by yahuanzhu on 2019/4/16.
//

#ifndef UNTITLED1_CREATGAME_H
#define UNTITLED1_CREATGAME_H

#define NUM_PLANETS 10


typedef struct player{char* name; int pilotSkill; int fighterSkill; int traderSkill; int engineerSkill; int credit;} Player;

typedef struct game{char* difficulty; Player *player; SolarSystem systems[NUM_PLANETS];}Game;

typedef struct solarsystem {
    char *name;
    int xcoord;
    int ycoord;
    int techlevel;
} SolarSystem;

Player* createPlayer(const char* name, int traderSkill,int pilotSkill, int fighterSkill, int engineerSkill);

Game* createGame(const char *difficulty, Player *player);






#endif //UNTITLED1_CREATGAME_H
