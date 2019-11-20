package Laicode.Class18_OOD2;

public class ParkingLot {
	private final Level[] levels;
	ParkingLot(int numLevels, int numSpotsPerLevel) {
		levels = new Level[numLevels];
		for (int i = 0; i < numLevels; i++) {
			levels[i] = new Level(numSpotsPerLevel);
		}
	}

	boolean hasSpot(Vehicle v) {
		for (Level l: levels) {
			if (l.hasSpot(v)) {
				return true;
			}
		}
		return false;
	}

	boolean park(Vehicle v) {
		for (Level l: levels) {
			if (l.park(v)) {
				return true;
			}
		}
		return false;
	}

	boolean leave(Vehicle v) {
		for (Level l: levels) {
			if (l.leave(v)) {
				return true;
			}
		}
		return false;
	}
}
