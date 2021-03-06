//
// Created by yahuanzhu on 2019/4/16.
//
#include "CreatGame.h"
#include  <stdlib.h>
#include <mem.h>
#include <stdio.h>

Player* createPlayer(char* name, int traderSkill, int pilotSkill, int fighterSkill, int engineerSkill) {
    Player *player;
    char *playerName;

    if((player = (Player *)malloc(sizeof(Player)))==NULL) {
        return NULL;
    }
    if ((playerName =(char*)malloc((strlen(name)+1)))== NULL) {
        return NULL;
    }
    strcpy(playerName,name);
    player->credit = 1000;
    player->pilotSkill = pilotSkill;
    player->engineerSkill = engineerSkill;
    player->fighterSkill = fighterSkill;
    player->traderSkill = traderSkill;
    player->name = name;

    return player;

}
Game* createGame(char* difficulty, Player *player) {
    Game *game;
    char *diff;
    if((game = (Game *)malloc(sizeof(Game)))==NULL) {
        return NULL;
    }
    if ((diff =(char*)malloc((strlen(difficulty)+1)))== NULL) {
        return NULL;
    }
    strcpy(diff,difficulty);
    game->difficulty = diff;
    game->player = player;
        SolarSystem system1 = {"Planet 1", 0,0,2};
        game->solarsystems[0] = system1;
        SolarSystem system2 = {"Planet 2", 2,6,2};
        game->solarsystems[1] = system2;
        SolarSystem system3 = {"Planet 3", 0,84,2};
        game->solarsystems[2] = system3;
        SolarSystem system4 = {"Planet 4", 29,9,2};
        game->solarsystems[3] = system4;
        SolarSystem system5 = {"Planet 5", 421,66,2};
        game->solarsystems[4] = system5;
        SolarSystem system6 = {"Planet 6", 47,11,2};
        game->solarsystems[5] = system6;
        SolarSystem system7 = {"Planet 7", 332,94,2};
        game->solarsystems[6] = system7;
        SolarSystem system8 = {"Planet 8", 2,489,2};
        game->solarsystems[7] = system8;
        SolarSystem system9 = {"Planet 9", 11,56,2};
        game->solarsystems[8] = system9;
        SolarSystem system10 = {"Planet 10", 48,42,2};
        game->solarsystems[9] = system10;

    return game;
}