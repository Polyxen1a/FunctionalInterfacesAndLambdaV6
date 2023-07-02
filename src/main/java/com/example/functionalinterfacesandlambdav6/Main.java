package com.example.functionalinterfacesandlambdav6;

import java.util.Objects;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static boolean verification(int num) {
        return check(i -> (i > 0), num);
    }

    private static boolean check(Predicate<Integer> predicate, int num) {
        return predicate.test(num);
    }

    public class Main2 {
        public static void main(String[] args) {
            Consumer<String> greetingConsumer = new Consumer<String>() {
                @Override
                public void accept(String name) {
                    System.out.println("Hello, " + name);
                }
            };

            String name = "Ekaterina";
            greetingConsumer.accept(name);
        }
    }

    public static void main(String[] args) {
        Consumer<String> greetings = x -> System.out.println("Hello, " + x);
        greetings.accept("Ekaterina");
    }

    public class Main3 {
        public static void main(String[] args) {
            Function<Double, Long> roundFunction = new Function<Double, Long>() {
                @Override
                public Long apply(Double number) {
                    return Math.round(number);
                }
            };
            double number = 3.14;
            long roundedNumber = roundFunction.apply(number);
            System.out.println("Округленное число: " + roundedNumber);
        }
    }

    public class Main4 {
        public static void main(String[] args) {
            Function<Double, Long> roundFunction = number -> Math.round(number);
            double number = 3.14;
            long roundedNumber = roundFunction.apply(number);
            System.out.println("Округленное число: " + roundedNumber);
        }
    }

    public class Main5 {
        public static void main(String[] args) {
            Supplier<Integer> randomSupplier = new Supplier<Integer>() {
                @Override
                public Integer get() {
                    Random random = new Random();
                    return random.nextInt(101);
                }
            };
            int randomNumber = randomSupplier.get();
            System.out.println("Случайное число: " + randomNumber);
        }
    }

    public class Main6 {
        public static void main(String[] args) {
            Supplier<Integer> randomSupplier = () -> {
                Random random = new Random();
                return random.nextInt(101);
            };
            int randomNumber = randomSupplier.get();
            System.out.println("Случайное число: " + randomNumber);
        }
    }

    public class Main7 {
        public static <T, U> Function<T, U> ternaryOperator(
                Predicate<? super T> condition,
                Function<? super T, ? extends U> ifTrue,
                Function<? super T, ? extends U> ifFalse) {
            return t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);
        }

        public static void main(String[] args) {
            Predicate<Object> condition = Objects::isNull;
            Function<Object, Integer> ifTrue = obj -> 0;
            Function<CharSequence, Integer> ifFalse = CharSequence::length;
            Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);

            System.out.println(safeStringLength);
        }
    }
}
