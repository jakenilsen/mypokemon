package com.company;
import java.util.Scanner;

public class Character {
    private String name;
    private String gender;
    private int wins;
    private Pokemon pokemon;
    private Scanner userInput;
    private boolean finished;

    public Character(){
        this.name = "";
        this.gender = "";
        this.wins = 0;
        this.userInput = new Scanner(System.in);
        this.finished = false;
    }



    public void createCharacter(){
        finished = false;
        while(!finished) {
            System.out.println("First, what is your name?");

            while (userInput.hasNextInt()) {
                userInput.next();
                System.out.println("Name cant only be numbers");
            }
            name = userInput.next();

            System.out.println("Are you a Male(1) or a Female(2)?");
            while (true) {
                while (!userInput.hasNextInt()) {
                    userInput.next();
                }
                int response = userInput.nextInt();
                if (response == 1) {
                    gender = "Male";
                    break;
                } else if (response == 2) {
                    gender = "Female";
                    break;
                } else {
                    userInput.next();
                    System.out.println("Incorrect input, try again!");
                }
            }
            System.out.println("Right! So your name is " + name + " and you are a " + gender +
                    ". Is that correct? YES(1)/NO(2)");
            confirmer();
        }
    }

    public void choosePokemon(Pokemons pokemons){
        finished = false;
        while (!finished) {
            System.out.println("Choose your Pokémon!");
            System.out.println(pokemons.getStarterChoices());

            Scanner userInput = new Scanner(System.in);
            while (true) {
                while (!userInput.hasNextInt()) {
                    userInput.next();
                }
                int response = userInput.nextInt();
                if (response == 1) {
                    this.addPokemon(pokemons.createStarterPokemon(Name.BULBASAUR));
                    break;
                } else if (response == 2) {
                    this.addPokemon(pokemons.createStarterPokemon(Name.CHARMANDER));
                    break;
                } else if (response == 3) {
                    this.addPokemon(pokemons.createStarterPokemon(Name.SQUIRTLE));
                    break;
                } else {
                    userInput.next();
                    System.out.println("Incorrect input, try again!");
                }
            }
            System.out.println("Right! So you want " + this.getPokemon().getName() + " as your Pokémon! Is that correct? YES(1)/NO(2)");
            confirmer();
        }
    }

    private void confirmer(){
            while (true) {
                while (!userInput.hasNextInt()) {
                    userInput.next();
                }
                int response = userInput.nextInt();
                if (response == 1) {
                    finished = true;
                    break;
                } else if (response == 2) {
                    break;
                } else {
                    userInput.next();
                    System.out.println("Incorrect input, try again!");
                }
            }
        }

        public String toString(){
        return "Name: " + this.name.toString() + "\nGender: " + this.gender.toString() + "\nWins: " + this.wins
                + "\nPokémon: " + this.pokemon;
        }

    public String getInformation(){
        return "Name: " + this.name.toString() + "\nGender: " + this.gender.toString() + "\nWins: " + this.wins;
    }

    public String getName(){
        return this.name.toString();
    }
    public void addPokemon(Pokemon pokemon){
        this.pokemon = pokemon;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void addWin(){
        this.wins += 1;
    }
}
