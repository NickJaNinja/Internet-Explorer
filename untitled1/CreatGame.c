//
// Created by yahuanzhu on 2019/4/16.
//
#include "CreatGame.h"
#include  <stdlib.h>
#include <mem.h>
#include <stdio.h>

Player* createPlayer(const char* name, int pilotSkill, int fighterSkill, int traderSkill, int engineerSkill) {
    Player *player;

    if((player = (Player *)malloc(sizeof(Player)))==NULL) {
        return NULL;
    }
    player->credit = 1000;
    player->pilotSkill = pilotSkill;
    player->engineerSkill = engineerSkill;
    player->fighterSkill = fighterSkill;
    player->traderSkill = traderSkill;

    strcpy(player->name,name);

    return player;

}
Game* createGame(const char* difficulty, Player *player) {
    Game *game;
    if((game = (Game *)malloc(sizeof(Game)))!=NULL) {
        strcpy(game->difficulty, difficulty);
        game->player = player;
    }
    return game;

}