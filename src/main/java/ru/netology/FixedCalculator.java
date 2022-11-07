package ru.netology;

import java.util.function.*;

public class FixedCalculator {
    public static Supplier<FixedCalculator> instance = FixedCalculator::new;
    public BinaryOperator<Integer> plus = (x, y) -> x + y;
    public BinaryOperator<Integer> minus = (x, y) -> x - y;
    public BinaryOperator<Integer> multiply = (x, y) -> x * y;
    public BinaryOperator<Integer> divide = (x, y) -> {
        if(y != 0){
            return x / y;
        }
        else{
            throw new ArithmeticException("Деление на ноль запрещено");
        }
    };
    public UnaryOperator<Integer> pow = (x) -> x * x;
    public UnaryOperator<Integer> abs = (x) -> x > 0 ? x : x * (-1);
    public Predicate<Integer> isPositive = (x) -> x > 0;
    public Consumer<Integer> print = System.out::println;
}
