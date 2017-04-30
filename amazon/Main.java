

import java.util.*;


// class MyComp implements Comparator<Movie> {
//     public int compare(Movie m1, Movie m2) {
//     	return m1.getRating() < m2.getRating() ? 1 : -1;
//     }
     
// }

class Movie implements Comparable<Movie> {
	int movieId;
	float rating;
	List<Movie> similarMovies;

	public Movie(int movieId, float rating) {
		this.movieId = movieId;
		this.rating = rating;
		similarMovies = new ArrayList<>();
	}

	public int getMovieId() {
		return movieId;
	}

	public float getRating() {
		return rating;
	}

	public List<Movie> getSimilarMovies() {
		return similarMovies;
	}

	public void addSimilarMovie(Movie movie) {
		similarMovies.add(movie);
	}

	public boolean equals(Movie other) {
	    if (other == null) return false;
	    if (this == other) return true;
	    return this.movieId == other.movieId;
	}

    public int compareTo(Movie other) {
        if (this.rating == other.rating) {
        	return 0;
        } else if (this.rating > other.rating) {
        	return 1;
        } else {
        	return -1;
        }
    }
}

public class Main {
	public static void main(String[] args) {
        Movie movieA = new Movie(1, 1.2f);
        Movie movieB = new Movie(2, 2.4f);
        Movie movieC = new Movie(3, 3.6f);
        Movie movieD = new Movie(4, 4.8f);

        movieA.addSimilarMovie(movieB);
        movieA.addSimilarMovie(movieC);
        movieB.addSimilarMovie(movieA);
        movieB.addSimilarMovie(movieD);
        movieC.addSimilarMovie(movieA);
        movieC.addSimilarMovie(movieD);
        movieD.addSimilarMovie(movieB);
        movieD.addSimilarMovie(movieC);

	    TreeSet<Movie> set = new TreeSet<Movie>();
	    // TreeSet<Movie> set = new TreeSet<Movie>(new Comparator<Movie>() {
		   //  public int compare(Movie m1, Movie m2) {
		   //  	return m1.getRating() > m2.getRating() ? 1 : -1;
		   //  }
	    // });
	    set.add(movieB);
	    set.add(movieC);
	    set.add(movieA);

	    List<Movie> list = new ArrayList<Movie>();
	    list.add(movieA);
	    list.add(movieB);

	    // for (int i=0; i<list.size(); ++i) {
	    // 	if (!set.contains(list.get(i))) {
	    // 		System.out.println(list.get(i).getMovieId());
	    // 	}
	    // }

	    for (Movie m : set) {
	    	System.out.println(m.movieId + " " + m.getRating());
	    }

	    if (set.contains(movieA)) {
	    	System.out.println("set contains movieA");
	    }

	    System.out.println(movieA.equals(movieB));
	}
}
