package com.scheduler.scheduler.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.net.URI;

@Component
public class OpenBrowser {

    @EventListener(ApplicationReadyEvent.class)
    public void launchBrowser() {
        // If I am, just skip this step entirely so the app doesn't crash.
        if (GraphicsEnvironment.isHeadless()) {
            System.out.println("🖥️ Server is headless. Skipping browser launch.");
            return;
        }

        System.out.println("🚀 App started! Attempting to open browser...");

        String url = "http://localhost:8080";

        // Use the modern Java AWT Desktop API first
        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(url));
            } else {