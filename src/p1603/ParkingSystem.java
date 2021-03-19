package p1603;

class ParkingSystem {
    
    private int[] room = new int[4];
    
    private static final int TYPE_BIG = 1;
    private static final int TYPE_MEDIUM = 2;
    private static final int TYPE_SMALL = 3;

    public ParkingSystem(int big, int medium, int small) {
        room[TYPE_BIG] = big;
        room[TYPE_MEDIUM] = medium;
        room[TYPE_SMALL] = small;
    }
    
    public boolean addCar(int carType) {
        if(room[carType] > 0) {
            room[carType] --;
            return true;
        }
        return false;
    }
}
