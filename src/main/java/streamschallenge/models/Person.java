package streamschallenge.models;/*
 * Copyright 2018 Shark Industries.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Diese Klasse stellt eine Person wie du und ich dar
 */
public class Person {
    //Vorname der Person
    final String firstName;
    //Nachname der Peron
    final String lastName;
    //Der Drink der Person
    Drink drinkInt;
    //Ein interner Timer, man ist ja nicht für immer betrunken
    private Timer drunkTimer = new Timer();
    
    /**
     * Gebährt eine neue Person
     *
     * @param firstName Der Vorname der Person
     * @param lastName  Der Nachname der Person
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    /**
     * Gibt den Vornamen zurück
     *
     * @return den Vornamen
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     * Gibt den Nachnamen zurück
     *
     * @return den Nachnamen
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Lässt die Person einen Drink trinken
     *
     * @param drink Der zu trinkende Drink
     */
    public void drink(Drink drink) {
        this.drinkInt = drink;
        
        drunkTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                drinkInt = null;
            }
        }, drink.getAmountAlcohol() * 1000/*Baut jede Sekunde ein Prozent ab*/);
    }
    
    /**
     * Gibt zurück, ob die Person betrunken ist
     *
     * @return Ob die Person betrunken ist
     */
    public boolean isDrunk() {
        return drinkInt != null;
    }
    
    /**
     * Gibt den Drink, falls die Person einen getrunken hat, zurück
     *
     * @return den Drink, falls die Person einen getrunken hat
     */
    public Optional<Drink> getDrink() {
        return Optional.ofNullable(drinkInt);
    }
}
