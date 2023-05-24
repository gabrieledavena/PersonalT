package com.example.personal;

import com.example.personal.BasicClass.BMI;
import com.example.personal.BasicClass.Contatore;
import java.math.BigDecimal;
import java.math.RoundingMode;
import com.fazecast.jSerialComm.*;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.text.*;
import java.util.*;
import javafx.scene.control.Label;
import com.fazecast.jSerialComm.SerialPort;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ContatoreviewController {



        private Contatore contatore;
        private SerialPort arduinoPort;

        public ContatoreviewController() {
            contatore = new Contatore();
        }

        public void connectToArduino(String portName) {
            arduinoPort = SerialPort.getCommPort(portName);
            arduinoPort.setBaudRate(9600);

            if (arduinoPort.openPort()) {
                System.out.println("Connessione stabilita con Arduino sulla porta: " + portName);
                startReadingData();
            } else {
                System.out.println("Impossibile stabilire una connessione con Arduino sulla porta: " + portName);
            }
        }

        public void disconnectFromArduino() {
            if (arduinoPort != null && arduinoPort.isOpen()) {
                arduinoPort.closePort();
                System.out.println("Connessione con Arduino chiusa.");
            }
        }

        private void startReadingData() {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(arduinoPort.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    int buttonState = Integer.parseInt(line);
                    if (buttonState == 1) {
                        contatore.aggiungi();
                        System.out.println("Count: " + contatore.getCount());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            ContatoreviewController controller = new ContatoreviewController();
            controller.connectToArduino("COM3"); // Sostituisci con il nome effettivo della porta Arduino
        }
    }
