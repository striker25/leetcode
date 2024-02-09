package com.striker25.oop.javamethodoverriding;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        var soccer = new Soccer();
        var genericSports = new Sports();

        System.out.println(genericSports.getName());
        genericSports.getNumberOfTeamMembers();
        System.out.println(soccer.getName());
        soccer.getNumberOfTeamMembers();
    }

    static class Sports {
        String getName() {
            return "Generic Sports";
        }

        void getNumberOfTeamMembers() {
            System.out.println("Each team has n players in " + getName());
        }
    }

    static class Soccer extends Sports {
        @Override
        String getName() {
            return "Soccer Class";
        }

        @Override
        void getNumberOfTeamMembers() {
            System.out.println("Each team has 11 players in " + getName());
        }
    }
}
