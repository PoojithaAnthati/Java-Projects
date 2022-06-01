import java.util.Scanner;

public class Driver {
    private static MusicLibrary app = new MusicLibrary();
    Scanner sc = new Scanner(System.in);

    private static void registerSongs(Scanner sc) {
        System.out.println("------Song Registration-----");
        String addAgain = "N";
        do {
            System.out.println("Enter Song Details");
            try {
                System.out.println("Title: ");
                String title = sc.next();
                System.out.println("Genre: ");
                String genre = sc.next();
                System.out.println("Release Year: ");
                int releaseYear = sc.nextInt();
                System.out.println("Language: ");
                String language = sc.next();
                System.out.println("Please select artist from below");
                app.printArtists();
                int artistId = sc.nextInt();
                app.addSong(artistId, title, genre, releaseYear, language);
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Add another song? (Y/N)");
            addAgain = sc.next();
        }while(addAgain.equals("Y"));
    }

    private static void registerArtists(Scanner sc) {
        System.out.println("------Artist Registration-----");
        String addAgain = "N";
        do {
            System.out.println("Enter Artist Details");
            System.out.println("First Name: ");
            String firstName = sc.next();
            System.out.println("Last Name: ");
            String lastName = sc.next();

            app.registerArtist(firstName, lastName);

            System.out.println("Add another artist? (Y/N)");
            addAgain = sc.next();
        }while(addAgain.equals("Y"));
    }

    private static void registerUsers(Scanner sc) {
        System.out.println("------User Registration-----");
        String addAgain = "N";
        do {
            System.out.println("Enter Uses Details");
            try {
                System.out.println("First Name: ");
                String firstName = sc.next();
                System.out.println("Last Name: ");
                String lastName = sc.next();
                System.out.println("City: ");
                String city = sc.next();
                System.out.println("Locality: ");
                String locality = sc.next();
                System.out.println("State: ");
                String state = sc.next();
                System.out.println("PinCode: ");
                int pinCode = sc.nextInt();
                System.out.println("Email: ");
                String email = sc.next();
                System.out.println("PhoneNUmber: ");
                String phoneNumber = sc.next();

                app.registerUser(firstName, lastName, city, locality, state, pinCode, email, phoneNumber);
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Add another user? (Y/N)");
            addAgain = sc.next();
        }while(addAgain.equals("Y"));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        registerUsers(sc);
        registerArtists(sc);
        registerSongs(sc);

        String addAgain;
        int userId, artistId, songId;

        do {
            try{
                System.out.println("Plesae choose operaiton to perform : " +
                "\n1. Play a song" +
                "\n2. Get Top 10 songs of a user" +
                "\n3. Get trending Top 10" +
                "\n4. Get songs of an artist"
                );
                System.out.println("Enter Your Choice");
                int operationChoice = sc.nextInt();
                switch(operationChoice) {
                    case 1:
                    try {
                        System.out.println("Enter userId:");
                        userId = sc.nextInt();
                        System.out.println("Enter songId:");
                        songId = sc.nextInt();
                        app.playSong(userId, songId);
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                    case 2:
                    try {
                        System.out.println("Enter userId:");
                        userId = sc.nextInt();
                       
                        app.getTop10SongsForUser(userId);
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                    case 3:
                    try { 
                        app.getTop10Songs();
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                    case 4:
                    try {
                        System.out.println("Select artist:"); 
                        app.printArtists();
                        artistId = sc.nextInt();
                        app.getSongByArtist(artistId);
                        break;
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                    default: 
                    System.out.println("Select valid option"); 
                }
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Would you like to perform operation again? (Y/N)");
            addAgain = sc.next();
        }while(addAgain.equals("Y"));
    }
}
