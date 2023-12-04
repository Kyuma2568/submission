import org.example.PremiumCal;
import org.example.BreakDownCover;
import org.example.ParkingLocation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.Assert.assertEquals;

public class PremiumCalTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/Car.csv")
    void TestPremium(BreakDownCover breakdownCover, boolean windscreenRepair, int accidents, int mileage, double estimatedValue, ParkingLocation parkingLocation, int actualResutl){
        PremiumCal i = new PremiumCal();

        assertEquals(i.calculatePremium(breakdownCover, windscreenRepair, accidents, mileage, estimatedValue, parkingLocation), actualResutl,1);
    }
}
