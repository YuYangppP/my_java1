package java8.my_3;


import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.IntStream;

import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;
import static java.util.stream.Collectors.partitioningBy;

/**
 * @author:yuyang
 * @data:2019-05-31 16:40
 **/
public class PrimeNumbersCollector implements Collector<Integer, Map<Boolean,List<Integer>>, Map<Boolean,List<Integer>>> {

    public Supplier<Map<Boolean,List<Integer>>> supplier(){
        return () -> new HashMap<Boolean,List<Integer>>(){{
            put(true,new ArrayList<Integer>());
            put(false,new ArrayList<Integer>());
        }};
    }

    public BiConsumer<Map<Boolean,List<Integer>>,Integer> accumulator(){
        return (Map<Boolean,List<Integer>> acc,Integer candidate) -> {
            acc.get( isPrime(acc.get(true),candidate )).add(candidate);
        };

    }

    public BinaryOperator<Map<Boolean,List<Integer>>> combiner(){
        return (Map<Boolean,List<Integer>> map1,Map<Boolean,List<Integer>> map2) -> {
            map1.get(true).addAll(map2.get(true));
            map1.get(false).addAll(map2.get(false));
            return map1;
        };
    }

    public Function<Map<Boolean,List<Integer>>,Map<Boolean,List<Integer>>> finisher(){
        return Function.identity();
    }

    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH));
    }

    public static Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(new PrimeNumbersCollector());
    }
    public static <A> List<A> takeWhile(List<A> list, Predicate <A> p){
        int i = 0;
        for(A item : list){
            if(!p.test(item)){
                return list.subList(0,i );
            }
            i++;
        }
        return list;
    }

    public static boolean isPrime (List<Integer> primes, int candidate){
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return takeWhile(primes,i -> i <= candidateRoot ).stream().noneMatch(p -> candidate % p == 0);
    }


    public static void main(String[] args) {
                long fastest = Long.MAX_VALUE;
                for (int i = 0; i < 10; i++) {
                    long start = System.nanoTime();
                    partitionPrimesWithCustomCollector(1_000_000);
                    long duration = (System.nanoTime() - start) / 1_000_000;
                    if (duration < fastest) fastest = duration;
                }
                System.out.println(
                        "Fastest execution done in " + fastest + " msecs");


    }
}
