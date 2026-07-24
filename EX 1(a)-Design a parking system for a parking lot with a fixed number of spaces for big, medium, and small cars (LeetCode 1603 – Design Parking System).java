import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);

        boolean[] results = new boolean[4];
        results[0] = parkingSystem.addCar(1);
        results[1] = parkingSystem.addCar(2);
        results[2] = parkingSystem.addCar(3);
        results[3] = parkingSystem.addCar(1);

        System.out.println(Arrays.toString(results));
    }
}

class ParkingSystem {
    private int[] count;

    public ParkingSystem(int big, int medium, int small) {
        count = new int[]{0, big, medium, small};
    }

    public boolean addCar(int carType) {
        return count[carType]-- > 0;
    }
}
