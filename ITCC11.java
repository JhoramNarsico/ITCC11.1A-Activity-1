class Movie {
    private String title;
    private String genre;
    private int releaseYear;

    public Movie(String title, String genre, int releaseYear) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    @Override
    public String toString() {
        return title + " (" + releaseYear + ") - " + genre;
    }
}

public class ITCC11 {
    private static Movie[] movies = {
        new Movie("Inception", "Sci-Fi", 2010),
        new Movie("The Dark Knight", "Action", 2008),
        new Movie("Interstellar", "Sci-Fi", 2014),
        new Movie("The Matrix", "Sci-Fi", 1999),
        new Movie("Pulp Fiction", "Crime", 1994)
    };

    public static void main(String[] args) {
       
        int choice = 1; // 
        String searchTerm = "Inception"; // 

        if (choice == 1) {
            browseMovies();
        } else if (choice == 2) {
            searchMovies(searchTerm);
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static void browseMovies() {
        System.out.println("\nAvailable Movies:");
        for (int i = 0; i < movies.length; i++) {
            System.out.println((i + 1) + ". " + movies[i]);
        }

    
        int selection = 2; 
        if (selection >= 1 && selection <= movies.length) {
            System.out.println("Now playing: " + movies[selection - 1].getTitle());
        } else {
            System.out.println("Invalid selection.");
        }
    }
    private static void searchMovies(String searchTerm) {
        System.out.println("\nSearching for: " + searchTerm);
        boolean found = false;

        for (Movie movie : movies) {
            if (movie.getTitle().toLowerCase().contains(searchTerm.toLowerCase())) {
                System.out.println("Found: " + movie);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No movies found with that title.");
        }
    }
}