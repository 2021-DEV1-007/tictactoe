package com.kata.tictactoe.utils;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ScannerUtil {

    private Scanner scanner;

    public ScannerUtil(){
        this.scanner = new Scanner(System.in);
    }

    public String getInputFromUser(){
        return scanner.nextLine();
    }

    public void sayToPlayer(String text){
        System.out.println(text);
    }
}
