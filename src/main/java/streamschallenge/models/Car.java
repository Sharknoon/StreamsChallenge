package streamschallenge.models;


import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Car {
    
    //Die Anzahl der Sitze
    final int amountOfSeats;
    //Der Schlüssel für das Auto
    final int key;
    //Ob das Auto zu- oder aufgeschlossen ist
    boolean locked = true;
    //Der Gang, der gerade eingelegt ist
    Gear gear = Gear.FIRST;
    //Die Person, die gerade das Auto fährt
    Person drivingPerson;
    //Ein Set aller Personen im Auto
    Set<Person> passengers = new HashSet<>();
    
    /**
     * Erzeugt ein nagelneues Auto, frisch aus der Fabrik
     *
     * @param amountOfSeats Wie viele Sitze das Auto hat, muss zwischen 1 (inklusive) und 9 (inklusive) liegen
     * @param key           Der Schlüssel für dieses Auto, eine beliebige geheime Zahl
     */
    public Car(int amountOfSeats, int key) {
        assert amountOfSeats >= 1 && amountOfSeats <= 9;
        this.amountOfSeats = amountOfSeats;
        this.key = key;
    }
    
    /**
     * Gibt die Anzahl der Sitze zurück
     *
     * @return Die Anzahl der Sitze
     */
    public int getAmountOfSeats() {
        return amountOfSeats;
    }
    
    /**
     * Gibt den Fahrer zurück
     * @return Gibt ein Optional einer Person zurück, da dieses Auto ja auch kein Fahrer haben kann
     */
    public Optional<Person> getDrivingPerson() {
        return Optional.ofNullable(drivingPerson);
    }
    
    /**
     * Gibt die Passagiere zurück
     * @return Alle Passagiere, auch der Fahrer dieses Autos
     */
    public Set<Person> getPassengers() {
        return passengers;
    }
    
    /**
     * Ändert den Gang dieses Autos
     *
     * @param newGear den neuen Gang
     * @return gibt den vorherigen Gang zurück
     */
    public Gear switchGears(Gear newGear) {
        Gear prevGear = gear;
        gear = newGear;
        return prevGear;
    }
    
    /**
     * Gibt den aktuellen Gang zurück
     *
     * @return Den aktuellen Gang
     */
    public Gear getGear() {
        return gear;
    }
    
    /**
     * Gibt zurück, ob dieses Auto gesperrt ist oder nicht
     *
     * @return Ob das Auto zugeschlossen ist oder nicht
     */
    public boolean isLocked() {
        return locked;
    }
    
    /**
     * Öffnet das Auto
     *
     * @param key Der dazugehörige Schlüssel
     * @throws WrongKeyException Falls der Schlüssel nicht passt
     */
    public void openCar(int key) throws WrongKeyException {
        if (this.key == key) {
            locked = false;
        } else {
            throw new WrongKeyException();
        }
    }
    
    /**
     * Schließt das Auto
     *
     * @param key Der dazugehörige Schlüssel
     * @throws WrongKeyException Falls der Schlüssel nicht passt
     */
    public void lockCar(int key) throws WrongKeyException {
        if (this.key == key) {
            locked = true;
        } else {
            throw new WrongKeyException();
        }
    }
    
    /**
     * Eine Person steigt in das Auto
     *
     * @param person   Die Person, die in das Auto steigt
     * @param asDriver Ob die Person ein Fahrer ist oder nicht
     * @throws CarIsLockedException        Falls das Auto zugeschlossen ist und die Person nicht einsteigen kann
     * @throws CarOutOfSeatsException      Falls das Auto keine freien Sitze mehr hat
     * @throws DriverAlreadyInCarException Falls die Person als Fahrer einsteigt, es aber bereits einen Fahrer gibt und
     *                                     die Person nicht auf dessen Schoß sitzen möchte
     */
    public void enterCar(Person person, boolean asDriver) throws CarIsLockedException, CarOutOfSeatsException, DriverAlreadyInCarException {
        if (isLocked()) {
            throw new CarIsLockedException();
        }
        if (passengers.size() >= amountOfSeats && !passengers.contains(person)) {
            throw new CarOutOfSeatsException();
        }
        if (asDriver && drivingPerson != null) {
            throw new DriverAlreadyInCarException();
        }
        passengers.add(person);
        if (asDriver) {
            drivingPerson = person;
        }
    }
    
    /**
     * Eine Person verlässt das Auto
     *
     * @param person Die Person, die das Auto verlässt
     * @throws PersonNotInTheCarException Falls die Person nicht im Auto ist
     */
    public void leaveCar(Person person) throws PersonNotInTheCarException {
        if (passengers.contains(person)) {
            passengers.remove(person);
        } else {
            throw new PersonNotInTheCarException();
        }
        if (drivingPerson == person) {
            drivingPerson = null;
        }
    }
    
    /**
     * Eine Auflistung aller Gänge, die ein Auto haben kann
     */
    public enum Gear {
        REVERSE,
        NEUTRAL,
        FIRST,
        SECOND,
        THIRD,
        FOURTH,
        FIFTH,
        SIXTH
    }
    
    public class CarIsLockedException extends Exception {
        public CarIsLockedException() {
            super("Dieses Auto ist noch zugeschlossen!");
        }
    }
    
    public class CarOutOfSeatsException extends Exception {
        public CarOutOfSeatsException() {
            super("Dieses Auto hat keine freien Sitze mehr!");
        }
    }
    
    public class DriverAlreadyInCarException extends Exception {
        public DriverAlreadyInCarException() {
            super("Es sitzt bereits ein Fahrer am Steuer!");
        }
    }
    
    public class WrongKeyException extends Exception {
        public WrongKeyException() {
            super("Dieser Schlüssel passt nicht zu diesem Auto!");
        }
    }
    
    public class PersonNotInTheCarException extends Exception {
        public PersonNotInTheCarException() {
            super("Diese Person ist nicht in diesem Auto!");
        }
    }
}
