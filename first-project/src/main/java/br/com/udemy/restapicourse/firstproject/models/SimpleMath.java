package br.com.udemy.restapicourse.firstproject.models;

public class SimpleMath {
    public double sum(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }
    public double sub(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }
    public double mult(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }
    public double div(double firstNumber, double secondNumber) {
        return firstNumber / secondNumber;
    }
    public double mean(double firstNumber, double secondNumber) {
        return (firstNumber + secondNumber) / 2;
    }
    public double sqrt(double number) {
        return Math.sqrt(number);
    }
}
