class CountSquares {

    Map<Integer, Map<Integer, Integer>> map;

    public CountSquares() {
        map = new HashMap<>();
    }
    
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        map.putIfAbsent(x, new HashMap<>());
        Map<Integer, Integer> yMap = map.get(x);
        yMap.put(y, yMap.getOrDefault(y, 0) + 1);
    }
    
    public int count(int[] point) {
        int x = point[0];
        int y = point[1];

        if (!map.containsKey(x)) return 0;

        int res = 0;
        Map<Integer, Integer> yMap = map.get(x);

        // iterate vertical points
        for (int ny : yMap.keySet()) {
            if (ny == y) continue;

            int side = ny - y;

            // check right side square
            int x2 = x + side;
            if (map.containsKey(x2)) {
                int count1 = map.get(x2).getOrDefault(y, 0);
                int count2 = map.get(x2).getOrDefault(ny, 0);
                res += yMap.get(ny) * count1 * count2;
            }

            // check left side square
            x2 = x - side;
            if (map.containsKey(x2)) {
                int count1 = map.get(x2).getOrDefault(y, 0);
                int count2 = map.get(x2).getOrDefault(ny, 0);
                res += yMap.get(ny) * count1 * count2;
            }
        }

        return res;
    }
}
