import java.util.Scanner;

// Class to represent a Movie
class Movie {
    private String title;
    private String genre;
    private int releaseYear;

    // Constructor
    public Movie(String title, String genre, int releaseYear) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    // Override toString for easy display
    @Override
    public String toString() {
        return title + " (" + releaseYear + ") - " + genre;
    }
}

// Main Netflix CLI Application
public class NetflixApp {
    private static Movie[] movies = {
        new Movie("Inception", "Sci-Fi", 2010),
        new Movie("The Dark Knight", "Action", 2008),
        new Movie("Interstellar", "Sci-Fi", 2014),
        new Movie("The Matrix", "Sci-Fi", 1999),
        new Movie("Pulp Fiction", "Crime", 1994)
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nWelcome to Netflix CLI!");
            System.out.println("1. Browse Movies");
            System.out.println("2. Search for a Movie");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    browseMovies(scanner);
                    break;
                case 2:
                    searchMovies(scanner);
                    break;
                case 3:
                    running = false;
                    System.out.println("Thank you for using Netflix CLI. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    // Method to browse all movies
    private static void browseMovies(Scanner scanner) {
        System.out.println("\nAvailable Movies:");
        for (int i = 0; i < movies.length; i++) {
            System.out.println((i + 1) + ". " + movies[i]);
        }

        System.out.print("Enter the number of the movie you want to watch: ");
        int selection = scanner.nextInt();
        if (selection >= 1 && selection <= movies.length) {
            System.out.println("Now playing: " + movies[selection - 1].getTitle());
        } else {
            System.out.println("Invalid selection.");
        }
    }

    // Method to search for a movie by title
    private static void searchMovies(Scanner scanner) {
        System.out.print("Enter the title of the movie you're looking for: ");
        String searchTerm = scanner.nextLine().toLowerCase();
        boolean found = false;

        for (Movie movie : movies) {
            if (movie.getTitle().toLowerCase().contains(searchTerm)) {
                System.out.println("Found: " + movie);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No movies found with that title.");
        }
    }
}