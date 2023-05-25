const int buttonPin = 2; // Pin del pulsante
bool buttonState = false; // Stato del pulsante
const int buttonPin2 = 3; // Pin del pulsante
bool buttonState2 = false; // Stato del pulsante

void setup() {
  Serial.begin(9600); // Inizializza la comunicazione seriale
  pinMode(buttonPin, INPUT_PULLUP); // Imposta il pin del pulsante come INPUT con resistenza di pull-up
   pinMode(buttonPin2, INPUT_PULLUP);
}

void loop() {
  // Legge lo stato del pulsante
  buttonState = digitalRead(buttonPin);
  buttonState2 = digitalRead(buttonPin2);


  // Verifica se il pulsante è stato premuto
  if (buttonState == LOW) {
    Serial.println(1); // Invia il messaggio "ButtonPressed" alla porta seriale
    delay(500); // Aggiungi un ritardo per evitare letture multiple consecutive
  }
  if (buttonState2 == LOW) {
    Serial.println(2); // Invia il messaggio "ButtonPressed" alla porta seriale
    delay(500); // Aggiungi un ritardo per evitare letture multiple consecutive
  }
}