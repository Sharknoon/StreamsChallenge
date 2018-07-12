package streamschallenge;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import streamschallenge.models.Car;
import streamschallenge.models.Car.*;
import streamschallenge.models.Drink;
import streamschallenge.models.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/*
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
class StreamsChallengeTest {
    
    private static Random rand = new Random();
    private static List<Car> cars = new ArrayList<>();
    private static List<String> firstName;
    private static List<String> lastName;
    private static List<Drink> drinks;
    private static Car brunhildeCar;
    
    @BeforeAll
    static void setup() throws WrongKeyException, DriverAlreadyInCarException, CarIsLockedException, CarOutOfSeatsException {
        Car car = new Car(4, 123);
        car.openCar(123);
        car.switchGears(Gear.FIFTH);
        car.getPassengers().addAll(createPassengers(rand.nextInt(car.getAmountOfSeats() - 1) + 1));
        car.enterCar(car.getPassengers().iterator().next(), true);
        Car car1 = new Car(4, 546);
        car1.openCar(546);
        car1.switchGears(Gear.FIRST);
        car1.getPassengers().addAll(createPassengers(rand.nextInt(car1.getAmountOfSeats() - 1) + 1));
        car1.enterCar(car1.getPassengers().iterator().next(), true);
        Car car2 = new Car(4, 546);
        car2.openCar(546);
        car2.switchGears(Gear.REVERSE);//WTF
        car2.getPassengers().addAll(createPassengers(rand.nextInt(car2.getAmountOfSeats() - 1) + 1));
        car2.enterCar(car2.getPassengers().iterator().next(), true);
        Car car3 = new Car(4, 9256);
        car3.openCar(9256);
        car3.getPassengers().addAll(createPassengers(rand.nextInt(car3.getAmountOfSeats() - 1) + 1));
        car3.enterCar(car3.getPassengers().iterator().next(), true);
        Car car4 = new Car(4, 132);
        car4.openCar(132);
        car4.getPassengers().addAll(createPassengers(rand.nextInt(car4.getAmountOfSeats() - 1) + 1));
        car4.enterCar(car4.getPassengers().iterator().next(), true);
        Car car5 = new Car(4, 46);
        car5.openCar(46);
        car5.switchGears(Gear.NEUTRAL);
        car5.getPassengers().addAll(createPassengers(rand.nextInt(car5.getAmountOfSeats() - 1) + 1));
        car5.enterCar(car5.getPassengers().iterator().next(), true);
        Car car6 = new Car(4, 1543);
        car6.openCar(1543);
        car6.switchGears(Gear.SIXTH);
        car6.getPassengers().addAll(createPassengers(rand.nextInt(car6.getAmountOfSeats() - 1) + 1));
        car6.enterCar(car6.getPassengers().iterator().next(), true);
        Car car7 = new Car(4, 586);
        car7.openCar(586);
        car7.switchGears(Gear.SECOND);
        car7.getPassengers().addAll(createPassengers(rand.nextInt(car7.getAmountOfSeats() - 1) + 1));
        car7.enterCar(car7.getPassengers().iterator().next(), true);
        Car car8 = new Car(4, 5436);
        car8.openCar(5436);
        car8.switchGears(Gear.FOURTH);
        car8.getPassengers().addAll(createPassengers(rand.nextInt(car8.getAmountOfSeats() - 1) + 1));
        car8.enterCar(car8.getPassengers().iterator().next(), true);
        Car car9 = new Car(4, 123);
        car9.openCar(123);
        car9.switchGears(Gear.THIRD);
        car9.getPassengers().addAll(createPassengers(rand.nextInt(car9.getAmountOfSeats() - 1) + 1));
        car9.enterCar(car9.getPassengers().iterator().next(), true);
        Car car10 = new Car(4, 86);
        car10.openCar(86);
        car10.getPassengers().addAll(createPassengers(rand.nextInt(car10.getAmountOfSeats() - 1) + 1));
        car10.enterCar(car10.getPassengers().iterator().next(), true);
        Car car11 = new Car(4, 5978);
        car11.openCar(5978);
        car11.switchGears(Gear.SECOND);
        car11.getPassengers().addAll(createPassengers(rand.nextInt(car11.getAmountOfSeats() - 1) + 1));
        car11.enterCar(car11.getPassengers().iterator().next(), true);
        Car car12 = new Car(5, 4568);
        car12.openCar(4568);
        car12.getPassengers().addAll(createPassengers(rand.nextInt(car12.getAmountOfSeats() - 1) + 1));
        car12.enterCar(car12.getPassengers().iterator().next(), true);
        Car car13 = new Car(5, 123);
        car13.openCar(123);
        car13.switchGears(Gear.THIRD);
        car13.getPassengers().addAll(createPassengers(rand.nextInt(car13.getAmountOfSeats() - 1) + 1));
        car13.enterCar(car13.getPassengers().iterator().next(), true);
        Car car14 = new Car(5, 4586);
        car14.openCar(4586);
        car14.getPassengers().addAll(createPassengers(rand.nextInt(car14.getAmountOfSeats() - 1) + 1));
        car14.enterCar(car14.getPassengers().iterator().next(), true);
        Car car15 = new Car(5, 12123123);
        car15.openCar(12123123);
        car15.switchGears(Gear.SECOND);
        car15.getPassengers().addAll(createPassengers(rand.nextInt(car15.getAmountOfSeats() - 1) + 1));
        car15.enterCar(car15.getPassengers().iterator().next(), true);
        Car car16 = new Car(5, 1243);
        car16.openCar(1243);
        car16.switchGears(Gear.THIRD);
        car16.getPassengers().addAll(createPassengers(rand.nextInt(car16.getAmountOfSeats() - 1) + 1));
        car16.enterCar(car16.getPassengers().iterator().next(), true);
        Car car17 = new Car(2, 546);
        car17.openCar(546);
        car17.getPassengers().addAll(createPassengers(rand.nextInt(car17.getAmountOfSeats() - 1) + 1));
        car17.enterCar(car17.getPassengers().iterator().next(), true);
        Car car18 = new Car(2, 375);
        car18.openCar(375);
        car18.switchGears(Gear.FOURTH);
        car18.getPassengers().addAll(createPassengers(rand.nextInt(car18.getAmountOfSeats() - 1) + 1));
        car18.enterCar(car18.getPassengers().iterator().next(), true);
        Car car19 = new Car(2, 546);
        car19.openCar(546);
        car19.switchGears(Gear.THIRD);
        car19.getPassengers().addAll(createPassengers(rand.nextInt(car19.getAmountOfSeats() - 1) + 1));
        car19.enterCar(car19.getPassengers().iterator().next(), true);
        Car car20 = new Car(1, 1324);
        car20.openCar(1324);
        car20.switchGears(Gear.SECOND);
        car20.getPassengers().add(new Person("Brunhilde", "Findme"));
        car20.enterCar(car20.getPassengers().iterator().next(), true);
        brunhildeCar = car20;
        cars.addAll(Arrays.asList(car, car1, car2, car3, car4, car5, car6, car7, car8, car9, car10, car11, car, car1, car2, car3, car4, car12, car13, car14, car15, car16, car17, car18, car19, car20));
        
    }
    
    private static Person createPerson() {
        if (firstName == null) {
            Map<String, String> names = new HashMap<>();
            names.put("Brunhilde", "Meier");
            names.put("Michael", "Müller");
            names.put("Michaela", "Mustermann");
            names.put("Lisa", "Huber");
            names.put("Tom", "Drehlich");
            names.put("Christian", "Koch");
            names.put("Semjon", "Klemm");
            names.put("Angelika", "Stumpf");
            names.put("Christina", "Drost");
            names.put("Dieter", "Burandt");
            names.put("Josua", "Hartung");
            names.put("Manfred", "Kaftan");
            names.put("Leo", "Lemmer");
            names.put("Maria", "Gruber");
            names.put("Tim", "Kida");
            names.put("Berthold", "Singer");
            names.put("Rebecca", "Werz");
            firstName = new ArrayList<>(names.keySet());
            lastName = new ArrayList<>(names.values());
            drinks = new ArrayList<>(EnumSet.allOf(Drink.class));
        }
        Person p = new Person(firstName.get(rand.nextInt(firstName.size())), lastName.get(rand.nextInt(lastName.size())));
        if (rand.nextBoolean()) {
            Drink drink = drinks.get(rand.nextInt(drinks.size()));
            p.drink(drink);
        }
        return p;
    }
    
    private static Set<Person> createPassengers(int amount) {
        Set<Person> passengers = new HashSet<>();
        for (int i = 0; i < amount; i++) {
            passengers.add(createPerson());
        }
        while (passengers.size() < amount) {
            passengers.add(createPerson());
        }
        return passengers;
    }
    
    @Test
    void challengeOne() {
        List<String> strings = List.of("A", "B", "LAAAANGWEILIG", "C");
        Stream<String> stringStream = StreamsChallenge.challengeOne(strings);
        assertNotNull(stringStream);
        boolean equals = stringStream.collect(Collectors.toList()).equals(strings);
        assertTrue(equals, "1: Der Stream entspricht nicht genau der Liste");
    }
    
    @Test
    void challengeTwo() {
        Car[] cars = this.cars.toArray(new Car[0]);
        Stream<Car> carStream = StreamsChallenge.challengeTwo(cars);
        assertNotNull(carStream);
        boolean equals = Arrays.equals(cars, carStream.toArray(Car[]::new));
        assertTrue(equals, "2: Das Array ist nicht korrekt!");
    }
    
    @Test
    void challengeThree() {
        Stream<Integer> integerStream = StreamsChallenge.challengeThree();
        assertNotNull(integerStream);
        List<Integer> list = integerStream.collect(Collectors.toList());
        assertEquals(3, list.size());
        assertEquals(1, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(3, (int) list.get(2));
    }
    
    @Test
    void challengeFour() {
        long count = StreamsChallenge.challengeFour(cars.stream());
        assertEquals(26, count);
    }
    
    @Test
    void challengeFive() {
        long count = StreamsChallenge.challengeFive(cars.stream());
        assertEquals(21, count);
    }
    
    @Test
    void challengeSix() {
        boolean moreThanFourSeats = StreamsChallenge.challengeSix(cars.stream());
        assertTrue(moreThanFourSeats);
    }
    
    @Test
    void challengeSeven() {
        Stream<Car> carStream = StreamsChallenge.challengeSeven(cars.stream());
        assertNotNull(carStream);
        assertEquals(8, carStream.count());
    }
    
    @Test
    void challengeEight() {
        Stream<Set<Person>> personStream = StreamsChallenge.challengeEight(cars.stream());
        assertNotNull(personStream);
        List<Set<Person>> list = personStream.collect(Collectors.toList());
        List<Set<Person>> list1 = cars.stream().map(Car::getPassengers).collect(Collectors.toList());
        boolean equals = list1.equals(list);
        assertTrue(equals);
    }
    
    @Test
    void challengeNine() {
        Stream<Person> personStream = StreamsChallenge.challengeNine(cars.stream());
        assertNotNull(personStream);
        List<Person> list = personStream.collect(Collectors.toList());
        List<Person> list1 = cars.stream().flatMap(c -> c.getPassengers().stream()).collect(Collectors.toList());
        boolean equals = list1.equals(list);
        assertTrue(equals);
    }
    
    @Test
    void challengeTen() {
        boolean b = StreamsChallenge.challengeTen(cars.stream());
        assertTrue(b);
    }
    
    @Test
    void challengeEleven() {
        boolean b = StreamsChallenge.challengeEleven(cars.stream());
        assertFalse(b);
    }
    
    @Test
    void challengeTwelve() {
        int i = StreamsChallenge.challengeTwelve(cars.stream());
        assertEquals(1, i);
    }
    
    @Test
    void challengeThirteen() {
        List<String> list = List.of("bla", "blub", "tralalala");
        List<String> list1 = StreamsChallenge.challengeThirteen(list.stream());
        boolean equals = list.equals(list1);
        assertTrue(equals);
    }
    
    @Test
    void challengeFourteen() {
        long l = StreamsChallenge.challengeFourteen(cars.stream());
        long exp = cars.stream().map(c -> c.getDrivingPerson().orElse(new Person("ERROR", "Error"))).filter(Person::isDrunk).count();
        assertEquals(exp, l);
    }
    
    @Test
    void challengeFifteen() {
        StreamsChallenge.challengeFifteen(cars.stream());
        assertEquals(Gear.THIRD, brunhildeCar.getGear());
    }
    
    @Test
    void challengeSixteen() {
        double erg = StreamsChallenge.challengeSixteen(cars.stream());
        OptionalDouble average = cars.stream()
                .filter(c -> c.getAmountOfSeats() == 4)
                .filter(c -> c.getPassengers().size() == 2)
                .filter(c -> c.getGear() == Gear.FOURTH)
                .filter(c -> !c.isLocked())
                .filter(c -> c.getDrivingPerson().map(p -> p.getFirstName().contains("e") || p.getLastName().contains("e")).orElse(false))
                .filter(c -> c.getDrivingPerson().map(Person::isDrunk).orElse(false))
                .mapToInt(c -> c.getDrivingPerson().map(p -> p.getDrink().map(Drink::getAmountAlcohol).orElse(0)).orElse(0))
                .average();
        double avg = average.orElse(0);
        assertEquals(avg, erg);
    }
}