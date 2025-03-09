import java.util.Scanner;

class Train {
    String[] stationName;
    int[] distance;
    String trainName;
    int trainNo;

    public Train(String trainName, int trainNo, String[] stationName, int[] distance) {
        this.stationName = stationName;
        this.distance = distance;
        this.trainName = trainName;
        this.trainNo = trainNo;
    }
}

class CoachDetails {
    char coach;
    int passengers;
    float price;

    public CoachDetails(char coach, int passengers, float price) {
        this.coach = coach;
        this.passengers = passengers;
        this.price = price;
    }
}

public class Irctc_Reservation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Train[] trains = new Train[2];

        System.out.println("Welcome To My IRCTC Website");

        String[] stations1 = { "RAJKOT", "WANKANER", "SURENDRANAGAR", "VIRAMGAM", "AHMEDABAD", "NADIAD", "ANAND",
                "VADODARA", "ANKLESHWAR", "SURAT", "NAVSARI", "VALSAD", "VAPI", "VASAI", "BHIWANDI", "KALYAN",
                "LONAVALA", "PUNE", "DAUND", "SOLAPUR", "KALABURAGI", "WADI", "CHITTAPUR", "SEDAM", "TANDUR",
                "BEGAMPET", "SECUNDERABAD" };
        int[] kms1 = { 0, 42, 116, 181, 246, 292, 310, 344, 424, 474, 503, 542, 568, 689, 716, 731, 806, 869, 947, 1135,
                1248, 1284, 1299, 1322, 1355, 1465, 1470 };
        trains[0] = new Train("RJT SC SUP EXP", 22717, stations1, kms1);

        String[] stations2 = { "JAMNAGAR", "HAPA", "JAM WANTHALI", "RAJKOT", "WANKANER JN", "THAN JN", "SURENDRANAGAR",
                "VIRAMGAM", "AMBLI ROAD", "CHANDLODIYA", "SABARMATI JN", "AHMEDABAD JN", "NADIAD JN", "ANAND JN",
                "VADODARA JN" };
        int[] kms2 = { 0, 9, 30, 82, 123, 150, 198, 262, 311, 317, 322, 328, 373, 392, 426 };
        trains[1] = new Train("INTERCITY EXP", 22960, stations2, kms2);

        System.out.println("Enter From Station: ");
        String fromStation = sc.nextLine().trim();

        System.out.println("Enter To Station: ");
        String toStation = sc.nextLine().trim();

        int fromIndex = -1, toIndex = -1, trainIndex = -1;

        for (int i = 0; i < trains.length; i++) {
            for (int j = 0; j < trains[i].stationName.length; j++) {
                if (trains[i].stationName[j].equalsIgnoreCase(fromStation)) {
                    fromIndex = j;
                }
                if (fromIndex != -1 && trains[i].stationName[j].equalsIgnoreCase(toStation)) {
                    toIndex = j;
                    trainIndex = i;
                    break;
                }
            }
            if (fromIndex >= 0 && toIndex >= 0) {
                System.out.println("Train Found: " + trains[i].trainNo + " " + trains[i].trainName);
                break;
            }
        }

        if (fromIndex == -1 || toIndex == -1) {
            System.out.println("No train found for the given stations.");
            return;
        }

        int s1 = 72, s2 = 72, b1 = 72, a1 = 48, h1 = 24;

        System.out.println("S - Sleeper (SL)\nB - 3 Tier AC (3A)\nA - 2 Tier AC (2A)\nH - 1st class AC (1A)");
        char coach = sc.next().toUpperCase().charAt(0);

        System.out.println("No. of passengers: ");
        int passengers = sc.nextInt();

        switch (coach) {
            case 'S':
                if (s1 >= passengers) {
                    float price = (trains[trainIndex].distance[toIndex] - trains[trainIndex].distance[fromIndex]) * passengers * 1;
                    s1 -= passengers;
                    System.out.println("Booking successful. Total price: " + price);
                    CoachDetails person1 = new CoachDetails('S', passengers, price);
                } else if (s2 >= passengers) {
                    float price = (trains[trainIndex].distance[toIndex] - trains[trainIndex].distance[fromIndex]) * passengers * 1;
                    s2 -= passengers;
                    System.out.println("Booking successful in S2. Total price: " + price);
                    CoachDetails person1 = new CoachDetails('S', passengers, price);
                } else {
                    if (s1 >= 0) {
                        System.out.println(s1 + " available seats in Sleeper class.");
                    } else {
                        System.out.println(s2 + " available seats in Sleeper class.");
                    }
                }
                break;
            case 'B':
                if (b1 >= passengers) {
                    float price = (trains[trainIndex].distance[toIndex] - trains[trainIndex].distance[fromIndex]) * passengers * 2;
                    b1 -= passengers;
                    System.out.println("Booking successful. Total price: " + price);
                    CoachDetails person1 = new CoachDetails('B', passengers, price);
                } else {
                    System.out.println(b1 + " available seats in 3 Tier AC.");
                }
                break;
            case 'A':
                if (a1 >= passengers) {
                    float price = (trains[trainIndex].distance[toIndex] - trains[trainIndex].distance[fromIndex]) * passengers * 3;
                    a1 -= passengers;
                    System.out.println("Booking successful. Total price: " + price);
                    CoachDetails person1 = new CoachDetails('A', passengers, price);
                } else {
                    System.out.println(a1 + " available seats in 2 Tier AC.");
                }
                break;
            case 'H':
                if (h1 >= passengers) {
                    float price = (trains[trainIndex].distance[toIndex] - trains[trainIndex].distance[fromIndex]) * passengers * 4;
                    h1 -= passengers;
                    System.out.println("Booking successful. Total price: " + price);
                    CoachDetails person1=new CoachDetails('H',passengers,price);
                } else {
                    System.out.println(h1+" available seats in 1st class AC.");
                }
                break;
            default:
                System.out.println("Enter a valid coach type.");
                break;
        }
    }
} 
