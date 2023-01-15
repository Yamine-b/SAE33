#include "DHT.h"
 
// Definit la broche de l'Arduino sur laquelle la 
// broche DATA du capteur est reliee 
#define DHTPIN A0
 
// Definit le type de capteur utilise
#define DHTTYPE DHT11
 
// Declare un objet de type DHT
// Il faut passer en parametre du constructeur 
// de l'objet la broche et le type de capteur
DHT dht(DHTPIN, DHTTYPE);


// composante photorésistance sur la pin A1
#define LDR A1 
int value;

 
void setup() {
  // initialise la communication avec le PC
  Serial.begin(9600);
   
  // Initialise la capteur DHT11
  dht.begin();

  // initialise les broches
  pinMode(LDR, INPUT);
}
 
void loop() {
  // Recupere la temperature et l'humidite du capteur et l'affiche
  // sur le moniteur serie
  //Serial.print(String(dht.readTemperature()));
  //delay(3000);
  //Serial.print(String(dht.readHumidity()));

  // En mesurant la tension sur la broche A1 on recupere la luminosité de la photoressitance
  // et l'affiche sur le moniteur serie
  //value = analogRead(LDR);
  //Serial.println(String(value));

  
  // Attend 10 secondes avant de reboucler
  //delay(1000);
  //Serial.print(String(dht.readTemperature()) + "/" + String(dht.readHumidity()) + "/" + String(analogRead(LDR)));
  ///Serial.print("");
  //Serial.println(String(dht.readTemperature()));
  //delay(5000);
//   Serial.print(String(dht.readHumidity()));
//   delay(5000);
//   Serial.print(analogRead(LDR));
//   delay(5000);

  // Recupere la temperature et l'humidite du capteur
  float temperature = dht.readTemperature();
  float humidity = dht.readHumidity();
  int light = analogRead(LDR);

  // Envoie les données avec un point-virgule comme séparateur
  Serial.print(temperature);
  Serial.print(";");
  Serial.print(humidity);
  Serial.print(";");
  Serial.println(light);

  // Attend 1 seconde avant de reboucler
  delay(1000);
}