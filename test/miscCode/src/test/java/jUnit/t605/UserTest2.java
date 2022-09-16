package jUnit.t605;
/**
 * @Test – определяет что метод method() является тестовым.
 * @Before – указывает на то, что метод будет выполнятся перед каждым тестируемым методом @Test.
 * @After – указывает на то что метод будет выполнятся после каждого тестируемого метода @Test
 * @BeforeClass – указывает на то, что метод будет выполнятся в начале всех тестов,
 * а точней в момент запуска тестов(перед всеми тестами @Test).
 * @AfterClass – указывает на то, что метод будет выполнятся после всех тестов.
 * @Ignore – говорит, что метод будет проигнорирован в момент проведения тестирования.
 * (expected = Exception.class) – указывает на то, что в данном тестовом методе
 * вы преднамеренно ожидаете Exception.
 * (timeout = 100) – указывает, что тестируемый метод не должен занимать больше чем 100 миллисекунд.
 * <p>
 * fail(String) – указывает на то что бы тестовый метод завалился при этом выводя текстовое сообщение.
 * assertTrue([message], boolean condition) – проверяет, что логическое условие истинно.
 * assertsEquals([String message], expected, actual) – проверяет, что два значения совпадают.
 * Примечание: для массивов проверяются ссылки, а не содержание массивов.
 * assertNull([message], object) – проверяет, что объект является пустым null.
 * assertNotNull([message], object) – проверяет, что объект не является пустым null.
 * assertSame([String], expected, actual) – проверяет, что обе переменные относятся к одному объекту.
 * assertNotSame([String], expected, actual) – проверяет, что обе переменные относятся к разным объектам.
 */
/**
 * fail(String) – указывает на то что бы тестовый метод завалился при этом выводя текстовое сообщение.
 * assertTrue([message], boolean condition) – проверяет, что логическое условие истинно.
 * assertsEquals([String message], expected, actual) – проверяет, что два значения совпадают.
 * Примечание: для массивов проверяются ссылки, а не содержание массивов.
 * assertNull([message], object) – проверяет, что объект является пустым null.
 * assertNotNull([message], object) – проверяет, что объект не является пустым null.
 * assertSame([String], expected, actual) – проверяет, что обе переменные относятся к одному объекту.
 * assertNotSame([String], expected, actual) – проверяет, что обе переменные относятся к разным объектам.
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserTest2 {
    private User2 user;
    private User2 user1;
    private User2 user2;

    private User2 userNotAdd;
    private User2 userNotAdd1;

    @Before
    public void setUp() {
        user = new User2("Евгений", 35, Sex.MALE);
        user1 = new User2("Марина", 34, Sex.FEMALE);
        user2 = new User2("Алина", 7, Sex.FEMALE);

        userNotAdd = new User2("", 0, null);
        userNotAdd1 = new User2(null, 0, null);
    }

    @Test
    public void getAllUsers() {
        List<User2> expected = User2.getAllUsers();

        List<User2> actual = new ArrayList<>();
        actual.add(user);
        actual.add(user1);
        actual.add(user2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void newUser_EMPTY_NAME() {
        for (User2 user : User2.getAllUsers()) {
            if (user.getName() != null && user.getName().isEmpty()) {
                Assert.fail("Попытка создания пользователя с пустым именем");
            }
        }
    }

    @Test
    public void newUser_AGE_ZERO() {
        for (User2 user : User2.getAllUsers()) {
            if (user.getAge() <= 0) {
                Assert.fail("Попытка создания пользователя c не допустимым возрастом");
            }
        }
    }

    @Test
    public void newUser_SEX_NO_NULL() {
        for (User2 user : User2.getAllUsers()) {
            if (user.getSex() == null) {
                Assert.fail("Попытка создания пользователя с указанием пола = null");
            }
        }
    }

    @Test
    public void getAllUsers_NO_NULL() {
        List<User2> expected = User2.getAllUsers();
        Assert.assertNotNull(expected);
    }

    @Test
    public void getAllUsers_MALE() {
        List<User2> expected = User2.getAllUsers(Sex.MALE);

        List<User2> actual = new ArrayList<>();
        actual.add(user);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllUsers_MALE_NO_NULL() {
        //добавим проверку на null
        List<User2> expected = User2.getAllUsers(Sex.MALE);
        Assert.assertNotNull(expected);
    }

    @Test
    public void getAllUsers_FEMALE() {
        List<User2> expected = User2.getAllUsers(Sex.FEMALE);

        List<User2> actual = new ArrayList<>();
        actual.add(user1);
        actual.add(user2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllUsers_FEMALE_NO_NULL() {
        //добавим проверку на null
        List<User2> expected = User2.getAllUsers(Sex.FEMALE);
        Assert.assertNotNull(expected);
    }

    @Test
    public void getHowManyUsers() {
        int expected = User2.getHowManyUsers();

        int actual = 3;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHowManyUsers_MALE() {
        int expected = User2.getHowManyUsers(Sex.MALE);

        int actual = 1;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHowManyUsers_FEMALE() {
        int expected = User2.getHowManyUsers(Sex.FEMALE);

        int actual = 2;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllAgeUsers() {
        int expected = User2.getAllAgeUsers();

        int actual = 35 + 34 + 7;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllAgeUsers_MALE() {
        int expected = User2.getAllAgeUsers(Sex.MALE);

        int actual = 35;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllAgeUsers_FEMALE() {
        int expected = User2.getAllAgeUsers(Sex.FEMALE);

        int actual = 34 + 7;

        Assert.assertEquals(expected, actual);
    }
}