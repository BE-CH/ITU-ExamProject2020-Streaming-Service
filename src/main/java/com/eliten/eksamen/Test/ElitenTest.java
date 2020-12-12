package com.eliten.eksamen.Test;

import com.eliten.eksamen.Eliten;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ElitenTest {
    @Before
    public void setUp(){
    }
    @Test
    public void loadAllFiles(){
        Eliten e = new Eliten();
        System.out.println("test");
        assertEquals(e.mediaManager().getMedias().size(), 200);
    }

}