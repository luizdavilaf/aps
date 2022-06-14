import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class DateTest {

    private Date newDate;
    private Date test;

    @Test
    public void emptyConstructorTest() {
        newDate = new Date();
        test = new Date(1900, 01, 01);
        assertEquals(test.getday(), newDate.getday(), "Tem o mesmo dia esperado");
        assertEquals(test.getmonth(), newDate.getmonth(), "Tem o mesmo mês esperado");
        assertEquals(test.getyear(), newDate.getyear(), "Tem o mesmo ano esperado");
    }

    @Test
    public void yearDayInvertedTest() {
        newDate = new Date(2000, 12, 25);
        assertEquals(25, newDate.getday(), "Tem o mesmo dia esperado");
        assertEquals(12, newDate.getmonth(), "Tem o mesmo mês esperado");
        assertEquals(2000, newDate.getyear(), "Tem o mesmo ano esperado");
    }

    @Test
    public void imutabilityDayTest() {
        IllegalAccessException thrown = Assertions.assertThrows(IllegalAccessException.class, () -> {
            Object arquivoFromReflection = null;
            arquivoFromReflection = Class.forName("Date").getDeclaredConstructor().newInstance();
            arquivoFromReflection.getClass().getDeclaredFields();
            arquivoFromReflection.getClass().getDeclaredConstructor().newInstance();
            Field dayField = arquivoFromReflection.getClass().getDeclaredField("day");
            byte day = 26;
            dayField.setByte(arquivoFromReflection, day);
        });
    }

}
