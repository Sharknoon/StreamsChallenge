package streamschallenge;

import streamschallenge.models.Car;
import streamschallenge.models.Person;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class StreamsChallenge {
    
    //Hallo und herzlich Willkommen zur Streams-Challenge
    //In diesem Tutorial gehts darum, die Java-8 Stream API besser kennen zu lernen
    //und sie zu verstehen
    //Los gehts!
    
    //**********************************************
    //              Stream Erzeugung
    //**********************************************
    
    /**
     * In Challenge Nr. 1 geht es darum, einen Stream von Strings aus einer Liste zu erzeugen.
     *
     * @param list Die Liste, die zu einem Stream von Strings werden soll
     * @return Der neue Stream aus Strings
     */
    public static Stream<String> challengeOne(List<String> list) {
        Stream<String> ergebnis = null;//TODO
        return ergebnis;
    }
    
    /**
     * In Challenge Nr. 2 geht es darum, einen Stream von Autos aus einem Array zu erzeugen.
     * Tipp, schau dir dir Klasse Arrays und dessen statische Methoden an
     *
     * @param array Das Array, das zu einem Stream von Autos werden soll
     * @return Der neue Stream aus Autos
     */
    public static Stream<Car> challengeTwo(Car[] array) {
        Stream<Car> ergebnis = null;//TODO
        return ergebnis;
    }
    
    /**
     * In Challenge Nr. 3 geht es darum, einen Stream von Integers ohne die Verwendung einer Liste oder einem Array zu
     * erstellen. Erzeuge einen Stream, der die Zahlen 1, 2, und 3 beinhaltet.
     * Tipp, schau dir dir Stream und dessen statische Methoden an
     *
     * @return Der neue Stream aus Integer
     */
    public static Stream<Integer> challengeThree() {
        Stream<Integer> ergebnis = null;//TODO
        return ergebnis;
    }
    
    //**********************************************
    //              Stream Operationen
    //**********************************************
    
    /**
     * In Challenge Nr. 4 geht es darum, zu zählen, wieviele Autos eine Kreuzung kreuzen
     * Tipp: suche nach einer zählenden Funktion in der Klasse Stream
     *
     * @return Die Anzahl der Autos
     */
    public static long challengeFour(Stream<Car> crossingCars) {
        long ergebnis = 0;//TODO
        return ergebnis;
    }
    
    /**
     * In Challenge Nr. 5 geht es darum, zu zählen, wieviele VERSCHIEDENE Autos eine Kreuzung kreuzen
     * Tipp: suche nach einer Funktion, die mit d anfängt ;)
     *
     * @return Die Anzahl der VERSCHIEDENEN Autos
     */
    public static long challengeFive(Stream<Car> crossingCars) {
        long ergebnis = 0;//TODO
        return ergebnis;
    }
    
    /**
     * In Challenge Nr. 6 geht es darum, zu schauen, ob es mindestens ein Auto mit mehr als vier Sitzen gibt
     * Tipp: gehe alle Autos mit der foreach() methode durch
     *
     * @return Ob es mindestens ein Auto mit mehr als vier sitzen gibt
     */
    public static boolean challengeSix(Stream<Car> crossingCars) {
        boolean ergebnis = false;//TODO
        return ergebnis;
    }
    
    /**
     * In Challenge Nr. 7 geht es darum, alle Autos zu filtern, die nicht aufgeschlossen sind
     * Tipp: Schaue dir die Methode filter() an
     *
     * @return Ein Stream aller Autos, die nicht aufgeschlossen sind
     */
    public static Stream<Car> challengeSeven(Stream<Car> crossingCars) {
        Stream<Car> ergebnis = null;//TODO
        return ergebnis;
    }
    
    /**
     * In Challenge Nr. 8 geht es darum, aus einem Stream von Autos, einen Stream von Passagieren pro Auto zu machen
     * Tipp: schaue dir die map() methode an
     *
     * @return Ein Stream aller Passagiere des jeweiligen autos
     */
    public static Stream<Set<Person>> challengeEight(Stream<Car> crossingCars) {
        Stream<Set<Person>> ergebnis = null;//TODO
        return ergebnis;
    }
    
    /**
     * In Challenge Nr. 9 geht es darum, aus einem Stream von Autos, einen Stream ALLER Passagieren, die diese Kreuzung
     * kreuzen zu machen
     * Tipp: schaue dir die flatmap() methode an
     *
     * @return Ein Stream aller Passagiere dieser Kreuzung
     */
    public static Stream<Person> challengeNine(Stream<Car> crossingCars) {
        Stream<Person> ergebnis = null;//TODO
        return ergebnis;
    }
    
    /**
     * In Challenge Nr. 10 geht es darum, zu schauen, ob es mindestens ein Auto gibt, das im ersten Gang über die Kreuzung fährt
     * Tipp: schaue dir die *match() methoden an
     *
     * @return Ob es mindestens ein Auto gibt, das im ersten Gang über die Kreuzung fährt
     */
    public static boolean challengeTen(Stream<Car> crossingCars) {
        boolean ergebnis = false;//TODO
        return ergebnis;
    }
    
    /**
     * In Challenge Nr. 11 geht es darum, zu schauen, ob alle Autos, die über die Kreuzung fahren, aufgeschlossen sind
     * Tipp: schaue dir die *match() methoden an
     *
     * @return Ob alle Autos, die über die Kreuzung fahren, aufgeschlossen sind
     */
    public static boolean challengeEleven(Stream<Car> crossingCars) {
        boolean ergebnis = true;//TODO
        return ergebnis;
    }
    
    /**
     * In Challenge Nr. 12 geht es darum, herauszufinden, was die minimale Anzahl an Sitzen der Autos ist, die diese Kreuzung kreuzen
     * Tipp: nutze die reduce() Methode
     *
     * @return Die minimale Anzahl an Sitzen der Autos, die diese Kreuzung kreuzen
     */
    public static int challengeTwelve(Stream<Car> crossingCars) {
        int ergebnis = -1;//TODO
        return ergebnis;
    }
    
    
    /**
     * In Challenge Nr. 13 geht es darum, wiederum aus einem Stream eine Liste zu bauen.
     * Tipp: schaue dir die Funktion collect() und die Klasse Collectors und dessen statische Methoden an
     *
     * @param stream Der Stream, der wieder zu einer Liste werden soll
     * @return Die neue Liste
     */
    public static List<String> challengeThirteen(Stream<String> stream) {
        List<String> ergebnis = null;//TODO
        return ergebnis;
    }
    
    //**********************************************
    //              Expertenlevel
    //**********************************************
    
    /**
     * In Challenge Nr. 14 geht es darum, herauszufinden, wieviele Fahrer betrunken sind. Benutze keine For-Schleife oder die foeEach() Methode!
     * Tipp: Tja, also Tipps gibts jetzt nicht mehr
     *
     * @return Die Anzahl betrunkener Fahrer
     */
    public static long challengeFourteen(Stream<Car> crossingCars) {
        long ergebnis = -1;//TODO
        return ergebnis;
    }
    
    /**
     * In Challenge Nr. 15 geht es darum, bei allen Autos, deren Fahrer den Vornamen "Brunhilde" hat, einen Gang höher zu schalten. Nutze keine if() Bedingung!
     * Tipp: richtig schwer, da es keine Methode Gang hochschalten gibt (hehehe), Hilfsfunktionen sind erlaubt!
     */
    public static void challengeFifteen(Stream<Car> crossingCars) {
        //TODO
    }
    
    /**
     * In Challenge Nr. 16 geht es darum, den durchschnittlichen Alkoholgehalt aller Personen, deren Auto 4 Sitze hat,
     * aber nur zwei Personen im Auto sitzen, die im vierten Gang fahren, deren Auto offen ist, die ein "e" im Namen
     * Vor oder Nachname) haben und die betrunken sind zurück zu geben
     * Tipp: Muhahaha, das ist das Bosslevel ;-P
     */
    public static double challengeSixteen(Stream<Car> crossingCars) {
        double ergebnis = -1;//TODO
        return ergebnis;
    }
    
}
