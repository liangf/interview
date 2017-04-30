import java.util.*;

class Movie {
    int movieId;
    float rating;
    List<Movie> similarMovies;

    public Movie(int movieId, float rating) {
        this.movieId = movieId;
        this.rating = rating;
        similarMovies = new ArrayList<>();
    }
    
    public int getId() {
        return movieId;
    }

    public float getRating() {
        return rating;
    }

    public void addSimilarMovie(Movie movie) {
        similarMovies.add(movie);
        movie.similarMovies.add(this);
    }

    public List<Movie> getSimilarMovies() {
        return similarMovies;
    }
}

class Main{
    public static List<Movie> getMovieRecommendations(Movie movie, int numTopRatedSimilarMovies) {
        TreeSet<Movie> container = new TreeSet<>(Comparator.comparing(m -> new Float(m.getRating())));
        List<Movie> result = new ArrayList<>();
        /* Visit every node and add it to collection */
        traverseMovieNetwork(movie, container);
        // Get required number of movies from collection
        for (; numTopRatedSimilarMovies > 0; numTopRatedSimilarMovies--) {
            result.add(container.pollLast());
        }
        return result;
    }

    /**
     * Traverse the graph
     */
    public static void traverseMovieNetwork(Movie movie, Set<Movie> store) {
        for (Movie m : movie.getSimilarMovies()) {
            if (!store.contains(m)) {
                store.add(m);
                traverseMovieNetwork(m, store);
            }
        }
    }

    /**
     * Traverse the graph with Breadth-first search
     */
    public static void traverseMovieNetworkBFS(Movie movie, Set<Movie> store) {
        Deque<Movie> movieDeque = new ArrayDeque<>();
        store.add(movie);
        movieDeque.add(movie);
        while (!movieDeque.isEmpty()) {
            Movie tmp = movieDeque.pollLast();
            System.out.println("Last movie in deque: " + tmp.getId());
            for (Movie m : tmp.getSimilarMovies()) {
                System.out.println("Child of " + tmp.getId() + " is: " + m.getId());
                if (!store.contains(m)) {
                    store.add(m);
                    movieDeque.add(m);
                    System.out.println(m.getId() + " was added to set and deque");
                }
            }
        }
    }

    /**
     * Test
     */
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

        for (Movie m : getMovieRecommendations(movieA, 1)) {
            System.out.println("Movie id=" + m.getId() + " Rating=" + m.getRating());
        }
    }
}