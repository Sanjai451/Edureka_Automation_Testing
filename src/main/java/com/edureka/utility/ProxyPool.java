package com.edureka.utility;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ProxyPool {

	private static final List<String> ALL_PROXIES = Arrays.asList(
	        "104.161.23.122:5001",
	        "139.59.24.173:1080"
	    );

	    // Only contains proxies that actually respond
	    private static final List<String> LIVE_PROXIES = new CopyOnWriteArrayList<>();
	    private static final AtomicInteger index = new AtomicInteger(0);

	    static {
	        validateProxies(); // runs once when class loads
	    }

	    private static void validateProxies() {
	        for (String proxy : ALL_PROXIES) {
	            String[] parts = proxy.split(":");
	            String host = parts[0];
	            int port = Integer.parseInt(parts[1]);

	            try (Socket socket = new Socket()) {
	                socket.connect(new InetSocketAddress(host, port), 2000); // 2s timeout
	                LIVE_PROXIES.add(proxy);
	                System.out.println("[ProxyPool] Proxy OK: " + proxy);
	            } catch (IOException e) {
	                System.out.println("[ProxyPool] Proxy DEAD (skipping): " + proxy);
	            }
	        }

	        if (LIVE_PROXIES.isEmpty()) {
	            System.out.println("[ProxyPool] WARNING: No live proxies found. Falling back to DIRECT.");
	        }
	    }

	    public static String getNextProxy() {
	        if (LIVE_PROXIES.isEmpty()) return null; // signals fallback to direct
	        int i = index.getAndIncrement() % LIVE_PROXIES.size();
	        return LIVE_PROXIES.get(i);
	    }
}	
