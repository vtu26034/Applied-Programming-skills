 class UndergroundSystem {
    Map<Integer, Pair<String, Integer>> checkInMap;
    Map<String, Pair<Integer, Integer>> routeMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> entry = checkInMap.get(id);
        checkInMap.remove(id);

        String route = entry.getKey() + "->" + stationName;
        int travelTime = t - entry.getValue();

        routeMap.putIfAbsent(route, new Pair<>(0, 0));
        Pair<Integer, Integer> stats = routeMap.get(route);

        routeMap.put(route, new Pair<>(
            stats.getKey() + travelTime,
            stats.getValue() + 1
        ));
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "->" + endStation;
        Pair<Integer, Integer> stats = routeMap.get(route);
        return (double) stats.getKey() / stats.getValue();
    }
}