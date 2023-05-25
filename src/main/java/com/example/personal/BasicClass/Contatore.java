package com.example.personal.BasicClass;

import javafx.scene.control.Label;

public class Contatore {

    private Double count;

        public Contatore() {
            count = 0.0;
        }

        public void aggiungi() {
            count =count + 1.0;
        }

        public void rimuovi() {
            count = count - 1.0;
        }

        public double getCount() {
            return count;
        }
    }
