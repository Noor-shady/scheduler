package com.scheduler.scheduler.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OpenBrowser {

    @EventListener(ApplicationReadyEvent.class)
    public void launchBrowser() {
        System.out.println("🚀 App started! Attempting to open browser...");

        try {
            String os = System.getProperty("os.name").toLowerCase();
            String url = "http://localhost:8080";

            if (os.contains("mac")) {
                Runtime.getRuntime().exec("open " + url);
            } else if (os.contains("win")) {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
            } else {
                Runtime.getRuntime().exec("xdg-open " + url);
            }
        } catch (Exception e) {
            System.out.println("⚠️ Could not open browser automatically. Please go to http://localhost:8080");
        }
    }
}