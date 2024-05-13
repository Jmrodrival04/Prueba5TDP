package org.example;

public class FineDiningServiceStrategy implements ServiceStrategy {
    @Override
    public void serve() {
        System.out.println("Exquisite service with attention to detail.");
    }
}