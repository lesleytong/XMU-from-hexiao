package edu.ustb.sei.mde.query.infra;

import java.util.function.BiFunction;

import edu.ustb.sei.mde.query.indexing.Profile;

@FunctionalInterface
public interface ProfileComputer<T> extends BiFunction<T, Profile<T>, Profile<T>> {

}
