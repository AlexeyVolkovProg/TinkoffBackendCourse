package edu.hw6.Task6;

import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("MagicNumber")
public class Task6 {

    private Task6() {

    }

    static List<Integer> knownPorts = Arrays.asList(
        135,
        137,
        138,
        139,
        445,
        843,
        1900,
        3702,
        5040,
        5050,
        5353,
        5355,
        5939,
        6463,
        6942,
        17500,
        17600,
        27017,
        42420
    );

    private static String getKnownServiceName(int port) {
        return switch (port) {
            case 135 -> "EPMAP";
            case 137 -> "Служба имен NetBIOS";
            case 138 -> "Служба датаграмм NetBIOS";
            case 139 -> "Служба сеансов NetBIOS";
            case 445 -> "Microsoft-DS Active Directory";
            case 843 -> "Adobe Flash";
            case 1900 -> "Simple Service Discovery Protocol (SSDP)";
            case 3702 -> "Динамическое обнаружение веб-служб";
            case 5353 -> "Многоадресный DNS";
            case 5355 -> "Link-Local Multicast Name Resolution (LLMNR)";
            case 17500 -> "Dropbox";
            case 27017 -> "MongoDB";
            default -> "";
        };
    }

    public static List<String> checkTcpPorts(Integer min, Integer max) {
        List<String> ports = new ArrayList<>();
        String string = "TCP:";
        for (int port = min; port <= max; port++) {
            try {
                ServerSocket serverSocket = new ServerSocket(port);
                serverSocket.close();
                ports.add(string + port + ": ");

            } catch (Exception e) {
                String serviceName = getServiceName(port, knownPorts);
                ports.add(string + port + ":" + serviceName);
            }
        }
        return ports;
    }

    public static List<String> checkUdpPorts(Integer min, Integer max) {
        List<String> ports = new ArrayList<>();
        String string = "UDP:";
        for (int port = min; port <= max; port++) {
            try {
                DatagramSocket datagramSocket = new DatagramSocket(port);
                datagramSocket.close();
                ports.add(string + port + ": ");
            } catch (Exception e) {
                String serviceName = getServiceName(port, knownPorts);
                ports.add(string + port + ":" + serviceName);
            }
        }
        return ports;
    }

    private static String getServiceName(int port, List<Integer> knownPorts) {
        if (knownPorts.contains(port)) {
            return getKnownServiceName(port);
        } else {
            return "";
        }
    }

}
