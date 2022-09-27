package ru.netology;

import java.util.function.*;

public class FixedCalculator {
    public static Supplier<FixedCalculator> instance = FixedCalculator::new;
    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    BinaryOperator<Integer> divide = (x, y) -> {
        if(y != 0){
            return x / y;
        }
        else{
            throw new ArithmeticException("Деление на ноль запрещено");
        }
    };
    UnaryOperator<Integer> pow = (x) -> x * x;
    UnaryOperator<Integer> abs = (x) -> x > 0 ? x : x * (-1);
    Predicate<Integer> isPositive = (x) -> x > 0;
    Consumer<Integer> print = System.out::println;
}
