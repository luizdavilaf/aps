import org.hamcrest.*;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;

import java.lang.reflect.*;

//import org.junit.jupiter.params.shadow.com.univocity.parsers.common.fields.FieldSet;
import negocio.*;

public class DateTest {

    private Date newDate;

    @Test
    public void emptyConstructorTest() {
        newDate = new Date();
        assertEquals("Teste errado no dia do construtor", 01, newDate.getday());
        assertEquals("Teste errado no mês do construtor", 01, newDate.getmonth());
        assertEquals("Teste errado no ano do construtor", 1900, newDate.getyear());
    }

    @Test
    public void yearDayInvertedTest() {
        newDate = new Date(2000, 12, 25);
        assertEquals("Teste errado no dia do construtor", 25, newDate.getday());
        assertEquals("Teste errado no mês do construtor", 12, newDate.getmonth());
        assertEquals("Teste errado no ano do construtor", 2000, newDate.getyear());
    }

    @Test(expected = IllegalAccessException.class)
    public void imutabilityDayTest()
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            NoSuchMethodException, SecurityException, ClassNotFoundException, NoSuchFieldException {
        Object arquivoFromReflection = null;
        arquivoFromReflection = Class.forName("negocio.Date").getDeclaredConstructor().newInstance();
        arquivoFromReflection.getClass().getDeclaredFields();
        arquivoFromReflection.getClass().getDeclaredConstructor().newInstance();
        Field dayField = arquivoFromReflection.getClass().getDeclaredField("day");
        byte day = 26;
        dayField.setByte(arquivoFromReflection, day);

    }

    @Test(expected = IllegalAccessException.class)
    public void imutabilityMonthTest()
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            NoSuchMethodException, SecurityException, ClassNotFoundException, NoSuchFieldException {
        Object arquivoFromReflection = null;
        arquivoFromReflection = Class.forName("negocio.Date").getDeclaredConstructor().newInstance();
        arquivoFromReflection.getClass().getDeclaredFields();
        arquivoFromReflection.getClass().getDeclaredConstructor().newInstance();
        Field monthField = arquivoFromReflection.getClass().getDeclaredField("month");
        byte month = 1;
        monthField.setByte(arquivoFromReflection, month);

    }

    @Test(expected = IllegalAccessException.class)
    public void imutabilityYearTest()
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            NoSuchMethodException, SecurityException, ClassNotFoundException, NoSuchFieldException {
        Object arquivoFromReflection = null;
        arquivoFromReflection = Class.forName("negocio.Date").getDeclaredConstructor().newInstance();
        arquivoFromReflection.getClass().getDeclaredFields();
        arquivoFromReflection.getClass().getDeclaredConstructor().newInstance();
        Field yearField = arquivoFromReflection.getClass().getDeclaredField("year");
        int year = 2001;
        yearField.setInt(arquivoFromReflection, year);

    }

    @Test
    public void yearPositionTest() {
        Date d = new Date(13, 7, 2016);
        assertEquals("Teste errado no dia no teste de posição", 13, d.getday());
        assertEquals("Teste errado no mês no teste de posição", 7, d.getmonth());
        assertEquals("Teste errado no ano no teste de posição", 2016, d.getyear());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ambiguityTest() {
        Date d = new Date(1900, 7, 2016);
    }

    @Test(expected = IllegalArgumentException.class)
    public void minimalYearTest() {
        Date d = new Date(16, 7, 1899);
    }

    @Test(expected = IllegalArgumentException.class)
    public void minimalYearTest2() {
        Date d = new Date(1899, 7, 16);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidMonthTest() {
        Date d = new Date(2016, 13, 16);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidDayTest() {
        Date d = new Date(2016, 12, 32);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeDayTest() {
        Date d = new Date(2016, 12, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeMonthTest() {
        Date d = new Date(2016, -1, 16);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidFebruaryDayTest() {
        Date d = new Date(2016, 2, 30);
    }

    @Test
    public void toStringTest() {
        Date d8 = new Date(5, 5, 2005);
        assertTrue("erro no Equals", (d8.toString().equals("05/05/2005")));
    }

    @Test
    public void toStringTest2() {
        Date d8 = new Date(1, 10, 2001);
        assertTrue("erro no toString()", d8.toString().equals("01/10/2001"));
    }

    @Test
    public void comparabilityTest() {
        Date d5 = new Date(1, 7, 2014);
        Date d6 = new Date(1, 7, 2014);
        assertEquals("problema no equals() 1", d5, d6);
        assertNotEquals("problema no equals() 2", d5, new Date());
    }

    @Test
    public void comparabilityTest2() {
        Date d5 = new Date(1, 7, 2014);
        Date d6 = new Date(1, 7, 2014);
        Date d7 = new Date(23, 4, 2016);
        assertFalse("problema no after 1", d5.after(d7));
        assertTrue("problema no after 2", d7.after(d5));
        assertTrue("problema no before 3", d5.before(d7));
        assertFalse("problema no before 4", d7.before(d5));
        assertFalse("problema no before 5", d7.before(d7));
        assertFalse("problema no after 6", d7.after(d7));
    }

    @Test
    public void yesterdayTest() {
        Date d = new Date(2016, 4, 22);
        Date d2 = d.yesterday();
        assertEquals("Teste errado no dia do yesterday", d2.day, 21);
        assertEquals("Teste errado no mês do yesterday", d2.month, 4);
        assertEquals("Teste errado no ano do yesterday", d2.year, 2016);
        assertEquals("Teste errado no dia do yesterday imutabilidade", d.day, 22);
        assertEquals("Teste errado no mês do yesterday imutabilidade", d.month, 4);
        assertEquals("Teste errado no ano do yesterday imutabilidade", d.year, 2016);
    }

    @Test
    public void tomorrowTest() {
        Date d = new Date(2016, 4, 22);
        Date d2 = d.tomorrow();
        assertEquals("Teste errado no dia do tomorrow", d2.day, 23);
        assertEquals("Teste errado no mês do tomorrow", d2.month, 4);
        assertEquals("Teste errado no ano do tomorrow", d2.year, 2016);
    }

    @Test
    public void plusDaysTest() {
        Date d2 = new Date("23/04/2016");
        Date d3 = d2.plusDays(10);
        assertEquals("Teste errado no dia do plusDays()", d3.day, 3);
        assertEquals("Teste errado no mês do plusDays()", d3.month, 5);
        assertEquals("Teste errado no ano do plusDays()", d3.year, 2016);
    }

    @Test
    public void minusDaysTest() {
        Date d3 = new Date("03/05/2016");
        Date d4 = d3.minusDays(10);
        assertEquals("Teste errado no dia do minusDays()", d4.day, 23);
        assertEquals("Teste errado no mês do minusDays()", d4.month, 4);
        assertEquals("Teste errado no ano do minusDays()", d4.year, 2016);
    }

    @Test
    public void complexSituations() {
        Date q = new Date(20, 2, 2016);
        q = q.plusDays(9);
        assertTrue("erro no teste de situação complexa 1", q.toString().equals("29/02/2016"));
        for (int i = 0; i < 400; i++)
            q = q.tomorrow();
        assertTrue("erro no teste de situação complexa 2", q.toString().equals("04/04/2017"));
        q = q.plusDays(365);
        assertTrue("erro no teste de situação complexa 3", q.toString().equals("04/04/2018"));
    }

    @Test
    public void minusDaysHeavy() {
        Date q = new Date("20/02/2016");
        Date d = q.minusDays(99);
        assertEquals("Teste errado no dia com minusDays grande",13, d.getday());
        assertEquals("Teste errado no mês com minusDays grande",11, d.getmonth());
        assertEquals("Teste errado no ano com minusDays grande",2015, d.getyear());

    }

}
