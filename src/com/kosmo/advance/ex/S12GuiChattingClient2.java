package com.kosmo.advance.ex;

import javax.swing.*;
import java.io.IOException;

public class S12GuiChattingClient2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            S12GuiChattingClient gui = null;
            try {
                gui = new S12GuiChattingClient("최경민");
                gui.setVisible(true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }
}
