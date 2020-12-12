package com.eliten.eksamen.Test;

import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.account.User;
import com.eliten.eksamen.media.Media;
import com.eliten.eksamen.media.MediaType;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserTest{
    User user = new User("Henning", 12, new ArrayList<Media>());
    Media movieTest = new Media("Casablanca", MediaType.MOVIE, 19428,5);

    @Test
    void addToList() {
        user.addToList(movieTest);
        assertEquals(user.getMyList().get(0).getName(), "Casablanca");
    }

    @Test
    void removeFromList() {
        user.addToList(movieTest);
        user.removeFromList(movieTest);
        assertEquals(user.getMyList().size(), 0);
    }
}