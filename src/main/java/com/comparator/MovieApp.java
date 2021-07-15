package com.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * Unlike Comparable, Comparator is external to the element type we are comparing. (Separate Class)
 */

class Movie implements Comparable<Movie>{

	private double rating;
    private String name;
    private int year;
    
	@Override
	public int compareTo(Movie movie) {
		return this.year - movie.year;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Movie(String name, double rating,  int year) {
		this.rating = rating;
		this.name = name;
		this.year = year;
	}

}

class NameComparator implements Comparator<Movie>{

	@Override
	public int compare(Movie o1, Movie o2) {
		return o1.getName().compareTo(o2.getName());
	}
	
}

public class MovieApp {
	public static void main(String[] args) {
		ArrayList<Movie> list = new ArrayList<Movie>();
        list.add(new Movie("Force Awakens", 8.3, 2015));
        list.add(new Movie("Star Wars", 8.7, 1977));
        list.add(new Movie("Empire Strikes Back", 8.8, 1980));
        list.add(new Movie("Return of the Jedi", 8.4, 1983));
 
        list.stream().forEach((movie) ->{
        	System.out.println(movie.getName() + " "+movie.getRating() + " "+movie.getYear());
        });
        Collections.sort(list);
        System.out.println("--------------------------------");
        System.out.println("Movies after comparable sorting : ");
        list.stream().forEach((movie) ->{
        	System.out.println(movie.getName() + " "+movie.getRating() + " "+movie.getYear());
        });
        
        Collections.sort(list, new NameComparator());
        
        System.out.println("--------------------------------");
        System.out.println("Movies after Name Comparator sorting : ");
        list.stream().forEach((movie) ->{
        	System.out.println(movie.getName() + " "+movie.getRating() + " "+movie.getYear());
        });
	}
}
