package org.example;

public class CasualServiceStrategy implements ServiceStrategy {
    @Override
    public void serve() {
        System.out.println("Casual service for fast food.");
    }
}