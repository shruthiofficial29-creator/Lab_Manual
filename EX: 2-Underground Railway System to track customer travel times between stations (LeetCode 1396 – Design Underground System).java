import java.util.*;

public class Main {
    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        List<Object> output = new ArrayList<>();
        output.add(null);
        undergroundSystem.checkIn(45, "Leyton", 3);
        output.add(null);
        undergroundSystem.checkIn(32, "Paradise", 8);
        output.add(null);
        undergroundSystem.checkIn(27, "Leyton", 10);
        output.add(null);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        output.add(null);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        output.add(null);
        undergroundSystem.checkOut(32, "Cambridge", 22);
        output.add(null);
        output.add(undergroundSystem.getAverageTime("Paradise", "Cambridge")); // 14.0
        output.add(undergroundSystem.getAverageTime("Leyton", "Waterloo"));     // 11.0
        undergroundSystem.checkIn(10, "Leyton", 24);
        output.add(null);
        output.add(undergroundSystem.getAverageTime("Leyton", "Waterloo"));     // 11.0
        undergroundSystem.checkOut(10, "Waterloo", 38);
        output.add(null);
        output.add(undergroundSystem.getAverageTime("Leyton", "Waterloo"));     // 12.0
        System.out.println(output);
    }
}
class UndergroundSystem {
    record CheckIn(String station, int time) {}
    private Map<Integer, CheckIn> checkIns = new HashMap<>();
    private Map<String, double[]> routes = new HashMap<>();
    public UndergroundSystem() {}
    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckIn(stationName, t));
    }
    public void checkOut(int id, String stationName, int t) {
        CheckIn in = checkIns.remove(id);
        double[] r = routes.computeIfAbsent(in.station() + "->" + stationName, k -> new double[2]);
        r[0] += t - in.time();
        r[1]++;
    }
    public double getAverageTime(String startStation, String endStation) {
        double[] r = routes.get(startStation + "->" + endStation);
        return r[0] / r[1];
    }
}
