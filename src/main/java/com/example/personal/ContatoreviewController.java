package com.example.personal;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm .*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Scanner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serial;
import java.util.Enumeration;
import java.util.concurrent.CountDownLatch;

public class ContatoreviewController {

    @FXML
    private Label count;
    int variable=1;
    @FXML
    public void initialize() {
        SerialPort[] ports = SerialPort.getCommPorts();


        System.out.println("Elenco porte seriale disponibili:");

        for (SerialPort port : ports) {
            System.out.println(port.getSystemPortName());
        }

        // Scegli la porta seriale da utilizzare (es. "COM3" per Windows)
        String selectedPort = "COM3";
        SerialPort serialPort = SerialPort.getCommPort(selectedPort);
        if (serialPort.openPort()) {
            System.out.println("Connessione seriale aperta su " + selectedPort);
        } else {
            System.out.println("Impossibile aprire la connessione seriale su " + selectedPort);
        }

        // Imposta i parametri della porta seriale
        serialPort.setComPortParameters(9600, 8, 1, SerialPort.NO_PARITY);
        System.out.println("1");
        // Aggiungi un listener per gestire gli eventi di ricezione dati

        System.out.println("1");
        serialPort.addDataListener(new SerialPortDataListener() {  public int getListeningEvents() {
            System.out.println("2");
            return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
            }
            public void serialEvent(SerialPortEvent event) {

                if (event.getEventType() == SerialPort.LISTENING_EVENT_DATA_AVAILABLE) {
                    byte[] newData = new byte[serialPort.bytesAvailable()];
                    int numRead = serialPort.readBytes(newData, newData.length);

                    // Converti i dati in una stringa
                    String receivedData = new String(newData);
                    if (receivedData.trim().equals("1")) {
                        // Aggiungi 1 al valore della variabile
                         // Valore iniziale della variabile
                        variable += 1;
                        System.out.println("Valore variabile aggiornato: " + variable);
                    }
                    if (receivedData.trim().equals("2")) {
                        // Aggiungi 1 al valore della variabile
                        // Valore iniziale della variabile
                        variable -= 1;
                        System.out.println("Valore variabile aggiornato: " + variable);
                    }



                    Platform.runLater(() -> {count.setText(String.valueOf(variable));});
                }
            }
        });

    }
}