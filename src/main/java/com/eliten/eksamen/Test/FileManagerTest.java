package com.eliten.eksamen.Test;

import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.managers.FileManager;
import org.junit.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.powermock.modules.junit4.PowerMockRunner;


import static org.mockito.Mockito.*;


import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
@RunWith(PowerMockRunner.class)
class FileManagerTest{

    @InjectMocks
    Eliten eliten = new Eliten();

    @Before
    public void setup(){
    Eliten.mockStatic();
    }

    @Test
    public void readAllFiles() {
        assertEquals(Eliten.mediaManager().getMedias().size(), 200);
    }
}