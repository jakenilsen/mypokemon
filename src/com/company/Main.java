package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Hello there! Welcome to the world of POKEMON! My name is OAK! People call me the " +
                        "POKEMON PROF! This world is inhabited by creatures called POKEMON! \nFor some people, " +
                        "POKEMON are pets. Others use them for fights. Myself...I study POKEMON as a profession.");
        System.out.println("Press Enter to continue.......");
        try{System.in.read();}
        catch(Exception e){}
        Character character = new Character();
        character.createCharacter();
        System.out.println("Your very own POKEMON legend is about to unfold " + character.getName() +
                "! A world of dreams and adventures with POKEMON awaits! Let's go!.......");
        try{System.in.read();}
        catch(Exception e){}

        Pokemons pokemons = new Pokemons();
        pokemons.createPokemons();

        System.out.println("\nThere are 3 Pokémon's here! They are inside the Poké balls. " +
                "When I was young, I was a serious Pokémon trainer. In my old age, I have only 3 left, but you can have one!.......");
        try{System.in.read();}
        catch(Exception e){}
        character.choosePokemon(pokemons);
        System.out.println("Welcome to the Kanto area! You are now free to do what you want! " +
                "\nYou will challenge your first gym once your Pokémon reach level 10!");
        boolean finished = false;
        while(!finished){
            Pokemon pokemon = character.getPokemon();
            System.out.println("\nWhat do you want to do?");
            System.out.println("\n1. Fight wild pokemon" +
                    "\n2. Check your information" +
                    "\n3. Exit game");
            while (true) {
                while (!userInput.hasNextInt()) {
                    userInput.next();
                }
                int response = userInput.nextInt();
                if (response == 1) {
                    Pokemon wildPokemon = pokemons.getRandomPokemon();
                    wildPokemon.setLevel(pokemon.getLevel());
                    System.out.println("\n---------------------Battle screen---------------------");
                    System.out.println("\nYou encountered " + wildPokemon.getName() + " level " + wildPokemon.getLevel() +"!");
                    boolean finishedBattle = false;
                    while(!finishedBattle){
                        System.out.println("\nWhat do you want to do?");
                        System.out.println("\n1. Battle!" +
                                "\n2. Check your information" +
                                "\n3. Run away!");
                        while(true) {
                            while (!userInput.hasNextInt()) {
                                userInput.next();
                            }
                            int battleResponse = userInput.nextInt();
                            if (battleResponse == 1) {
                                boolean gameOver = false;
                                double wildPokemonHp = wildPokemon.getHp();
                                double playerPokemonHp = pokemon.getHp();
                                while (!gameOver) {
                                    if(wildPokemonHp <= 0 && !gameOver){
                                        System.out.println("\nThe wild Pokémon " + wildPokemon.getName() + " has fainted");

                                        //level up
                                        pokemon.addLevel();
                                        System.out.println("\n" + pokemon.getName() + " gained a level! It is now level "
                                        + pokemon.getLevel() + "!");

                                        //add win
                                        character.addWin();
                                        gameOver = true;
                                        finishedBattle = true;
                                    }
                                    else if(playerPokemonHp <= 0 && !gameOver){
                                        System.out.println("You have been defeated!");
                                        gameOver = true;
                                        finishedBattle = true;
                                    } else {

                                        System.out.println("\nThe wild Pokémon " + wildPokemon.getName() + " has "
                                                + wildPokemonHp + "hp left!\n");
                                        System.out.println("\nChoose your attack!");
                                        System.out.println("\n" + pokemon.getMoves());
                                        Name pokemonName = pokemon.getName();
                                        Move move1 = pokemon.move.get(0);
                                        Move move2 = pokemon.move.get(1);
                                        Move move3 = pokemon.move.get(2);
                                        Move move4 = pokemon.move.get(3);


                                        while (true) {
                                            while (!userInput.hasNextInt()) {
                                                userInput.next();
                                            }
                                            int attackResponse = userInput.nextInt();
                                            if (attackResponse == 1) {
                                                System.out.println(pokemonName + " used "
                                                        + move1 + "!");
                                                wildPokemonHp -= pokemon.getDamage(move1);
                                                break;
                                            } else if (attackResponse == 2) {
                                                System.out.println(pokemonName + " used "
                                                        + move2 + "!");
                                                wildPokemonHp -= pokemon.getDamage(move2);
                                                break;
                                            } else if (attackResponse == 3) {
                                                System.out.println(pokemonName + " used "
                                                        + move3 + "!");
                                                wildPokemonHp -= pokemon.getDamage(move3);
                                                break;
                                            } else if (attackResponse == 4) {
                                                System.out.println(pokemonName + " used "
                                                        + move4 + "!");
                                                wildPokemonHp -= pokemon.getDamage(move4);
                                                break;
                                            } else {
                                                userInput.next();
                                                System.out.println("Incorrect input, try again!");
                                            }
                                        }
                                    }
                                }
                                break;
                            } else if (battleResponse == 2) {
                                System.out.println(character.toString());
                                break;
                            } else if (battleResponse == 3) {
                                System.out.println("Are you sure you want to run away? YES(1)/NO(2)");
                                while (true) {
                                    while (!userInput.hasNextInt()) {
                                        userInput.next();
                                    }
                                    int exitResponse = userInput.nextInt();
                                    if (exitResponse == 1) {
                                        finishedBattle = true;
                                        System.out.println("Got away safely...");
                                        break;
                                    } else if (exitResponse == 2) {
                                        break;
                                    } else {
                                        userInput.next();
                                        System.out.println("Incorrect input, try again!");
                                    }
                                }
                                break;
                            } else {
                                userInput.next();
                                System.out.println("Incorrect input, try again!");
                            }
                        }
                    }
                    break;
                } else if (response == 2) {
                    System.out.println(character.toString());
                    break;
                } else if (response == 3) {
                    System.out.println("Are you sure you want to exit? YES(1)/NO(2)");
                    while (true) {
                        while (!userInput.hasNextInt()) {
                            userInput.next();
                        }
                        int exitResponse = userInput.nextInt();
                        if (exitResponse == 1) {
                            finished = true;
                            break;
                        } else if (exitResponse == 2) {
                            break;
                        } else {
                            userInput.next();
                            System.out.println("Incorrect input, try again!");
                        }
                    }
                    break;
                } else {
                    userInput.next();
                    System.out.println("Incorrect input, try again!");
                }
            }

        }
    }
}
