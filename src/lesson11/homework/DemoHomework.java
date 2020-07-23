package lesson11.homework;

import java.util.Arrays;
import java.util.Date;

public class DemoHomework {
    public static void main(String[] args) {
        Room[] emptyRoomArray = new Room[5];

        //GoogleAPI Test
        Room room1 = new Room(881, 100, 9, new Date(), "Hotel", "City");
        Room room2 = new Room(222, 100, 2, new Date(), "Hotel", "City");
        Room room3 = new Room(311, 100, 2, new Date(), "Hotel", "City");
        Room room4 = new Room(474, 100, 2, new Date(), "Hotel", "Hotel");
        Room room5 = new Room(5357, 1900, 2, new Date(), "Hotel", "City");

        Room[] googleAPIRooms = new Room[]{room1, room2, room3, room4, room5};

        GoogleAPI googleAPI = new GoogleAPI(googleAPIRooms);
        GoogleAPI emptyGoogleAPI = new GoogleAPI(emptyRoomArray);


        Room room11 = new Room(1, 100, 6, new Date(), "Hotel", "City");
        Room room22 = new Room(45, 100, 2, new Date(), "Hotel", "City");
        Room room33 = new Room(553, 100, 2, new Date(), "Hotel", "City");
        Room room44 = new Room(664, 100, 3, new Date(), "Hotel", "City");
        Room room55 = new Room(85, 100, 4, new Date(), "Hotel", "City");

        Room[] TripAdvisorAPIRooms = new Room[]{room11, room22, room33, room44, room55};

        TripAdvisorAPI tripAdvisorAPI = new TripAdvisorAPI(TripAdvisorAPIRooms);
        TripAdvisorAPI emptyTripAdvisorAPI = new TripAdvisorAPI(emptyRoomArray);


        printDivider();
        System.out.println("API Test");
        printDivider();

        API[] apis = new API[]{googleAPI, emptyTripAdvisorAPI, tripAdvisorAPI};
        Controller controller = new Controller(apis);
        System.out.println(Arrays.toString(controller.requestRooms(100, 2, "City", "Hotel")));


    }


    private static void printDivider() {
        for (int i = 0; i < 50; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}