package edu.hw2.Task1;

/**
 * Напишите иерархию классов для вычисления математических выражений.
 * <p>
 * public sealed interface Expr {
 * double evaluate();
 * <p>
 * public record Constant implements Expr {}
 * public record Negate implements Expr {}
 * public record Exponent implements Expr {}
 * public record Addition implements Expr {}
 * public record Multiplication implements Expr {}
 * }
 * Также напишете тесты для нее
 */
public sealed interface Expr {
    double evaluate();

    record Constant(double number) implements Expr {
        @Override public double evaluate() {
            return number;
        }
    }

    record Negate(Expr number) implements Expr {
        @Override
        public double evaluate() {
            return number.evaluate() * (-1);
        }
    }

    record Exponent(Expr number, double power) implements Expr {
        @Override
        public double evaluate() {
            return Math.pow(number.evaluate(), power);
        }
    }

    record Addition(Expr number1, Expr number2) implements Expr {
        @Override
        public double evaluate() {
            return number1.evaluate() + number2.evaluate();
        }
    }

    record Multiplication(Expr number1, Expr number2) implements Expr {
        @Override
        public double evaluate() {
            return number1.evaluate() * number2.evaluate();
        }
    }

}
