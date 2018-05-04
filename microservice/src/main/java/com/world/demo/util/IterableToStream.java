package com.world.demo.util;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;


public final class IterableToStream
{
    public static <T> Stream<T> convert( Iterable<T> iterable )
    {
        return StreamSupport.stream( iterable.spliterator(), false );
    }
}
