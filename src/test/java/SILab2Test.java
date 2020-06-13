import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SILab2Test {

    SILab2 obj = new SILab2();
    @Test
    public void testEveryStatement() {
        assertFalse(obj.function(null, Arrays.asList("Stefan", "Marija", "Bojan")));

        assertTrue(obj.function(new User("Andrej", "abcd1234", "andrej.mrceski@gmail.com"), Arrays.asList("Stefan", "Marija", "Bojan")));
    }

    @Test
    public void testEveryPath() {
        //1, 11, 12
        assertFalse(obj.function(null, Arrays.asList("Stefan", "Marija", "Bojan")));

        //2. 1, 2, 11, 12
        assertFalse(obj.function(new User("Andrej", "abcd1234", "andrej.mrceski@gmail.com"), Arrays.asList("Andrej", "Stefan", "Marija", "Bojan")));

        //3. 1, 2, 3, 4.1, 4.2, 9, 11, 12
        assertFalse(obj.function(new User("Andrej", "abcd1234", ""), Arrays.asList("Stefan", "Marija", "Bojan")));

        //4. 1, 2, 3, 4.1, 4.2, (5, 7, 4.3, 4.2), 9, 11, 12
        assertFalse(obj.function(new User("Andrej", "abcd1234", "andrej.mrceski.com"), Arrays.asList("Stefan", "Marija", "Bojan")));

        //5. 1, 2, 3, 4.1, 4.2, (5, 6, 7, 4.3, 4.2), 9, 11, 12
        assertFalse(obj.function(new User("Andrej", "abcd1234", "andrej.mrceski@gmailcom"), Arrays.asList("Stefan", "Marija", "Bojan")));

        //6. 1, 2, 3, 4.1, 4.2, (5, 7, 8, 4.3, 4.2), 9, 11, 12 - can not happen

        //7. 1, 2, 3, 4.1, 4.2, (5, 6, 7, 8, 4.3, 4.2), 9, 10, 12
        assertTrue(obj.function(new User("Andrej", "abcd1234", "andrej.mrceski@gmail.com"), Arrays.asList("Stefan", "Marija", "Bojan")));
    }
}