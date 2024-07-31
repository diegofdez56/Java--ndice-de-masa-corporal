package dev.diego;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BMICalculatorTest {

    @Test
    public void testCalculateBMI() {
        double bmi = BMICalculator.calculateBMI(70, 1.75);
        assertEquals(22.86, bmi, 0.01);
    }

    @Test
    public void testCalculateBMIWithInvalidArguments() {
        // Test with negative weight
        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, () -> {
            BMICalculator.calculateBMI(-70, 1.75);
        });
        assertEquals("Weight and height must be greater than zero.", exception1.getMessage());

        // Test with negative height
        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> {
            BMICalculator.calculateBMI(70, -1.75);
        });
        assertEquals("Weight and height must be greater than zero.", exception2.getMessage());

        // Test with zero weight
        IllegalArgumentException exception3 = assertThrows(IllegalArgumentException.class, () -> {
            BMICalculator.calculateBMI(0, 1.75);
        });
        assertEquals("Weight and height must be greater than zero.", exception3.getMessage());

        // Test with zero height
        IllegalArgumentException exception4 = assertThrows(IllegalArgumentException.class, () -> {
            BMICalculator.calculateBMI(70, 0);
        });
        assertEquals("Weight and height must be greater than zero.", exception4.getMessage());
    }

    @Test
    public void testClassifyBMI() {
        assertEquals("Severe Thinness", BMICalculator.classifyBMI(15));
        assertEquals("Moderate Thinness", BMICalculator.classifyBMI(16.5));
        assertEquals("Mild Thinness", BMICalculator.classifyBMI(18));
        assertEquals("Normal", BMICalculator.classifyBMI(22));
        assertEquals("Overweight", BMICalculator.classifyBMI(27));
        assertEquals("Obese Class I", BMICalculator.classifyBMI(32));
        assertEquals("Obese Class II", BMICalculator.classifyBMI(37));
        assertEquals("Obese Class III", BMICalculator.classifyBMI(41));
    }
}
