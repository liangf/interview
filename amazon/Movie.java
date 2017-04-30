

import java.util.*;


// class MyComp implements Comparator<Movie> {
//     public int compare(Movie m1, Movie m2) {
//     	return m1.getRating() < m2.getRating() ? 1 : -1;
//     }
     
// }

public class Movie implements Comparable<Movie> {
	private int movieId;
	private float rating;
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


	public static List<Movie> getMovieRecommendations(Movie m, int n) {
		List<Movie> result = new ArrayList<Movie>();

		/* use MyComp class will cause set contas problem?*/
		// TreeSet<Movie> set = new TreeSet<Movie>(new MyComp());
		
		TreeSet<Movie> set = new TreeSet<Movie>();
		dfs(m, set);


		for (int i=0; i<n; ++i) {
			if ( !set.isEmpty() ) {
				result.add(set.pollLast());
			}
		}
		return result;
	}

	public static void dfs(Movie m, TreeSet<Movie> set) {
		for (int i=0; i<m.getSimilarMovies().size(); ++i) {
			if ( !set.contains(m.getSimilarMovies().get(i)) ) {
				set.add(m.getSimilarMovies().get(i));
				dfs(m.getSimilarMovies().get(i), set);
			}
		}
	}

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

        for (Movie m : getMovieRecommendations(movieA, 5)) {
            System.out.println("Movie id=" + m.getMovieId() + " Rating=" + m.getRating());
        }	 
	}
}

