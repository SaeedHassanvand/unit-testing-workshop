package ir.ac.tick.soft.source.write.testable.code;

import java.time.ZonedDateTime;

public class SmartHomeController {
    private int lastMotionHour;

    public int getLastMotionHour() {
        return lastMotionHour;
    }

    public void setLastMotionHour(int lastMotionHour) {
        this.lastMotionHour = lastMotionHour;
    }

    public void actuateLights(boolean motionDetected) {
        // Ouch! We have the same kind of hidden DateTime.
        // Now input problem — the only difference is that
        // it is located on a little bit higher of an abstraction level.

        int hour = ZonedDateTime.now().getHour();
        // Update the time of last motion.
        if (motionDetected) {
            lastMotionHour = hour;
        }

        // If motion was detected in the evening or at night, turn the light on.
        //TODO: use correct methods
        String timeOfDay = TimeUtil.getTimeOfDay();
        if (motionDetected && (timeOfDay.equals("Evening") || timeOfDay.equals("Night"))) {
            BackyardLightSwitcher.turnOn();
        }
        // If no motion is detected for one minute, or if it is morning or day, turn the light off.
        else if (hour - lastMotionHour > 1 || (timeOfDay.equals("Morning") || timeOfDay.equals("Noon"))) {
            BackyardLightSwitcher.turnOff();
        }
    }
}