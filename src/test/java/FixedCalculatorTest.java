import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.FixedCalculator;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class FixedCalculatorTest {
    private FixedCalculator sut;

    @BeforeEach
    public void beforeEach(){
        sut = FixedCalculator.instance.get();
    }

    @ParameterizedTest
    @MethodSource("valuesForPlusTest")
    public void plusTest(int x, int y, int expectedResult){
        //when
        int result = sut.plus.apply(x, y);

        //then
        assertEquals(expectedResult, result);
    }

    @Test
    public void minusTest(){
        //given
        int x = 100;
        int y = 1;

        //when
        int result = sut.minus.apply(x, y);

        //then
        assertEquals(99, result);
    }


    @ParameterizedTest
    @CsvSource({
            "67, true",
            "-1098, false",
            "0, false"
    })
    public void isPositiveTest(int x, boolean expectedResult){
        //when
        boolean result = sut.isPositive.test(x);

        //then
        assertEquals(expectedResult, result);
    }

    @Test
    public void divideTest(){
        //given
        int x = 1;
        int y = 0;

        //then
        assertThrows(ArithmeticException.class, () -> sut.divide.apply(x, y));
    }

    static Stream<Arguments> valuesForPlusTest(){
        return Stream.of(
                Arguments.of(3, 4, 7),
                Arguments.of(100, 25, 125),
                Arguments.of(12, 7, 19),
                Arguments.of(-10, 4, -6),
                Arguments.of(0, 0, 0)
        );
    }

}