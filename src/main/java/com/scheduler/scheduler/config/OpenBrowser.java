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
        System.out.println("🚀 Application started! Opening browser...");

        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI("http://localhost:8080"));
            }
        } catch (Exception e) {

