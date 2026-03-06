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