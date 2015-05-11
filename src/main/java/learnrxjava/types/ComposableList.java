package learnrxjava.types;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public interface ComposableList<T> extends Iterable<T> {

    <R> ComposableList<R> map(Function<T, R> projectionFunction);

    ComposableList<T> filter(Predicate<T> predicateFunction);

    <R> ComposableList<R> concatMap(Function<T, ComposableList<R>> projectionFunctionThatReturnsList);

    ComposableList<T> reduce(BiFunction<T, T, T> combiner);

    <R> ComposableList<R> reduce(R initialValue, BiFunction<R, T, R> combiner);

//    <T0,T1,R> ComposableList<R> zip(ComposableList<T0> left, ComposableList<T1> right, BiFunction<T0, T1, R> combiner);

    int size();

    void forEach(Consumer<? super T> action);

    T get(int index);
}
