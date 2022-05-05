import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

@Test()
public class TestingCaesar {

    @Test(priority = -1, groups = {"personal"})
    public void name() {
        assertEquals("Julius", Caesar.getFirstName());
        assertEquals("Caesar", Caesar.getLastName());
    }

    @Test(priority = -1, groups = {"personal"})
    public void whatsForDinner() {
        assertEquals("Sallad", Caesar.getDinner());
    }



    @Test(groups = {"cipher"})
    public void encrypt() {
        String str = Caesar.encrypt("Test av IT", 3);
        assertEquals("Whvw dy LW", str);
    }

    @Test(groups = {"cipher"})
    public void decrypt() {
        String str = Caesar.decrypt("Hvwg ghfwbu awuvh ps sbqfmdhsr", 14);
        assertEquals("This string might be encrypted", str);
    }

    @Test(groups = {"cipher"},
            dependsOnMethods = {"encrypt", "decrypt"},
            dataProvider="getData")
    public void encryptAndDecrypt(int key) {
        String plainText = "The key is as number";
        String encrypted = Caesar.encrypt(plainText, key);
        String decrypted = Caesar.decrypt(encrypted, key);
        assertEquals(plainText, decrypted);
    }

    @DataProvider
    // Generates keys to produce all possible Caesar-cipher shifts.
    public Object[][] getData() {
        Object[][] data = new Object[27][1];
        for (int i = 0; i <= 26; i++) {
            data[i][0] = i;
        }
        return data;
    }
}