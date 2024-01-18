import org.junit.Test;

import static org.junit.Assert.*;

public class SetTest {

    @Test
    public void test_AllMethods_Integers() {
        Set<Integer> set = new Set<>();

        assertEquals("Size of newly declared set should be zero!", 0, set.size());

        set.addItem(-3);
        set.addItem(0);
        set.addItem(4);

        assertFalse("Set size greater than number of added Integers!", set.size() > 3);
        assertTrue("Set does not contain added negative Integer!", set.contains(-3));
        assertTrue("Set does not contain added zero!", set.contains(0));
        assertTrue("Set does not contain added positive Integer!", set.contains(4));

        set.addItem(-3);

        assertEquals("Trying to add duplicate Integers is invalid!", 3, set.size());

        set.removeItem(-3);
        set.removeItem(0);
        set.removeItem(4);

        assertEquals("Removing all Integers failed!", 0, set.size());

        set.addItem(null);
        assertEquals("Trying to add null is invalid!", 0, set.size());
    }

    @Test
    public void test_AllMethods_Double() {
        Set<Double> set = new Set<>();

        assertEquals("Size of newly declared set should be zero!", 0, set.size());

        set.addItem(-3.141);
        set.addItem(0.0);
        set.addItem(4.56);

        assertFalse("Set size greater than number of added Double values!", set.size() > 3);
        assertTrue("Set does not contain added negative Double value!", set.contains(-3.141));
        assertTrue("Set does not contain added zero!", set.contains(0.0));
        assertTrue("Set does not contain added positive Double value!", set.contains(4.56));

        set.addItem(-3.141);

        assertEquals("Trying to add duplicate Double values is invalid!", 3, set.size());

        set.removeItem(-3.141);
        set.removeItem(0.0);
        set.removeItem(4.56);

        assertEquals("Removing all Double values failed!", 0, set.size());

        set.addItem(null);
        assertEquals("Trying to add null is invalid!", 0, set.size());
    }

    @Test
    public void test_AllMethods_String() {
        Set<String> set = new Set<>();

        assertEquals("Size of newly declared set should be zero!", 0, set.size());

        set.addItem("");
        set.addItem("123");
        set.addItem("Grüße!");
        set.addItem("Monkey business");

        assertFalse("Set size greater than number of added Strings!", set.size() > 4);
        assertTrue("Set does not contain empty String!", set.contains(""));
        assertTrue("Set does not contain String with numbers!", set.contains("123"));
        assertTrue("Set does not contain String with special characters!", set.contains("Grüße!"));
        assertTrue("Set does not contain String with multiple words!", set.contains("Monkey business"));

        set.addItem("");

        assertEquals("Trying to add duplicate Strings is invalid!", 4, set.size());;

        set.removeItem("");
        set.removeItem("123");
        set.removeItem("Grüße!");
        set.removeItem("Monkey business");

        assertEquals("Removing all Strings failed!", 0, set.size());

        set.addItem(null);
        assertEquals("Trying to add null is invalid!", 0, set.size());
    }
}