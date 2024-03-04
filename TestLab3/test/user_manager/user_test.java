/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package user_manager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class user_test {

    public user_test() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testUserRegistration() {
        UserManager userManager = new UserManager();
        userManager.registerUser("user", "john@example.com", "password");

        // Check if the user was successfully registered
        assertTrue(userManager.loginUser("user", "password"));
    }

    @Test
    public void testDuplicateEmailRegistration() {
        UserManager userManager = new UserManager();
        userManager.registerUser("user1", "john@example.com", "password");

        // Try to register another user with the same email
        assertThrows(IllegalArgumentException.class, () -> {
            userManager.registerUser("user1", "john@example.com", "password");
        });
    }

    //register
    @Test
    public void testRegisterUsernameInvalid1() {
        UserManager userManager = new UserManager();

        try {
            assertFalse(userManager.registerUser("", "john@example.com", "password"));
        } catch (Exception e) {
            assertEquals("Username must be > 0 && < 20", e.getMessage());
        }
        // Check if the email was successfully updated
        assertFalse(userManager.loginUser("user", "password"));
    }

    @Test
    public void testRegisterUsernameInvalid2() {
        UserManager userManager = new UserManager();

        try {
            assertFalse(userManager.registerUser(null, "john@example.com", "password"));
        } catch (Exception e) {
            assertEquals("Username must be > 0 && < 20", e.getMessage());
        }
        // Check if the email was successfully updated
        assertFalse(userManager.loginUser("user", "password"));
    }

    @Test
    public void testRegisterUsernameInvalid3() {
        UserManager userManager = new UserManager();

        try {
            assertFalse(userManager.registerUser("LargeUsernameLengthInvalid", "john@example.com", "password"));
        } catch (Exception e) {
            assertEquals("Username must be > 0 && < 20", e.getMessage());
        }
        // Check if the email was successfully updated
        assertFalse(userManager.loginUser("user", "password"));
    }

    @Test
    public void testRegisterUsernameInvalid4() {
        UserManager userManager = new UserManager();

        try {
            assertTrue(userManager.registerUser("a", "john@example.com", "password"));
        } catch (Exception e) {
            assertEquals("User not found", e.getMessage());
        }
        // Check if the email was successfully updated
        assertTrue(userManager.loginUser("a", "password"));
    }

    @Test
    public void testRegisterEmailInvalid1() {
        UserManager userManager = new UserManager();

        try {
            assertFalse(userManager.registerUser("username", "", "password"));
        } catch (Exception e) {
            assertEquals("Username must be > 0 && < 50 && contain @", e.getMessage());
        }
        // Check if the email was successfully updated
        assertFalse(userManager.loginUser("user", "password"));
    }

    @Test
    public void testRegisterEmailInvalid2() {
        UserManager userManager = new UserManager();

        try {
            assertFalse(userManager.registerUser("username", null, "password"));
        } catch (Exception e) {
            assertEquals("Username must be > 0 && < 50 && contain @", e.getMessage());
        }
        // Check if the email was successfully updated
        assertFalse(userManager.loginUser("user", "password"));
    }

    @Test
    public void testRegisterEmailInvalid3() {
        UserManager userManager = new UserManager();

        try {
            assertFalse(userManager.registerUser("username", "johnexample.com", "password"));
        } catch (Exception e) {
            assertEquals("Username must be > 0 && < 50 && contain @", e.getMessage());
        }
        // Check if the email was successfully updated
        assertFalse(userManager.loginUser("user", "password"));
    }

    @Test
    public void testRegisterEmailInvalid4() {
        UserManager userManager = new UserManager();

        try {
            assertFalse(userManager.registerUser("username", "johnlengthinvalid50abccc@example.commmmmmmmmmm", "password"));
        } catch (Exception e) {
            assertEquals("Username must be > 0 && < 50 && contain @", e.getMessage());
        }
        // Check if the email was successfully updated
        assertFalse(userManager.loginUser("user", "password"));
    }

    @Test
    public void testRegisterPasswordInvalid1() {
        UserManager userManager = new UserManager();

        try {
            assertFalse(userManager.registerUser("username", "john@example.com", ""));
        } catch (Exception e) {
            assertEquals("password must be > 0 && < 50", e.getMessage());
        }
        // Check if the email was successfully updated
        assertFalse(userManager.loginUser("user", "password"));
    }

    @Test
    public void testRegisterPasswordInvalid2() {
        UserManager userManager = new UserManager();

        try {
            assertFalse(userManager.registerUser("username", "john@example.com", null));
        } catch (Exception e) {
            assertEquals("password must be > 0 && < 50", e.getMessage());
        }
        // Check if the email was successfully updated
        assertFalse(userManager.loginUser("user", "password"));
    }

    @Test
    public void testRegisterPasswordInvalid3() {
        UserManager userManager = new UserManager();

        try {
            assertFalse(userManager.registerUser("username", "john@example.com", "passwordlengthinvalidabcdsasasasasasasefgh"));
        } catch (Exception e) {
            assertEquals("password must be > 0 && < 50", e.getMessage());
        }
        // Check if the email was successfully updated
        assertFalse(userManager.loginUser("user", "password"));
    }

    @Test
    public void testRegisterPasswordInvalid4() {
        UserManager userManager = new UserManager();

        try {
            assertTrue(userManager.registerUser("username", "john@example.com", "password"));
        } catch (Exception e) {
            assertEquals("password must be > 0 && < 50", e.getMessage());
        }
        // Check if the email was successfully updated
        assertTrue(userManager.loginUser("username", "password"));
    }

    //login
    @Test
    public void testUserLogin2() {
        UserManager userManager = new UserManager();
        userManager.registerUser("user", "john@example.com", "password");

        // Check if the user was successfully registered
        assertFalse(userManager.loginUser("user", "wrong_password"));
    }

    @Test
    public void testUserLogin3() {
        UserManager userManager = new UserManager();
        userManager.registerUser("user", "john@example.com", "password");

        // Check if the user was successfully registered
        assertFalse(userManager.loginUser("wrong_user", "wrong_password"));
    }

    @Test
    public void testUserLogin4() {
        UserManager userManager = new UserManager();
        userManager.registerUser("user", "john@example.com", "password");

        // Check if the user was successfully registered
        assertFalse(userManager.loginUser("", "wrong_password"));
    }

    @Test
    public void testUserLogin5() {
        UserManager userManager = new UserManager();
        userManager.registerUser("user", "john@example.com", "password");

        // Check if the user was successfully registered
        assertFalse(userManager.loginUser(null, "wrong_password"));
    }

    @Test
    public void testUserLogin6() {
        UserManager userManager = new UserManager();
        userManager.registerUser("user", "john@example.com", "password");

        // Try to log in with an invalid password
        assertFalse(userManager.loginUser("user1", "wrong_password"));
    }

    @Test
    public void testUserLogin7() {
        UserManager userManager = new UserManager();
        userManager.registerUser("user", "john@example.com", "password");

        // Try to log in with an invalid password
        assertFalse(userManager.loginUser("user", ""));
    }

    @Test
    public void testUserLogin8() {
        UserManager userManager = new UserManager();
        userManager.registerUser("user", "john@example.com", "password");

        // Try to log in with an invalid password
        assertFalse(userManager.loginUser("user", null));
    }

    @Test
    public void testUserLogin9() {
        UserManager userManager = new UserManager();
        userManager.registerUser("user", "john@example.com", "password");

        // Try to log in with an invalid password
        assertFalse(userManager.loginUser("", ""));
    }

    @Test
    public void testUserLogin10() {
        UserManager userManager = new UserManager();
        userManager.registerUser("user", "john@example.com", "password");

        // Try to log in with an invalid password
        assertFalse(userManager.loginUser(null, null));
    }

    @Test
    public void testUserLogin11() {
        UserManager userManager = new UserManager();
        userManager.registerUser("user", "john@example.com", "password");

        // Try to log in with an invalid password
        assertFalse(userManager.loginUser(null, ""));
    }

    @Test
    public void testUserLogin12() {
        UserManager userManager = new UserManager();
        userManager.registerUser("user", "john@example.com", "password");

        // Try to log in with an invalid password
        assertFalse(userManager.loginUser("", null));
    }

    @Test
    public void testUpdateUserEmail1() {
        UserManager userManager = new UserManager();
        userManager.registerUser("user", "john@example.com", "password");

        // Update the user's email
        try {
            userManager.updateUserEmail("user", "new_email@example.com");
        } catch (Exception e) {
            assertEquals("User not found", e.getMessage());
        }

        // Check if the email was successfully updated
        assertTrue(userManager.loginUser("user", "password"));
    }

    @Test
    public void testUpdateUserEmai2() {
        UserManager userManager = new UserManager();
        userManager.registerUser("user", "john@example.com", "password");

        try {
            assertFalse(userManager.updateUserEmail("user1", "new_email@example.com"));
        } catch (Exception e) {
            assertEquals("User not found", e.getMessage());
        }

        // Check if the email was successfully updated
        assertTrue(userManager.loginUser("user", "password"));
    }

    @Test
    public void testUpdateUserEmail3() {
        UserManager userManager = new UserManager();
        userManager.registerUser("user", "john@example.com", "password");

        try {
            assertFalse(userManager.updateUserEmail("", "new_email@example.com"));
        } catch (Exception e) {
            assertEquals("User not found", e.getMessage());
        }

        // Check if the email was successfully updated
        assertTrue(userManager.loginUser("user", "password"));
    }

    @Test
    public void testUpdateUserEmail4() {
        UserManager userManager = new UserManager();
        userManager.registerUser("user", "john@example.com", "password");

        try {
            assertFalse(userManager.updateUserEmail(null, "new_email@example.com"));
        } catch (Exception e) {
            assertEquals("User not found", e.getMessage());
        }

        // Check if the email was successfully updated
        assertTrue(userManager.loginUser("user", "password"));
    }

    //delete
    @Test
    public void testDeleteUser() {
        UserManager userManager = new UserManager();
        userManager.registerUser("user", "john@example.com", "password");

        // Delete the user
        userManager.deleteUser("user");

        // Check if the user was successfully deleted
        assertFalse(userManager.loginUser("user", "password"));
    }

    @Test
    public void testDeleteInvalidUser1() {
        UserManager userManager = new UserManager();
        userManager.registerUser("user", "john@example.com", "password");
        // Delete the invalid user
        try {
            assertFalse(userManager.deleteUser(""));
        } catch (Exception e) {
            assertEquals("User not found", e.getMessage());
        }

        // Check if the user was successfully deleted
        assertFalse(userManager.loginUser("user1", "password"));
    }

    @Test
    public void testDeleteInvalidUser2() {
        UserManager userManager = new UserManager();
        userManager.registerUser("user", "john@example.com", "password");

        // Delete the invalid user
        try {
            assertFalse(userManager.deleteUser(null));
        } catch (Exception e) {
            assertEquals("User not found", e.getMessage());
        }
        // Check if the user was successfully deleted
        assertFalse(userManager.loginUser("user1", "password"));
    }

    @Test
    public void testDeleteInvalidUser3() {
        UserManager userManager = new UserManager();
        userManager.registerUser("user", "john@example.com", "password");

        // Delete the invalid user
        try {
            assertFalse(userManager.deleteUser("user123"));
        } catch (Exception e) {
            assertEquals("User not found", e.getMessage());
        }

        // Check if the user was successfully deleted
        assertFalse(userManager.loginUser("user1", "password"));
    }

    @Test
    public void testDeleteInvalidUser4() {
        UserManager userManager = new UserManager();
        userManager.registerUser("user", "john@example.com", "password");

        // Delete the invalid user
        try {
            assertFalse(userManager.deleteUser("validusernamelngthmassccsaca"));
        } catch (Exception e) {
            assertEquals("User not found", e.getMessage());
        }
        userManager.deleteUser("user");

        // Check if the user was successfully deleted
        assertFalse(userManager.loginUser("user1", "password"));
    }

    //update password
    @Test
    public void testUpdatePassword1() {
        UserManager userManager = new UserManager();
        userManager.registerUser("user", "john@example.com", "old_password");

        // Update the user's password
        try {
            assertTrue(userManager.updatePassword("user", "old_password", "new_password1"));
        } catch (Exception e) {
            assertEquals("password must be > 0 && < 50 && not equal oldpass || not contain number", e.getMessage());
        }

        // Check if the password was successfully updated
        assertTrue(userManager.loginUser("user", "new_password1"));
    }

    @Test
    public void testUpdatePassword2() {
        UserManager userManager = new UserManager();
        userManager.registerUser("user", "john@example.com", "old_password");

        // Update the user's password
        try {
            assertFalse(userManager.updatePassword("user", "old_password", "new_passwordinvalidlengthabcascnasnckajsck"));
        } catch (Exception e) {
            assertEquals("password must be > 0 && < 50 && not equal oldpass || not contain number", e.getMessage());
        }

        // Check if the password was old password
        assertFalse(userManager.loginUser("user", "new_password"));
    }

    @Test
    public void testUpdatePassword3() {
        UserManager userManager = new UserManager();
        userManager.registerUser("user", "john@example.com", "old_password");

        // Update the user's password
        try {
            assertTrue(userManager.updatePassword("user", "old_password", ""));
        } catch (Exception e) {
            assertEquals("password must be > 0 && < 50 && not equal oldpass || not contain number", e.getMessage());
        }

        // Check if the password was successfully updated
        assertFalse(userManager.loginUser("user", "new_password"));
    }

    @Test
    public void testUpdatePassword4() {
        UserManager userManager = new UserManager();
        userManager.registerUser("user", "john@example.com", "old_password");

        // Update the user's password
        try {
            assertTrue(userManager.updatePassword("user", "old_password", null));
        } catch (Exception e) {
            assertEquals("password must be > 0 && < 50 && not equal oldpass || not contain number", e.getMessage());
        }

        // Check if the password was successfully updated
        assertFalse(userManager.loginUser("user", "new_password"));
    }

    @Test
    public void testUpdatePassword5() {
        UserManager userManager = new UserManager();
        userManager.registerUser("user", "john@example.com", "old_password");

        // Update the user's password
        try {
            assertTrue(userManager.updatePassword("user", "old_password", "old_password"));
        } catch (Exception e) {
            assertEquals("password must be > 0 && < 50 && not equal oldpass || not contain number", e.getMessage());
        }
        
        // Check if the password was successfully updated
        assertFalse(userManager.loginUser("user", "new_password"));
    }

    @Test
    public void testUpdatePassword6() {
        UserManager userManager = new UserManager();
        userManager.registerUser("user", "john@example.com", "old_password");

        // Update the user's password
        try {
            assertTrue(userManager.updatePassword("user", "old_password", "new_password_no_digit"));
        } catch (Exception e) {
            assertEquals("password must be > 0 && < 50 && not equal oldpass || not contain number", e.getMessage());
        }
        
        // Check if the password was successfully updated
        assertFalse(userManager.loginUser("user", "new_password"));
    }
}
