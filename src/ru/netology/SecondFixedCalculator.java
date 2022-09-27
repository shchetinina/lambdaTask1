package ru.netology;

import java.util.function.*;

public class SecondFixedCalculator {
    public static Supplier<SecondFixedCalculator> instance = SecondFixedCalculator::new;
    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    BinaryOperator<Integer> divide = (x, y) -> y != 0 ? x / y : 0;
    UnaryOperator<Integer> pow = (x) -> x * x;
    UnaryOperator<Integer> abs = (x) -> x > 0 ? x : x * (-1);
    Predicate<Integer> isPositive = (x) -> x > 0;
    Consumer<Integer> print = System.out::println;
}
