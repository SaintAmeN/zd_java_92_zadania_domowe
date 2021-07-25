package com.sda.z92.zad_dom_24_7.zad8_klasy;

import java.util.*;
import java.util.stream.Collectors;

public class Dziennik {
    private List<Student> studentList = new ArrayList<>();

    // posiadać metodę 'dodajStudenta(Student):void' do dodawania
    //nowego studenta do dziennika
    public void dodajStudenta(Student dodawanyStudent) {
        studentList.add(dodawanyStudent);
    }

    // posiadać metodę 'usuńStudenta(Student):void' do usuwania studenta
    public void usunStudenta(Student usuwanyStudent) {
        studentList.remove(usuwanyStudent);
    }

    // posiadać metodę 'usuńStudenta(String):void' do usuwania
    // studenta po jego numerze indexu
    public void usunStudenta(String studentIndex) {
        for (Student student : studentList) {
            if (student.getIndeks().equals(studentIndex)) {
                studentList.remove(student);

                // concurrent modification exception nie wystąpi jeśli zrobimy break
                break;
            }
        }
    }

    //posiadać metodę 'zwróćStudenta(String):Student' która jako
    //parametr przyjmuje numer indexu studenta, a w wyniku zwraca
    //konkretnego studenta.
    public Optional<Student> zwrocStudenta(String studentIndex) {
        for (Student student : studentList) {
            if (student.getIndeks().equals(studentIndex)) {
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }

    // posiadać metodę 'podajŚredniąStudenta(String):double' która
    //przyjmuje indeks studenta i zwraca średnią ocen studenta.
    public Double podajSredniaStudenta(String index) throws BrakOcenStudentaException {
        Optional<Student> studentOptional = zwrocStudenta(index);
        if (studentOptional.isPresent()) {
            //.... liczymy średnią
            Student student = studentOptional.get();
            return student.obliczSredniaOcen();
        }
        throw new StudentNieIstniejeException();
    }

    // posiadać metodę
    //'podajStudentówZagrożonych():List<Student>'
    public Set<Student> podajStudentowZagrozonych() {
//        Set<Student> zagrozeni = new HashSet<>();
//        for (Student student : studentList) {
//            try {
//                if (student.obliczSredniaOcen() < 2.5) {
//                    zagrozeni.add(student);
//                }
//            } catch (BrakOcenStudentaException bose) {
//                System.out.println("Student nie posiada ocen!");
//            }
//        }
        Set<Student> set = studentList.stream().filter(student -> !student.getOceny().isEmpty())
                .filter(student -> {
                    try {
                        return student.obliczSredniaOcen() < 2.5;
                    } catch (BrakOcenStudentaException e) {
                        System.out.println("Student nie posiada ocen!");
                        return false;
                    }
                })
                .collect(Collectors.toSet());
        return set;
    }

    //posiadać metodę
    //'posortujStudentówPoIndeksie():List<Student>' - która sortuje listę
    //studentów po numerach indeksów, a następnie zwraca
    //posortowaną listę.
    public List<Student> sortujPoIndeksie(){
        return studentList.stream()
                .sorted(Comparator.comparingLong(o -> Long.parseLong(o.getIndeks())))
                .collect(Collectors.toList());
    }

    // posiadać metodę ‘dodajOcene(String, Double):void’
    public void dodajOcene(String indeks, double ocena){
        Optional<Student> studentOptional = zwrocStudenta(indeks);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.getOceny().add(ocena);
            System.out.println("Dodano ocene.");
        }else{
            System.out.println("Taki student nie istnieje.");
        }
    }
}
