import javax.swing.*;
public class DebugNine2 {
   public static void main(String[] args) {
      Movie[] movies = new Movie[8];
      int i;
      String message, entry;
      movies[0] = new Movie("The Godfather", 1972);
      movies[1] = new Movie("The Good, the Bad, and the Ugly", 1966);
      movies[2] = new Movie("Pulp Fiction", 1994);
      movies[3] = new Movie("Shindler's List", 1993);
      movies[4] = new Movie("Casablanca", 1942);
      movies[5] = new Movie("Wizard of Oz", 1939);
      movies[6] = new Movie("Citizen Kane", 1941);
      movies[7] = new Movie("Some Like It Hot", 1959);

      entry = JOptionPane.showInputDialog(null, "Sort Movies by\n(N)ame, or (Y)ear");
      if(entry.charAt(0) == 'N') {
         nameSort(movies);
         message = "Sorted by Name\n";
      }
      else {
          yearSort(movies);
          message = "Sorted by Year\n";
      }
      display(movies, message);
   }
   public static void nameSort(Movie[] movies){
      int a, b;
      int highSub = movies.length - 1;
      for(a = 0; a < highSub; ++a) {
         for(b = 0; b < highSub; ++b) {
             String first = movies[b].getName();
             String second = movies[b + 1].getName();
             // compareTo returns an int x
             // x > 0 when 'b'.compareTo('a'), x < 0 when 'a'.compareTo('c'), x = 0 when 'a'.compareTo('a')
             if(first.compareTo(second) > 0) {
                Movie movie = movies[b];
                movies[b] = movies[b + 1];
                movies[b + 1] = movie;
             }
         }
      }
    }
   public static void yearSort(Movie[] movies) {
       int a, b;
       Movie movie;
       int highSub = movies.length - 1;
       for (a = 0; a < highSub; ++a) {
          for (b = 0; b < highSub; ++b){
              if (movies[b].getYear() > movies[b + 1].getYear()) {
                  movie = movies[b];
                  movies[b] = movies[b + 1];
                  movies[b + 1] = movie;
              }
          }
        }
     }

   public static void display(Movie[] movies,  String msg) {
       StringBuilder msgBuilder = new StringBuilder(msg);
       for (Movie movie : movies) {
           String info = movie.getName() + ", " + movie.getYear() + "\n";
           msgBuilder.append(info);
       }
       msg = msgBuilder.toString();
       JOptionPane.showMessageDialog(null, msg);
     }
}
