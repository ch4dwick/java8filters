# Java Streams API
> Introduced in Java 8, the Stream API is used to process collections of objects. A stream is a sequence of objects that supports various methods which can be pipelined to produce the desired result.

## Intermediate Operations:
Intermediate operations create a new stream preparing that operation’s logic for traversal. Intermediate operations do no start traversal until a
terminal operation is called.

map(Function) - used to transform the input argument to a return type defined in the Function implementation.

filter(Predicate) - executes a Predicate function defined by a developer to match certain elements in the stream. If an element matches the
conditions defined in the predicate, the predicate returns true and that element is passed on to the next intermediate operations.

sorted() / sorted(Comparator) - sorts the stream by natural order. If not comparable, a custom Comparator method may be in place. 0 for
equals, -1 if first arg is less than the second. 1 if first arg is greater than second.

## Terminal Operations:
These methods execute and return void, Optional, or boolean, hence, terminal or terminated. The stream ends here. Once a terminal operation is
executed, the stream is considered consumed.

collect() - converts the stream into a Collection.

anyMatch(Predicate) - finds the bare minimum match for a stream and returns true if it found any. Useful if you want to do a partial check for
efficiency.

allMatch(Predicate) - returns true only if all elements in the stream match the predicate. Useful if you want to make sure all the elements in the
stream pass a certain condition.

forEach(Consumer) - iterates over each item in the stream and executes an inline Consumer function.

reduce() - performs a reduction operation on the stream.
