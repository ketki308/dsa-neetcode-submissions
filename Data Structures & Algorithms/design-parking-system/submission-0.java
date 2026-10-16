class ParkingSystem {
    private int[] remaining;
    public ParkingSystem(int big, int medium, int small) {
        remaining=new int[]{big,medium,small};
    }
    public boolean addCar(int carType) {
        if(remaining[carType-1]==0) return false;
        remaining[carType-1]--;
        return true;
    }
}
