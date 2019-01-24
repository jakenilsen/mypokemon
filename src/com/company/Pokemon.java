package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Pokemon {
    private Name name;
    private Type type;
    public ArrayList<Move> move;
    private int level;
    private double hp;
    private double damage;
    public boolean criticalHit;

    public Pokemon(Name name, Type type, ArrayList<Move> move){
        this.name = name;
        this.type = type;
        this.move = move;
        this.level = 1;
        this.hp = 1;
        this.damage = 1;
        this.criticalHit = false;
    }

    public String toString(){
        return this.name.toString() + " type: " + this.type.toString() + " level: " + this.level + "\nmoves: " + getMoves();
    }

    public Name getName(){
        return this.name;
    }

    public double getHp(){
        switch (level){
            case 1: hp = 40.00; break;
            case 2: hp = 50.00; break;
            case 3: hp = 60.00; break;
            case 4: hp = 70.00; break;
            case 5: hp = 80.00; break;
            case 6: hp = 90.00; break;
            case 7: hp = 100.00; break;
            case 8: hp = 110.00; break;
            case 9: hp = 120.00; break;
            case 10: hp = 130.00; break;
        }
        return hp;
    }

    public void setLevel(int level){
        this.level = level;
    }
    public void addLevel(){
        this.level += 1;
    }

    public int getLevel(){
        double baseDmg = getHp()/5;
        System.out.println(baseDmg);
        System.out.println(Math.random() * baseDmg);
        return this.level;
    }
    public Type getType(){
        return this.type;
    }

    public String getMoves(){
        String moves = "";
        for (int i = 0; i < this.move.size(); i++){
            moves += (i+1) + ". " + this.move.get(i) + " ";
        }
        return moves;
    }

    public double getDamage(Move move){
        damage = 0;
        double randomDmg = Math.random() *  (getHp()/5);
        criticalHit = false;
        if(randomDmg > (getHp()/5)*0.75){
            criticalHit = true;
        }

        switch (move){
            case TACKLE: damage = 10 + randomDmg; break;
            case VINEWHIP: damage = 12 + randomDmg; break;
            case RAZORLEAF: damage = 14 + randomDmg; break;
            case TAKEDOWN: damage = 12 + randomDmg; break;
            case SCRATCH: damage = 10 + randomDmg; break;
            case EMBER: damage = 12 + randomDmg; break;
            case SLASH: damage = 11 + randomDmg; break;
            case FIRESPIN: damage = 14 + randomDmg; break;
            case BUBBLE: damage = 12 + randomDmg; break;
            case WATERGUN: damage = 14 + randomDmg; break;
            case HEADBUTT: damage = 12 + randomDmg; break;
        }
        System.out.println(damage);
        return damage;
    }
}
