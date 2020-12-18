package com.eliten.eksamen.Test;

import com.eliten.eksamen.managers.FileManager;
import com.eliten.eksamen.media.Media;
import com.eliten.eksamen.media.MediaType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {
    private FileManager fileManager = new FileManager();
    private Media movieTest = new Media("Casablanca", MediaType.MOVIE, 19428, 5);

    @Test
    public void readFilesTest() {
        fileManager.readFiles();
        assertEquals(fileManager.getTestMediaManager().getMedias().size(), 200);
    }

    @Test
    public void getImageTest() {
        fileManager.addImage(movieTest, "movie_images");
        assertNotNull(movieTest.getImage());
    }
}



