package com.example.personal;

import com.example.personal.BasicClass.Exercise;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm .*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.*;
import java.util.List;
import java.util.Scanner;

import java.util.Enumeration;
import java.util.concurrent.CountDownLatch;

public class ContatoreviewController {

    @FXML
    private Label count;

    @FXML
    private Label countrep;

    @FXML
    private Label countserie;

    @FXML
    private Label crono;

    @FXML
    private Label musclelabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label repetitionLabel;

    @FXML
    private Label serie;

    @FXML
    private Label seriesLabel;

    @FXML
    private Label weightLabel;

    List<Exercise> exercises= null;

    int variable=1;
    int i=0;
    @FXML
    public void initialize() {
        SerialPort[] ports = SerialPort.getCommPorts();
        System.out.println("Elenco porte seriale disponibili:");
        for (SerialPort port : ports) {
            System.out.println(port.getSystemPortName());
        }
        // Scegli la porta seriale da utilizzare (es. "COM3" per Windows)
        String selectedPort = "COM4";
        SerialPort serialPort = SerialPort.getCommPort(selectedPort);
        if (serialPort.openPort()) {
            System.out.println("Connessione seriale aperta su " + selectedPort);
        } else {
            System.out.println("Impossibile aprire la connessione seriale su " + selectedPort);
        }
        // Imposta i parametri della porta seriale
        serialPort.setComPortParameters(9600, 8, 1, SerialPort.NO_PARITY);
        // Aggiungi un listener per gestire gli eventi di ricezione dati
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

        File file = new File("src/main/resources/com/example/personal/exercises.json");
        if (file != null) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());

            try {
                exercises = mapper.readValue(file, new TypeReference<>() {});
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        showex(getexercisefrom(exercises));

      //  countrep.



    }
    public void showex(Exercise esercizi){
        nameLabel.setText(esercizi.getName());
        musclelabel.setText(esercizi.getMuscleGroup());
        repetitionLabel.setText(String.valueOf(esercizi.getRepetitions()));
        seriesLabel.setText(String.valueOf(esercizi.getSeries()));
        weightLabel.setText(String.valueOf(esercizi.getWeight()));
    }
    Exercise getexercisefrom(List <Exercise> exercises){
        return  exercises.get(i);


    }

    @FXML
    public void next(){
        i++;
        showex(getexercisefrom(exercises));

    }
}