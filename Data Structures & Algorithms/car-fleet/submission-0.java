class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;

        // Create a 2D array to pair position and time to target
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }

        // Sort cars by position in descending order (closest to target first)
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        int fleets = 0;
        double currentMaxTime = 0.0;

        for (int i = 0; i < n; i++) {
            double time = cars[i][1];
            // If this car takes longer than the fleet ahead, it forms a new fleet
            if (time > currentMaxTime) {
                fleets++;
                currentMaxTime = time;
            }
        }

        return fleets;
    }
}