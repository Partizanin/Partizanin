package hash.hw2;


import hw2.hash.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    private User instance;

    @Before
    public void setUp() {
        instance = new User("Vaxa", "Vasa123", "male", 22, "26.07.2014");
    }

    @Test
    public void testEqualsNull() {
        assertEquals(false, instance.equals(null));
    }

    @Test
    public void testEqualsReflexive() {
        assertEquals(true, instance.equals(instance));
    }


    @Test
    public void testEqualsSymmetric() {
        User user = new User("Vaxa", "Vasa123", "male", 22, "26.07.2014");
        assertEquals(true, instance.equals(user) && user.equals(instance));
    }

    @Test
    public void testEqualsTransitive() {
        User user = new User("Vaxa", "Vasa123", "male", 22, "26.07.2014");
        User user2 = new User("Vaxa", "Vaasa123", "male", 22, "26.07.2014");
        assertEquals(true, instance.equals(user));
        assertEquals(true, instance.equals(user2));
    }


    @Test
    public void testHashCode() {
        User user = new User("Vaxa", "Vasa123", "male", 22, "26.07.2014");
        assertEquals(true, instance.hashCode() == user.hashCode());
    }

}
