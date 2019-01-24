package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Pokemons {
    private ArrayList<Pokemon> pokemons;

    public Pokemons(){
        this.pokemons = new ArrayList<>();
    }

    private ArrayList pokemonMoves(Name name){
        ArrayList<Move> moves = new ArrayList<>();
        switch (name){
            case BULBASAUR: moves.add(Move.TACKLE); moves.add(Move.RAZORLEAF); moves.add(Move.TAKEDOWN); moves.add(Move.VINEWHIP); break;
            case CHARMANDER: moves.add(Move.SCRATCH); moves.add(Move.EMBER); moves.add(Move.SLASH); moves.add(Move.FIRESPIN); break;
            case SQUIRTLE: moves.add(Move.TACKLE); moves.add(Move.BUBBLE); moves.add(Move.HEADBUTT); moves.add(Move.WATERGUN); break;
        }
        return moves;
    }
    public void createPokemons(){
            this.pokemons.add(new Pokemon(Name.BULBASAUR, Type.GRASS, pokemonMoves(Name.BULBASAUR)));
            this.pokemons.add(new Pokemon(Name.CHARMANDER, Type.FIRE, pokemonMoves(Name.CHARMANDER)));
            this.pokemons.add(new Pokemon(Name.SQUIRTLE, Type.WATER, pokemonMoves(Name.SQUIRTLE)));
            this.pokemons.add(new Pokemon(Name.PIKACHU, Type.ELECTRIC, pokemonMoves(Name.PIKACHU)));
            this.pokemons.add(new Pokemon(Name.CATERPIE, Type.BUG, pokemonMoves(Name.CATERPIE)));
            this.pokemons.add(new Pokemon(Name.WEEDLE, Type.BUG, pokemonMoves(Name.WEEDLE)));
            this.pokemons.add(new Pokemon(Name.PIDGEY, Type.FLYING, pokemonMoves(Name.PIDGEY)));
            this.pokemons.add(new Pokemon(Name.RATTATA, Type.NORMAL, pokemonMoves(Name.RATTATA)));
            this.pokemons.add(new Pokemon(Name.SPEAROW, Type.FLYING, pokemonMoves(Name.SPEAROW)));
            this.pokemons.add(new Pokemon(Name.EKANS, Type.POISON, pokemonMoves(Name.EKANS)));
            this.pokemons.add(new Pokemon(Name.SANDSHREW, Type.GROUND, pokemonMoves(Name.SANDSHREW)));
            this.pokemons.add(new Pokemon(Name.VULPIX, Type.FIRE, pokemonMoves(Name.VULPIX)));
            this.pokemons.add(new Pokemon(Name.GEODUDE, Type.ROCK, pokemonMoves(Name.GEODUDE)));
            this.pokemons.add(new Pokemon(Name.ODDISH, Type.GRASS, pokemonMoves(Name.ODDISH)));
            this.pokemons.add(new Pokemon(Name.PARAS, Type.BUG, pokemonMoves(Name.PARAS)));
            this.pokemons.add(new Pokemon(Name.DIGLETT, Type.GROUND, pokemonMoves(Name.DIGLETT)));
    }

    public Pokemon createStarterPokemon(Name name){
        Pokemon pokemon = new Pokemon(null, null, null);
        switch (name){
            case BULBASAUR: pokemon = new Pokemon(Name.BULBASAUR, Type.GRASS, pokemonMoves(Name.BULBASAUR)); break;
            case CHARMANDER: pokemon = new Pokemon(Name.CHARMANDER, Type.FIRE, pokemonMoves(Name.CHARMANDER)); break;
            case SQUIRTLE: pokemon = new Pokemon(Name.SQUIRTLE, Type.WATER, pokemonMoves(Name.SQUIRTLE)); break;
        }
        return pokemon;
    }

    public Pokemon getRandomPokemon(){
        Random random = new Random();
        int index = random.nextInt(this.pokemons.size());
        return this.pokemons.get(index);
    }

    public String toString(){
        String pokemonOutput = "";
        for(Pokemon aPokemon : this.pokemons){
            pokemonOutput += "\n" + aPokemon.toString();
        }
        return pokemonOutput;
    }

    public String getStarterChoices(){
        String starterChoices = "";
        for(int i = 0; i < 3; i++){
            starterChoices += "\n" + (i+1) + ". " + pokemons.get(i);
        }
        return starterChoices;
    }
}
