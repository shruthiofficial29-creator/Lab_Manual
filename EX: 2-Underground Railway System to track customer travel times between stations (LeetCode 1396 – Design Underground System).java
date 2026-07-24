import java.util.*;

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
