package com.example;

import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Field;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DateTest {

    private Date newDate;
    private Date test;

    @Test
    public void emptyConstructorTest() {
        newDate = new Date();
        test = new Date(1900, 01, 01);
        assertEquals(test.getday(), newDate.getday(), "Teste errado no dia");
        assertEquals(test.getmonth(), newDate.getmonth(), "Teste errado no mês");
        assertEquals(test.getyear(), newDate.getyear(), "Teste errado no ano");
    }

    @Test
    public void yearDayInvertedTest() {
        newDate = new Date(2000, 12, 25);
        assertEquals(25, newDate.getday(), "Teste errado no dia");
        assertEquals(12, newDate.getmonth(), "Teste errado no mês");
        assertEquals(2000, newDate.getyear(), "Teste errado no ano");
    }

    @Test
    public void imutabilityDayTest() {
        IllegalAccessException thrown = Assertions.assertThrows(IllegalAccessException.class, () -> {
            Object arquivoFromReflection = null;
            arquivoFromReflection = Class.forName("com.example.Date").getDeclaredConstructor().newInstance();
            arquivoFromReflection.getClass().getDeclaredFields();
            arquivoFromReflection.getClass().getDeclaredConstructor().newInstance();
            Field dayField = arquivoFromReflection.getClass().getDeclaredField("day");
            byte day = 26;
            dayField.setByte(arquivoFromReflection, day);
        });
    }

    @Test
    public void imutabilityMonthTest() {
        IllegalAccessException thrown = Assertions.assertThrows(IllegalAccessException.class, () -> {
            Object arquivoFromReflection = null;
            arquivoFromReflection = Class.forName("com.example.Date").getDeclaredConstructor().newInstance();
            arquivoFromReflection.getClass().getDeclaredFields();
            arquivoFromReflection.getClass().getDeclaredConstructor().newInstance();
            Field monthField = arquivoFromReflection.getClass().getDeclaredField("month");
            byte month = 1;
            monthField.setByte(arquivoFromReflection, month);
        });
    }

    @Test
    public void imutabilityYearTest() {
        IllegalAccessException thrown = Assertions.assertThrows(IllegalAccessException.class, () -> {
            Object arquivoFromReflection = null;
            arquivoFromReflection = Class.forName("com.example.Date").getDeclaredConstructor().newInstance();
            arquivoFromReflection.getClass().getDeclaredFields();
            arquivoFromReflection.getClass().getDeclaredConstructor().newInstance();
            Field yearField = arquivoFromReflection.getClass().getDeclaredField("year");
            int year = 2001;
            yearField.setInt(arquivoFromReflection, year);
        });
    }

    @Test
    public void yearPositionTest() {
        Date d = new Date(13, 7, 2016);
        assertEquals(13, d.getday(), "Teste errado no dia");
        assertEquals(7, d.getmonth(), "Teste errado no mês");
        assertEquals(2016, d.getyear(), "Teste errado no ano");
    }

    @Test
    public void ambiguityTest() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Date d = new Date(1900, 7, 2016);
        });
    }

    @Test
    public void minimalYearTest() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Date d = new Date(16, 7, 1899);
        });
    }

    @Test
    public void minimalYearTest2() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Date d = new Date(1899, 7, 16);
        });
    }

    @Test
    public void invalidMonthTest() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Date d = new Date(2016, 13, 16);
        });
    }

    @Test
    public void invalidDayTest() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Date d = new Date(2016, 12, 32);
        }, "a data está válida");
    }

    @Test
    public void negativeDayTest() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Date d = new Date(2016, 12, -1);
        }, "a data está válida");
    }

    @Test
    public void negativeMonthTest() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Date d = new Date(2016, -1, 16);
        }, "a data está válida");
    }

    @Test
    public void invalidFebruaryDayTest() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Date d = new Date(2016, 2, 30);
        }, "a data está válida");
    }

    @Test
    public void toStringTest() {
        Date d8 = new Date(5, 5, 2005);
        assertTrue(d8.toString().equals("05/05/2005"), "erro no Equals");
    }

    @Test
    public void toStringTest2() {
        Date d8 = new Date(1, 10, 2001);
        assertTrue(d8.toString().equals("01/10/2001"), "erro no toString()");
    }

    @Test
    public void comparabilityTest() {
        Date d5 = new Date(1, 7, 2014);
        Date d6 = new Date(1, 7, 2014);
        assertEquals(d5, d6, "problema no equals() 1");
        assertNotEquals(d5, new Date(), "problema no equals() 2");
    }

    @Test
    public void comparabilityTest2() {
        Date d5 = new Date(1, 7, 2014);
        Date d6 = new Date(1, 7, 2014);
        Date d7 = new Date(23, 4, 2016);
        assertFalse(d5.after(d7), "problema no after 1");
        assertTrue(d7.after(d5), "problema no after 2");
        assertTrue(d5.before(d7), "problema no before 3");
        assertFalse(d7.before(d5), "problema no before 4");
        assertFalse(d7.before(d7), "problema no before 5");
        assertFalse(d7.after(d7), "problema no after 6");
    }

    @Test
    public void yesterdayTest() {
        Date d = new Date(2016, 4, 22);
        Date d2 = d.yesterday();
        assertEquals(d2.day, 21, "Teste errado no dia do yesterday");
        assertEquals(d2.month, 4, "Teste errado no mês do yesterday");
        assertEquals(d2.year, 2016, "Teste errado no ano do yesterday");
        assertEquals(d.day, 22, "Teste errado no dia do yesterday imutabilidade");
        assertEquals(d.month, 4, "Teste errado no mês do yesterday imutabilidade");
        assertEquals(d.year, 2016, "Teste errado no ano do yesterday imutabilidade");
    }

    @Test
    public void tomorrowTest() {
        Date d = new Date(2016, 4, 22);
        Date d2 = d.tomorrow();
        assertEquals(d2.day, 23, "Teste errado no dia do tomorrow");
        assertEquals(d2.month, 4, "Teste errado no mês do tomorrow");
        assertEquals(d2.year, 2016, "Teste errado no ano do tomorrow");
    }

    @Test
    public void plusDaysTest() {
        Date d2 = new Date("23/04/2016");
        Date d3 = d2.plusDays(10);
        assertEquals(d3.day, 3, "Teste errado no dia do plusDays()");
        assertEquals(d3.month, 5, "Teste errado no mês do plusDays()");
        assertEquals(d3.year, 2016, "Teste errado no ano do plusDays()");
    }

    @Test
    public void minusDaysTest() {
        Date d3 = new Date("03/05/2016");
        Date d4 = d3.minusDays(10);
        assertEquals(d4.day, 23, "Teste errado no dia do minusDays()");
        assertEquals(d4.month, 4, "Teste errado no mês do minusDays()");
        assertEquals(d4.year, 2016, "Teste errado no ano do minusDays()");
    }

    @Test
    public void complexSituations() {
        Date q = new Date(20, 2, 2016);
        q = q.plusDays(9);
        assertTrue(q.toString().equals("29/02/2016"), "erro no teste de situação complexa 1");
        for (int i = 0; i < 400; i++)
            q = q.tomorrow();
        assertTrue(q.toString().equals("04/04/2017"), "erro no teste de situação complexa 2");
        q = q.plusDays(365);
        assertTrue(q.toString().equals("04/04/2018"), "erro no teste de situação complexa 3");
    }

    @Test
    public void minusDaysHeavy() {
        Date q = new Date("20/02/2016");
        Date d = q.minusDays(99);
        assertEquals(13, d.getday(), "Teste errado no dia com minusDays grande");
        assertEquals(11, d.getmonth(), "Teste errado no mês com minusDays grande");
        assertEquals(2015, d.getyear(), "Teste errado no ano com minusDays grande");

    }

}
