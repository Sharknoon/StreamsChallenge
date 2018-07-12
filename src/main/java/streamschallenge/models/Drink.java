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

/**
 * Alkoholosche Getränke
 */
public enum Drink {
    WODKA(40),
    WINE(11),
    BEER(5),
    RADLER(3);
    
    private int amountAlcohol;
    
    Drink(int amountAlcohol) {
        this.amountAlcohol = amountAlcohol;
    }
    
    /**
     * Gibt zurpck, wieviek Alokol
     * @return
     */
    public int getAmountAlcohol() {
        return amountAlcohol;
    }
}
