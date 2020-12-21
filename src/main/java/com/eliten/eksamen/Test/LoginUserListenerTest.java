package com.eliten.eksamen.Test;

import com.eliten.eksamen.gui.actionlisteners.LoginUserListener;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoginUserListenerTest {

    @Test
    public void TestEmptyPassWord() {
        LoginUserListener loginUserListener = new LoginUserListener(new JTextField("milb@itu.dk"), new JPasswordField(""));
        assertEquals(loginUserListener.actionPerformedTest(), "You need to put in both user and password.");
    }
}



