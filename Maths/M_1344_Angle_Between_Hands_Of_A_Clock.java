class Solution {
    public double angleClock(int hour, int minutes) {
        double angleTillIntHr = ((hour) % 12) * 30.0;
        double angleAfterIntHr = ((minutes / 60.0)) * 30;
        double angleMin = (minutes * 6.0);
        double angleDiff = Math.abs((angleTillIntHr + angleAfterIntHr - angleMin));
        // If the angle between hands is larger than 180, we will consider angle which
        // is less than 180
        if (angleDiff > 180) {
            return (360 - angleDiff);
        }
        return angleDiff;
    }
}