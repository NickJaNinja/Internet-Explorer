//
// Created by yahuanzhu on 2019/4/16.
//

#ifndef UNTITLED1_CREATGAME_H
#define UNTITLED1_CREATGAME_H


typedef struct player{char* name; int pilotSkill; int fighterSkill; int traderSkill; int engineerSkill; int credit;} Player;

typedef struct game{char* difficulty; Player *player;}Game;

Player* createPlayer(const char* name, int traderSkill,int pilotSkill, int fighterSkill, int engineerSkill);

Game* createGame(const char *difficulty, Player *player);






#endif //UNTITLED1_CREATGAME_H
