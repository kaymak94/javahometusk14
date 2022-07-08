package ru.netology.domain;

import ru.netology.managers.Game;
import ru.netology.exceptions.NotRegisteredException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Collection;


import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    Collection<Player> playersList = new ArrayList<>();


    private Game game = new Game();
    Player player1 = new Player(1, "Pavel", 7);
    Player player2 = new Player(2, "Kolya", 5);
    Player player3 = new Player(3, "Valentin", 7);
    Player player4 = new Player(4, "Boris", 8);
    Player player5 = new Player(5, "Misha", 4);
    Player player6 = new Player(6, "Sasha", 10);


    @Test
    public void findByNameTest() {
        playersList.add(player1);
        playersList.add(player2);
        playersList.add(player3);
        playersList.add(player4);
        playersList.add(player5);
        playersList.add(player6);


        int actual = game.findByName("Misha");
        int expected = 5;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundWinFirstTest() {
        playersList.add(player1);
        playersList.add(player2);
        playersList.add(player3);
        playersList.add(player4);
        playersList.add(player5);
        playersList.add(player6);


        int actual = game.round("Boris", "Pavel");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundWinSecondTest() {
        playersList.add(player1);
        playersList.add(player2);
        playersList.add(player3);
        playersList.add(player4);
        playersList.add(player5);
        playersList.add(player6);


        int actual = game.round("Boris", "Sasha");
        int expected = -1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundStrengthEqualsTest() {
        playersList.add(player1);
        playersList.add(player2);
        playersList.add(player3);
        playersList.add(player4);
        playersList.add(player5);
        playersList.add(player6);


        int actual = game.round("Valentin", "Pavel");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundFirstNotRegisteredExceptionTest() {
        playersList.add(player1);
        playersList.add(player2);
        playersList.add(player3);
        playersList.add(player4);
        playersList.add(player5);
        playersList.add(player6);


        assertThrows(NotRegisteredException.class, () -> {
            game.round("Alex", "Kolya");

        });
    }

    @Test
    public void roundSecondNotRegisteredExceptionTest() {
        playersList.add(player1);
        playersList.add(player2);
        playersList.add(player3);
        playersList.add(player4);
        playersList.add(player5);
        playersList.add(player6);


        assertThrows(NotRegisteredException.class, () -> {
            game.round("Valentin", "German");

        });
    }

    @Test
    public void roundBothNotRegisteredExceptionTest() {
        playersList.add(player1);
        playersList.add(player2);
        playersList.add(player3);
        playersList.add(player4);
        playersList.add(player5);
        playersList.add(player6);


        assertThrows(NotRegisteredException.class, () -> {
            game.round("Alex", "German");

        });

    }
}