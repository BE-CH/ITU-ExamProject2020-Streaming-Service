package com.eliten.eksamen.Test;

import com.eliten.eksamen.managers.FileManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MediaManagerTest {

    @Test
    public void getMediaByNameTest(){
        FileManager fileManager = new FileManager();
        fileManager.readFiles();
        assertEquals(fileManager.getTestMediaManager().getMediaByName("Psycho").getName(), "Psycho");
    }
}






