package ru.netology;

public class Main {

    public static void main(String[] args) {
	    Calculator calculator = Calculator.instance.get();
		FixedCalculator fixedCalculator = FixedCalculator.instance.get();
		SecondFixedCalculator secondFixedCalculator = SecondFixedCalculator.instance.get();
	    int a = calculator.plus.apply(1, 2);
	    int b = calculator.minus.apply(1, 1);
	    int c = calculator.divide.apply(a, b);

	    calculator.print.accept(c);
	    //Ошибка: ArithmeticException - деление на ноль
	    //1.Для отображения понятного исключения можно выбрасывать исключение с текстом, как в FixedCalculator
		//2.Можно использовать тернарный оператор y != 0 ? x/y : 0,
		// но в этом случае нужно определить, что возвращать если y = 0, например, как в SecondFixedCalculator
    }
}
