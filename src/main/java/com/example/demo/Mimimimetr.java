package com.example.demo;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@Service
public class Mimimimetr {
    private ArrayList<Cat> catList = new ArrayList<>();
    private ArrayList<ArrayList<Cat>> pairs = new ArrayList<>();
    private int currentIndex = 0;

    Mimimimetr(){
        catList.add(new Cat("Кузя", "/images/cat1.jpg"));
        catList.add(new Cat("Муся", "/images/cat2.jpg"));
        catList.add(new Cat("Томас", "/images/cat3.jpg"));
        catList.add(new Cat("Мурка", "/images/cat4.jpg"));
        catList.add(new Cat("Соня", "/images/cat5.jpg"));
        catList.add(new Cat("Филя", "/images/cat6.jpg"));
        catList.add(new Cat("Лев", "/images/cat7.jpg"));
        getPair();
    }
    
    void getPair(){
        Collections.shuffle(catList);
        ArrayList<Cat> catListN = new ArrayList<>(catList);

        for (int i=0;i<catList.size(); i++){
            for (int j=i+1; j<catList.size();j++){
                ArrayList<Cat> pair = new ArrayList<>();
                pair.add(catList.get(i));
                pair.add(catListN.get(j));
                pairs.add(pair);
            }
        }
        Collections.shuffle(pairs);
    }

    void addCat(Cat name){
        catList.add(name);
    }

    ArrayList<Cat> getList(){
        return catList;
    }

    public ArrayList<Cat> getCurrentPair() {
        if (currentIndex >= pairs.size()) {
            return new ArrayList<>();
        }
        return pairs.get(currentIndex);
    }

    public void vote(int choice) {
        if (currentIndex < pairs.size()) {
            Cat chosenCat = pairs.get(currentIndex).get(choice);
            chosenCat.addRate();
            currentIndex++;
        }
    }

    public ArrayList<Cat> getResult() {
        catList.sort(Comparator.comparingInt(Cat::getRate).reversed());

        ArrayList<Cat> result = new ArrayList<>();
        for (int i = 0; i < catList.size(); i++) {
            result.add(catList.get(i));
        }
        return result;
    }

}
