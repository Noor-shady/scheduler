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
                openBrowserFallback(url);
            }
        } catch (Exception e) {
            // Log the error silently instead of crashing the app
            System.err.println("⚠️ Could not open browser automatically: " + e.getMessage());
            System.out.println("👉 Please open manually: " + url);
        }
    }

    private void openBrowserFallback(String url) {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            Runtime rt = Runtime.getRuntime();

            if (os.contains("win")) {
                rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
            } else if (os.contains("mac")) {
                rt.exec("open " + url);
            } else if (os.contains("nix") || os.contains("nux")) {
                // Try common Linux browsers
                String[] browsers = {"xdg-open", "google-chrome", "firefox"};
                for (String browser : browsers) {
                    try {
                        rt.exec(new String[]{browser, url});
                        // Stop if one works
                        break;
                    } catch (Exception e) {
                        // Continue to next browser
                    }
                }
            }
        } catch (Exception e) {
            // Ignore fallback errors
        }
    }
}