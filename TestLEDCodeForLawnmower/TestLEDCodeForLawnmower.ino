#include <FastLED.h>

#define LED_PIN 5
#define BRIGHTNESS 64
#define NUM_LEDS 80
#define signalPin 2
CRGB leds[NUM_LEDS];

void setup() {
  FastLED.addLeds<WS2812B, LED_PIN, RGB>(leds, NUM_LEDS);
  pinMode(signalPin, INPUT);
}

void loop() {
  if (digitalRead(signalPin) == HIGH) {
    for (int i = 0; i <= NUM_LEDS; i++) {
      leds[i] = CRGB(0,0,255);
      FastLED.show();
      delay(25);
      leds[i] = CRGB(0,255,0);
      FastLED.show();
      delay(25);
      leds[i] = CRGB(255,0,0);
      FastLED.show();
      delay(25);
    }
  } else {
    for (int i = 0; i <= NUM_LEDS; i++) {
      leds[i] = CRGB(0,0,127);
      FastLED.show();
      delay(25);
      leds[i] = CRGB(0,127,0);
      FastLED.show();
      delay(25);
      leds[i] = CRGB(127,0,0);
      FastLED.show();
      delay(25);
    }
  }
}
