#include <stdio.h>
#include <stdlib.h>
#include "CreatGame.h"
#define BUFF 256

int main() {

    char name[BUFF];
    char integer[BUFF];
    int in;
    int trade;
    int pilot;
    int fighter;
    int engineer;
    int max = 16;
    int i = 0;
    char * difficulty;


    printf("Welcome to Space Trader.\nPlease enter player's name: ");
    fgets(name,BUFF,stdin);


    while (i < 3) {
        printf("Please enter a integer less than %d and bigger than 0: ", max);
        if (fgets(integer, BUFF, stdin) != NULL) {
            if (atoi(integer) <= max && atoi(integer) > 0) {
                max = max - atoi(integer);
                i++;

                if (i == 1) {
                    trade = atoi(integer);
                }
                if (i == 2) {
                    pilot = atoi(integer);
                }
                if (i == 3) {
                    fighter = atoi(integer);
                }
            } else {
                printf("Invalid choice\n.");
            }
        }
    }
       /* scanf("%d", &in);
        if (in <= max) {
            max = max - in;
            i++;

            if (i == 1) {
                trade = in;
            }
            if (i == 2) {
                pilot = in;
            }
            if (i == 3) {
                fighter = in;

            }

        } else {
            printf("Invalid choice\n.");
        }
    }*/
    engineer = max;
    int j = 0;
    while(j < 1) {
        printf("Please select a game difficulty:\n");
        printf("%d. BEGINNER\n%d. SIMPLE\n%d. DIFFICULT\n ", 1,2,3);
        if (fgets(integer, BUFF, stdin) != NULL) {
            if (atoi(integer) <=3) {
                if (atoi(integer) == 1) {
                    difficulty = "BEGINNER";
                } else if(atoi(integer) == 2) {
                    difficulty = "SIMPLE";
                } else {
                    difficulty = "DIFFICULT";
                }
                j++;
            } else {
                printf("Invalid choice.");
            }
        }
    }





    Player *player;
    if((player = (Player *)malloc(sizeof(Player)))!=NULL) {
       player =  createPlayer(name,trade,pilot,fighter,engineer);
    }
    Game *game;
    if((game = (Game *)malloc(sizeof(Game)))!=NULL) {
         game = createGame(difficulty, player);
    }

    printf("Game Difficulty = %s\nplayer:\nname: %s\ntraderSkill:%d\npilotSkill:%d\nfighterSkill:%d\nEngineerSkill:%d\nCredit:%d",difficulty,player->name,player->traderSkill,player->pilotSkill,player->fighterSkill,player->engineerSkill,player->credit);
    return 0;
}