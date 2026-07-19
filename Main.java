import java.util.Scanner;

class Main {

    char[][] seats = new char[5][6];
    String[] movieNames = {"Superman", "Avatar", "Minecraft", "Inside Out", "F1"};

    Scanner sc = new Scanner(System.in);

    public void intialSeats() {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[0].length; j++) {
                seats[i][j] = '0';
            }
        }
    }

    public int menu() {
        int choice;

        System.out.println("1. Display Seats");
        System.out.println("2. Book Seat");
        System.out.println("3. Cancel Booking");
        System.out.println("4. Show all movies.");
        System.out.println("5. Show number of available and booked seats");
        System.out.println("0. Exit");

        System.out.print("Enter your choice: ");
        choice = sc.nextInt();

        choice = validateChoice(choice) ? choice : -1;

        return choice;
    }

    public boolean validateChoice(int choice) {
        return (choice < 6 && choice >= 0);
    }

    public void displaySeats() {

        System.out.println("Current Seats: ");

        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[0].length; j++) {

                System.out.print("   " + seats[i][j]);
            }
            System.out.println();
        }
        System.out.println("-------------------------");

    }

    public void bookSeat() {


        System.out.print("Enter the number of seat: ");
        int desireSeat = sc.nextInt();

        int row = desireSeat / 10;
        int col = desireSeat % 10;

        editSeats(row-1, col-1);

    }

    public void editSeats(int row, int col) {

        boolean check = checkAvailability(row, col);

        if (check) {
            seats[row][col] = 'X';
            System.out.println("book done successfully");
        } else if (checkSeat(row, col)) {
            System.out.println("You can't book this seat, Try another one with has no 'X' ");
        } else {
            System.out.println("Invalid Input, Try row within 1 to 5 and col within 1 to 6 ");
        }

    }

    public boolean checkAvailability(int row, int col) {

        return ( checkSeat(row, col) && seats[row][col] != 'X' );
    }

    public boolean checkSeat(int row, int col) {

        return( row >= 0 && row < seats.length) && (col >= 0 && col < seats[0].length);
    }

    public void cancelBooking() {
        System.out.print("Enter the number of seat: ");
        int cancledSeat = sc.nextInt();

        int row = cancledSeat / 10;
        int col = cancledSeat % 10;

        boolean check = checkSeat(row-1, col-1);

        boolean available = checkAvailability(row-1, col-1);

        if (check && available) {
            System.out.println("This seat was not booked yet ");
        } else if (check) {

            seats[row-1][col-1] = '0';
            System.out.println("Canceled done successfully ");
        } else {
            System.out.println("Invalid Input, Try row within 1 to 5 and col within 1 to 6 ");

        }

    }

    public void showMovie() {
        System.out.println("Available Movie:");
        for (int i = 0; i < movieNames.length; i++) {
            System.out.println(i + 1 + ". " + movieNames[i]);
        }
        System.out.println("-------------------------");
    }

    public int availableSeats() {
        int available = 0;

        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[0].length; j++) {
                available += (seats[i][j] != 'X') ? 1 : 0;
            }
        }
        return available;
    }

    public int bookedSeats() {
        int size = seats.length * seats[0].length;

        return size - availableSeats();
    }

    public void showAvailableAndBooked() {
        System.out.println("The number of Available Seats is: " + availableSeats());
        System.out.println("The number of Booked Seats is: " + bookedSeats());
    }


    public boolean isExceeds80(){
        int available = availableSeats();
        int booked = bookedSeats();
        int size = available + booked;
        int exceed = (booked * 100 ) / size;

        return exceed >= 80;
    }

    public void main(String[] args) {
        intialSeats();

        while (true) {

            if(isExceeds80()) {
                System.out.println("---------------");
                System.out.println("Almost Full");
                System.out.println("---------------");

            }
            int choice = menu();

            if (choice == 0) break;

            switch (choice) {

                case 1 -> displaySeats();

                case 2 -> bookSeat();

                case 3 -> cancelBooking();

                case 4 -> showMovie();

                case 5 -> showAvailableAndBooked();

                case -1 -> System.out.println("Invalid Input");

            }
            System.out.println("-------------------");


        }

        System.out.println("Thank you for using our cinema");

    }
}
